package jurlon.cjeditor.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/20 9:04
 * @FileName: NavigationBarVo
 * @Description
 */
@Getter
@Setter
@ToString
public class NavigationBarVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 6868395514200223547L;
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer priorityLevel;//优先级
    private String display;
    private List<NavigationBarVo> childrenList;
}
