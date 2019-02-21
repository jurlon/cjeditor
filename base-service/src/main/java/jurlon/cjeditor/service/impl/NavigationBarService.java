package jurlon.cjeditor.service.impl;

import jurlon.cjeditor.common.service.INavigationBarService;
import jurlon.cjeditor.common.vo.NavigationBarVo;
import jurlon.cjeditor.mybatis.mapper.NavigationBarMapper;
import jurlon.cjeditor.mybatis.model.NavigationBar;
import jurlon.cjeditor.redis.config.RedisHanlder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 17:22
 * @FileName: NavigationBarService
 * @Description
 */
@Service
public class NavigationBarService extends AbstractBaseService implements INavigationBarService {
    @Autowired
    private NavigationBarMapper navigationBarMapper;
    @Autowired
    private RedisHanlder redisHanlder;
    
    public static final String REDIS_KEY = "NAVIGATION_BAR";
    
    public List<NavigationBarVo> listAllAble(){
        List<NavigationBarVo> voList = redisHanlder.getList(REDIS_KEY);
        if(voList == null || voList.size() == 0){
            List<NavigationBar> list = navigationBarMapper.listFirstLevel();
            for(NavigationBar bar : list){
                bar.setChildrenList(navigationBarMapper.listByParentId(bar.getId()));
            }
            voList = modelListToVoList(list,NavigationBarVo.class);
            redisHanlder.setList(REDIS_KEY,voList);
        }
        return voList;
    }
    
}
