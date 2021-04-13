package cn.twilight.test.javainstance.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {
    public static void main(String[] args) throws ParseException {
        //获取当前时间并格式化时间 使用SimpleDateFormat
        Date date = new Date();
        System.out.println(date);
        String dateFormat  = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        System.out.println(sdf.format(date));
        System.out.println("########");
        System.out.println("unix时间戳 : " + System.currentTimeMillis());
        //将unix时间戳转换为格式化时间
        Long timestamp = System.currentTimeMillis();//单位为毫秒
        String formatDate = new SimpleDateFormat(dateFormat, Locale.CHINA).format(new Date(timestamp));
        System.out.println(formatDate);
        //将指定格式时间转换为unix时间戳
        System.out.println("unix时间戳: " + sdf.parse(dateFormat).getTime());

    }
}
