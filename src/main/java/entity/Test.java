package entity;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sh1 on 15-6-12.
 */
public class Test {
    public static void main(String[] args) {
//        String a = "sdf";
//        StringUtils.isEmpty(a);
//        Elvis.INSTANCE.leaveTheBuilding();
//        user.name
//        List<String> parameterList = new ArrayList<String>();
//        //匹配 @xxx@ 格式
//        String regex = "@[a-zA-Z]+([_\\.][a-zA-Z]+){0,3}@|[a-zA-Z]+([_\\.][a-zA-Z]+){0,3}";
//        Pattern p = Pattern.compile(regex);
        // 用Pattern类的matcher()方法生成一个Matcher对象
//        Matcher m = p.matcher("尊敬的@TIP_TARGET@：您在积分商城中兑换的商品@GOODS_NAME@，数量@TRADE_COUNT@件，已经交易成功，如果非本人操作，请联系管理员。");
//        Matcher m = p.matcher("您的可用短信数量即将不足");
//        boolean result = m.find();
//        System.out.println(result);
//        for(int i=0;i<10000;i++){
//            System.out.println((int)Math.floor((Math.random()*10000.0)));
//        }

        Long start = 1448869870532l;
        Long end = 1451184165000l;
        long x = (end - start) / 1000;
        System.out.println((int)x);
        System.out.println((int)2147483647l);
//        -2147483648   到2147483648
        System.out.println(Integer.parseInt(21474836l+""));
    }



}
