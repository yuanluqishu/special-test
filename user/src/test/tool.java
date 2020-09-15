package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class tool {
    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param formatStr 格式字符串，比如："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
}
