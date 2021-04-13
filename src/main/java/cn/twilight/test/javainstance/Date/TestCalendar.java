package cn.twilight.test.javainstance.Date;

import java.util.Calendar;

public class TestCalendar {
    public static void main(String[] args) {
        //操作日历类,获取年月及相关参数
        Calendar cal  = Calendar.getInstance();
        System.out.println("年份: " + cal.get(Calendar.YEAR));
        System.out.println("月份: " + (cal.get(Calendar.MONTH)+1));
        System.out.println("日期: " + cal.get(Calendar.DATE));
        System.out.println("一年中的第几天: " + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("一月中的第几天: " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("一周中的第几天: " + cal.get(Calendar.DAY_OF_WEEK));
//        System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
    }
}
