package entity;

/**
 * Created by sh1 on 15-10-13.
 */
public enum Elvis {
    INSTANCE;
    public void leaveTheBuilding(){
        System.out.println(INSTANCE.name());
    }
}
