package designmode;

/**
 * Created by sh1 on 16-3-17.
 */
public class LightCommond implements Commond {
    private Light light;

    public LightCommond(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
