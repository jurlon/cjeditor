package jurlon.cjeditor.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/20 9:04
 * @FileName: NavigationBarVo
 * @Description
 */
@Getter
@Setter
@ToString
public class NavigationBarVo extends BaseVo{
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer priorityLevel;//优先级
    private String display;
}
