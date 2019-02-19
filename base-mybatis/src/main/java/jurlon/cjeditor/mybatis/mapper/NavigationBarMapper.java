package jurlon.cjeditor.mybatis.mapper;

import jurlon.cjeditor.mybatis.model.NavigationBar;

import java.util.List;


/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 17:12
 * @FileName: NavigationBarMapper
 * @Description
 */
public interface NavigationBarMapper {
    public List<NavigationBar> listByModel(NavigationBar model);
}
