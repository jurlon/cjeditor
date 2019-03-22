package jurlon.cjeditor.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/3/22 22:02
 * @FileName: CourseVo
 * @Description
 */
@Getter
@Setter
@ToString
public class CourseVo extends BaseVo{

    private static final long serialVersionUID = -7136774790956901148L;
    
    private Long id;
    private String name;
    private String tag;
    private String author;
    private String level;
    private String price;
    private String countPrice;
    private String desc;
    
    
}
