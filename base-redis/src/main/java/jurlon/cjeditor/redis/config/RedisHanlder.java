package jurlon.cjeditor.redis.config;

import jurlon.cjeditor.common.vo.NavigationBarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/21 17:33
 * @FileName: RedisHanlder
 * @Description
 */
@Component
public class RedisHanlder {
    @Autowired
    private ListOperations listOperations;
    
    public List<NavigationBarVo> getList(String key){
        return listOperations.range(key,0,-1);
    }
    public void setList(String key,List<NavigationBarVo> list){
        listOperations.rightPushAll(key,list);
    }
}
