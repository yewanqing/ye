package mail;

/**
 * Created by sh1 on 16-3-15.
 */
public class Test {
    public static void main(String[] args) {
        String str = "00004925|张世林|00004925|男|0|91901|副行长|13826013694|2015-01-20 16:12:34|zhangshilin@gzrcu.cn|||||||||村镇银行条线|管理序列|正式行员|1983-04-21|在职博士研究生|常宁珠江村镇银行|1068NS10000000000035|副经理级";
        String[] split = str.split("\\|");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(split.length);
    }


}
