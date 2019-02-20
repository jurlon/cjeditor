package jurlon.cjeditor.service.impl;

import jurlon.cjeditor.common.service.INavigationBarService;
import jurlon.cjeditor.common.vo.NavigationBarVo;
import jurlon.cjeditor.mybatis.mapper.NavigationBarMapper;
import jurlon.cjeditor.mybatis.model.NavigationBar;
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
    private NavigationBar bar;
    
    public List<NavigationBarVo> listBy(){
        System.out.println(bar);
        NavigationBar model = new NavigationBar();
        List<NavigationBar> list = navigationBarMapper.listByModel(model);
        return modelListToVoList(list,NavigationBarVo.class);
    }
    
}
