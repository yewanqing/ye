package implTest;

import spring.UserService;

import javax.annotation.Resource;

/**
 * Created by sh1 on 15-11-30.
 */
public class UserThread implements Runnable {
    private UserService userService;
    public UserThread(UserService userService){
        this.userService = userService;
    }
    @Override
    public void run() {
        try {
            userService.update("ye2", "yewanqing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
