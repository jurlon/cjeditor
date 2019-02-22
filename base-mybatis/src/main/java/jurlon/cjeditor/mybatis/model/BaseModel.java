package jurlon.cjeditor.mybatis.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/19 16:43
 * @FileName: BaseModel
 * @Description
 */
@Getter
@Setter
@ToString
public class BaseModel  {
    private Date createDatetime;
    private String createBy;
    private Date updateDatetime;
    private String updateBy;
}
