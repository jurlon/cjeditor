package jurlon.cjeditor.redis.config;

import jurlon.cjeditor.common.handler.ICacheHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/21 17:33
 * @FileName: RedisHanlder
 * @Description
 */
@Slf4j
@Component
public class RedisHanlder implements ICacheHandler {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ValueOperations valueOperations;
    @Autowired
    private ListOperations listOperations;
    @Autowired
    private HashOperations hashOperations;
    @Autowired
    private RedisProperties redisProperties;
    
    @Override
    public Object getValue(Object key){
        return valueOperations.get(redisProperties.getRedisPrefix()+key);
    }
    @Override
    public void setValue(Object key,Object value){
        valueOperations.set(redisProperties.getRedisPrefix()+key,value);
    }
    @Override
    public void setValue(Object key,Object value,long timeoutSecond){
        valueOperations.set(redisProperties.getRedisPrefix()+key,value,timeoutSecond, TimeUnit.SECONDS);
    }
    
    @Override
    public List getList(Object key){
        return listOperations.range(redisProperties.getRedisPrefix()+key,0,-1);
    }
    @Override
    public void setList(Object key,List list){
        listOperations.rightPushAll(redisProperties.getRedisPrefix()+key,list);
    }
    @Override
    public void setList(Object key,List list,long timeoutSecond){
        listOperations.rightPushAll(redisProperties.getRedisPrefix()+key,list);
        redisTemplate.expire(redisProperties.getRedisPrefix()+key,timeoutSecond, TimeUnit.SECONDS);
    }

    @Override
    public Map getHash(Object key){
        return hashOperations.entries(redisProperties.getRedisPrefix()+key);
    }
    @Override
    public Object getHashValue(Object key,Object hashKey){
        return hashOperations.get(redisProperties.getRedisPrefix()+key,hashKey);
    }
    @Override
    public void setHash(Object key,Map map){
        hashOperations.putAll(redisProperties.getRedisPrefix()+key,map);
    }
    @Override
    public void setHash(Object key,Map map,long timeoutSecond){
        hashOperations.putAll(redisProperties.getRedisPrefix()+key,map);
        redisTemplate.expire(redisProperties.getRedisPrefix()+key,timeoutSecond, TimeUnit.SECONDS);
    }
    @Override
    public void setHashValue(Object key,Object hashKey,Object hashValue){
        hashOperations.put(redisProperties.getRedisPrefix()+key,hashKey,hashValue);
    }
    @Override
    public Set keySet(Object key){
        return hashOperations.keys(redisProperties.getRedisPrefix()+key);
    }

    @Override
    public boolean delete(Object key){
        return redisTemplate.delete(redisProperties.getRedisPrefix()+key);
    }

    @Override
    public void init() {
        log.info("redis init");
        Set keySet =  redisTemplate.keys(redisProperties.getRedisPrefix()+"*");
        if(keySet == null || keySet.size() ==0){
            return;
        }
        log.info("keys:{}删除成功。",keySet);
        redisTemplate.delete(keySet);
    }
}
