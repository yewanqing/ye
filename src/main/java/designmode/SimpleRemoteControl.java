package designmode;

/**
 * Created by sh1 on 16-3-17.
 */
public class SimpleRemoteControl {
    private Commond commond;

    public void setCommond(Commond commond){
        this.commond = commond;
    }

    public void buttonWasPressed(){
        commond.execute();
    }
}
