package spring;

import entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sh1 on 15-12-26.
 */
public class StudentServiceImpl implements  UserService{
    @Override
    public void save() {

    }

    @Override
    public void save(String name, String employeeCode) {

    }

    @Override
    public void delete(String employeeCode) {

    }

    @Override
    public List<User> getUser(String employeeCode) {
        return null;
    }

    @Override
    public void update(String employeeCode, String name) throws InterruptedException {

    }
}
