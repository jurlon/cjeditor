package jurlon.cjeditor.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/20 9:04
 * @FileName: BaseVo
 * @Description
 */
@Getter
@Setter
@ToString
public class BaseVo implements Serializable {
    private String createDatetime;
    private String createBy;
    private String updateDatetime;
    private String updateBy;
}
