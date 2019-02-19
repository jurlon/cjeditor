package jurlon.cjeditor.service.impl;

import jurlon.cjeditor.mybatis.mapper.NavigationBarMapper;
import jurlon.cjeditor.mybatis.model.NavigationBar;
import jurlon.cjeditor.service.INavigationBarService;
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
public class NavigationBarService  implements INavigationBarService {
    @Autowired
    private NavigationBarMapper navigationBarMapper;
    
    public List<NavigationBar> listBy(){
        NavigationBar model = new NavigationBar();
        List<NavigationBar> list = navigationBarMapper.listByModel(model);
        return list;
    }
    
}
