package implTest;

import entity.User;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import spring.StudentService;
import spring.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sh1 on 15-5-8.
 */
public class UserServiceImplTest extends BaseTest {
    @Resource
    private UserService userService;
    @Autowired(required=false)
    private StudentService studentService;
    protected static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Test
    public void testSave() throws InterruptedException {
      userService.save();
    }

    @Test
    public void testDelete() {
//        userService.delete("ye1");
        executorService.execute(new UserThread(userService));

//        Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    userService.update("ye2", "yewanqing");
//                } catch (InterruptedException e) {
//                    System.out.println("33333");
//                }
//            }
//        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                List<User> users = userService.getUser("ye2");
                for (User user : users) {
                    System.out.println(user);
                }
            }
        };
//        Thread thread1 = new Thread(runnable1, "thread1");
//        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new Thread(runnable2, "thread2");
        executorService.execute(thread2);
//        thread2.start();
    }

}
