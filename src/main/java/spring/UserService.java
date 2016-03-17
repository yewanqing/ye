package spring;

import entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sh1 on 15-1-27.
 */

public interface UserService {
    void save();

    void save(String name, String employeeCode);

    void delete(String employeeCode);

    List<User> getUser(String employeeCode);

    void update(String employeeCode,String name) throws InterruptedException;
}
