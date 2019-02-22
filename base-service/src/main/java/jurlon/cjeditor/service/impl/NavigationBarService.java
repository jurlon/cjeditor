package jurlon.cjeditor.service.impl;

import jurlon.cjeditor.common.service.INavigationBarService;
import jurlon.cjeditor.common.vo.NavigationBarVo;
import jurlon.cjeditor.mybatis.mapper.NavigationBarMapper;
import jurlon.cjeditor.mybatis.model.NavigationBar;
import jurlon.cjeditor.redis.config.RedisHanlder;
import jurlon.cjeditor.service.util.AbstractBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 17:22
 * @FileName: NavigationBarService
 * @Description
 */
@Slf4j
@Service
public class NavigationBarService extends AbstractBaseService implements INavigationBarService {
    @Autowired
    private NavigationBarMapper navigationBarMapper;
    @Autowired
    private RedisHanlder redisHanlder;
    
    public static final String TABLE_NAME = "NAVIGATION_BAR";
    
    public List<NavigationBarVo> listAllAble(){
        List<NavigationBarVo> voList = redisHanlder.getList(TABLE_NAME);
        if(voList == null || voList.size() == 0){
            List<NavigationBar> list = navigationBarMapper.listFirstLevel();
            for(NavigationBar bar : list){
                bar.setChildrenList(navigationBarMapper.listByParentId(bar.getId()));
            }
            voList = modelListToVoList(list,NavigationBarVo.class);
            redisHanlder.setList(TABLE_NAME,voList);
            log.info("key={},value={}", TABLE_NAME,voList);
        }
        return voList;
    }
    
}
