package jurlon.cjeditor.service;

import jurlon.cjeditor.mybatis.model.NavigationBar;

import java.util.List;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 18:11
 * @FileName: INavigationBarService
 * @Description
 */
public interface INavigationBarService {
    public List<NavigationBar> listBy();
}
