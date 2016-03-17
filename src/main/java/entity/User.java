package entity;

/**
 * Created by sh1 on 14-11-6.
 */
public class User {
    private String name;
    private String userName;
    private String userId;
    private String employeeCode;
    private String createTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void playWith(User user) {
        System.out.println(user.name);
    }

    public String toString(){
        return "userId:"+userId+","+"userName:"+userName+",employeeCode:"+employeeCode+","+"createTime:"+createTime;
    }
}
