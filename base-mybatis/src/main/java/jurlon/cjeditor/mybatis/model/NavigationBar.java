package jurlon.cjeditor.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 16:42
 * @FileName: NavigationBar
 * @Description 导航栏
 */
@Getter
@Setter
@ToString
public class NavigationBar extends BaseModel{
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer priorityLevel;
    private String display;
    private List<NavigationBar> childrenList;
}
