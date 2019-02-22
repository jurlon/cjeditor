package jurlon.cjeditor.common.handler;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/22 10:19
 * @FileName: ICacheHandler
 * @Description
 */
public interface ICacheHandler {
    
    public Object getValue(Object key);
    public void setValue(Object key,Object value);
    public void setValue(Object key,Object value,long timeoutSecond);

    public List getList(Object key);
    public void setList(Object key,List list);
    public void setList(Object key,List list,long timeoutSecond);

    public Map getHash(Object key);
    public Object getHashValue(Object key,Object hashKey);
    public void setHash(Object key,Map map);
    public void setHash(Object key,Map map,long timeoutSecond);
    public void setHashValue(Object key,Object hashKey,Object hashValue);
    public Set keySet(Object key);

    public boolean delete(Object key);
    
    public void init();
}
