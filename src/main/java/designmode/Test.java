package designmode;

/**
 * Created by sh1 on 16-3-17.
 */
public class Test {
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        LightCommond commond = new LightCommond(new Light());
        simpleRemoteControl.setCommond(commond);
        simpleRemoteControl.buttonWasPressed();
    }
}
