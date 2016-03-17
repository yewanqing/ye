package extend;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by sh1 on 15-9-9.
 */
public class Drawing extends Art {
//    protected String name = "yewanqing";
    public Drawing(){
        System.out.println("Drawing constructor");
    }

    public void f(){
        System.out.println("public f()");
    }

    public int filed = 1;
    public int getFiled(){
        return filed;
    }

    public int getSuperFiled(){
        return super.filed;
    }

    public static void get(String... userId){
        System.out.println(userId);
    }

    public static String getSpecifiedDayByNum(Date date, int num) {
        Calendar c = Calendar.getInstance();
        if (date != null) {
            c.setTime(date);
        }

        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + num);

        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    public static Date getSpecifiedDateByDays(Date specifiedDay, int dayCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(specifiedDay);
        calendar.add(Calendar.DAY_OF_YEAR, dayCount);
        return calendar.getTime();
    }

    private static String formatDateTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if(time==null ||"".equals(time)){
            return "";
        }
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar current = Calendar.getInstance();

        Calendar today = Calendar.getInstance();	//今天

        today.set(Calendar.YEAR, current.get(Calendar.YEAR));
        today.set(Calendar.MONTH, current.get(Calendar.MONTH));
        today.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
        today.set( Calendar.HOUR_OF_DAY, 0);
        today.set( Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);

        Calendar yesterday = Calendar.getInstance();	//昨天

        yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
        yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
        yesterday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH)-1);
        yesterday.set( Calendar.HOUR_OF_DAY, 0);
        yesterday.set( Calendar.MINUTE, 0);
        yesterday.set(Calendar.SECOND, 0);
        Calendar currentYear = Calendar.getInstance();
        currentYear.set(Calendar.YEAR,current.get(Calendar.YEAR));
        currentYear.set(Calendar.MONTH, 0);
        currentYear.set(Calendar.DAY_OF_MONTH,1);
        currentYear.set( Calendar.HOUR_OF_DAY,0);
        currentYear.set( Calendar.MINUTE, 0);
        currentYear.set(Calendar.SECOND, 0);
        System.out.println(format.format(currentYear.getTime()));
        current.setTime(date);
        if(current.before(currentYear)){
            return time;
        }

        else if(current.after(today)){
            return "今天 "+time.split(" ")[1];
        }else if(current.before(today) && current.after(yesterday)){
            return "昨天 "+time.split(" ")[1];
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
//        Art art = new Drawing();
//        System.out.println("art.filed="+art.filed +",art.getFiled="+art.getFiled());
//        Drawing drawing = new Drawing();
//        System.out.println("drawing.filed="+drawing.filed +",drawing.getFiled="+drawing.getFiled()
//                +",drawing.getSuperFiled()="+drawing.getSuperFiled());
//          get("ye","wan","qing");

//        System.out.println(StringUtils.isEmpty("sdf"));
//        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
//        System.out.println(sdf.format(new Date()));
//        System.out.println(getSpecifiedDateByDays(new Date(),-1));
//        System.out.println(formatDateTime("2015-09-17 15:36"));
//        System.out.println(formatDateTime("2015-08-16 15:36"));
//        System.out.println(formatDateTime("2014-09-16 19:36"));
        System.out.println(String.valueOf(0));
    }
}
