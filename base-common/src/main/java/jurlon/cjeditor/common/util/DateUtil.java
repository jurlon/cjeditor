package jurlon.cjeditor.common.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: jurlon@163.com
 * @DateTime: 2019/2/20 15:03
 * @FileName: DateUtil
 * @Description
 */
@Slf4j
public class DateUtil {
    public static String DF_YMD_HMS = "yyyy-MM-dd HH:mm:ss";

    public static String dateToString(Date date){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DF_YMD_HMS);
            return sdf.format(date);
        }catch (Exception e){
            log.error("DateUtil.dateToString",e);
        }
        return null;
    }
    
    public static String dateToString(Date date,String pattern){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        }catch (Exception e){
            log.error("DateUtil.dateToString",e);     
        }
        return null;
    }
    
}
