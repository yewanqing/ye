package activemq;

import entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.UserService;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by sh1 on 15-1-27.
 */
public class UserServiceImpl implements UserService {
    @Resource
    private JdbcTemplate jdbcTemplate;
    private boolean flag = false;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save() {
        Object[] params = new Object[]{UUID.randomUUID().toString().replace("-", ""), "ye", "ye"};
        jdbcTemplate.update("insert into t_ye_user values (?,?,?)", params);
//        dogService.save();
        try {
//            dogService.save();
//            int i = 1/0;
        } catch (Exception e) {

        }

//        int i = 1/0;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(String name, String employeeCode) {
        Object[] params = new Object[]{UUID.randomUUID().toString().replace("-", ""), name, employeeCode, new Date()};
        jdbcTemplate.update("insert into t_ye_user values (?,?,?,?)", params);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(String employeeCode) {
        Object[] params = new Object[]{employeeCode};
        jdbcTemplate.update("delete from t_ye_user where employee_code = ?", params);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public List<User> getUser(String employeeCode) {
        Object[] params = new Object[]{employeeCode};
        List list = jdbcTemplate.query("select * from t_ye_user where employee_code =?", params, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Map u = new HashMap();
                u.put("userId", rs.getString("user_id"));
                u.put("userName", rs.getString("user_name"));
                u.put("employeeCode", rs.getString("employee_code"));
                u.put("createTime", rs.getString("create_time"));
                return u;
            }
        });

        Iterator it = list.iterator();
        List<User> users = new ArrayList<User>();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            User user = new User();
            user.setUserId((String) map.get("userId"));
            user.setUserName((String) map.get("userName"));
            user.setEmployeeCode((String) map.get("employeeCode"));
            user.setCreateTime((String) map.get("createTime"));
            users.add(user);
        }
        return users;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED,isolation = Isolation.READ_UNCOMMITTED)
    public void update(String employeeCode, String name) throws InterruptedException {
        Object[] params = new Object[]{name, employeeCode};
        jdbcTemplate.update("update t_ye_user set user_name = ? where employee_code = ?", params);
//        Thread.sleep(6000);
//        System.out.println("111111");
//        int i = 1/0;
    }


}
