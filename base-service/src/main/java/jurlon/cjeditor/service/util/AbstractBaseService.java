package jurlon.cjeditor.service.util;

import jurlon.cjeditor.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/20 9:12
 * @FileName: AbstractBaseService
 * @Description
 */
@Slf4j
public abstract class AbstractBaseService {
    
    /**
     * @Author: jurlon@163.com
     * @Date: 2019/2/20 9:58
     * @Description: model 转 vo
     */
    public Object modelToVo(Object sourceObj,Class targetClass){
        try {
            Map<String,Method> sourceMethods = getReadMethod(sourceObj.getClass());
            Object targetObj = targetClass.newInstance();
            Method[] targetMethods = targetClass.getMethods();
            for(Method writeMethod : targetMethods){
                if(writeMethod.getName().startsWith("set")){
                    Method readMethod = sourceMethods.get("get"+writeMethod.getName().substring(3));
                    if(readMethod == null){
                        continue;
                    }
                    try {
                        Object returnObj = readMethod.invoke(sourceObj);
                        if(returnObj == null){
                            continue;
                        }
                        if(String.class.equals(readMethod.getReturnType())
                                ||Integer.class.equals(readMethod.getReturnType())
                                ||Long.class.equals(readMethod.getReturnType())){
                            writeMethod.invoke(targetObj,returnObj);
                        }
                        //Date转String
                        if(Date.class.equals(readMethod.getReturnType())){
                            writeMethod.invoke(targetObj, DateUtil.dateToString((Date) returnObj));
                        }
                        //暂时约定vo对象里面的list放的对象只能是自己 以后可用注解方式表明list存放的类类型
                        if(List.class.equals(readMethod.getReturnType())){
                            List returnList = (List) returnObj;
                            if(returnList.size()==0){
                                continue;
                            }
                            List voList = modelListToVoList(returnList,targetClass);
                            writeMethod.invoke(targetObj,voList);
                        }
                    } catch (InvocationTargetException e) {
                        log.error("AbstractBaseService.modelToVo",e);
                    }
                }
            }
            
            return targetObj;
        } catch (InstantiationException e) {
            e.printStackTrace();
            log.error("AbstractBaseService.modelToVo",e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            log.error("AbstractBaseService.modelToVo",e);
        }
        return null;
    }
    
    /**
     * @Author: jurlon@163.com
     * @Date: 2019/2/20 9:58
     * @Description: modelList 转 voList
     */
    public List modelListToVoList(List sourceList,Class targetClass){
        List list = new ArrayList();
        for(Object sourceObj : sourceList){
            Object obj = modelToVo(sourceObj,targetClass);
            list.add(obj);
        }
        return list;
    }
    private Map<String,Method> getReadMethod(Class c){
       Map<String,Method> map = new HashMap<>(); 
       for(Method m : c.getMethods()){
           if(m.getName().startsWith("get")){
               map.put(m.getName(),m);
           }
       }
       return map;
    }
}
