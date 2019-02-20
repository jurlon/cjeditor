package jurlon.cjeditor.common.util;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/20 15:03
 * @FileName: StringUtil
 * @Description
 */
public class StringUtil {
    public static boolean isBlank(String str){
        return (str == null || "".equals(str)) ? true : false;
    }
}
