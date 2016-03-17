package spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.*;
import java.util.UUID;

/**
 * Created by sh1 on 15-6-18.
 */
@Service("dogService")
public class DogServiceImpl implements DogService {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    @Transactional(readOnly = false,propagation= Propagation.SUPPORTS )
    public void save() {
        Object [] params = new Object[]{UUID.randomUUID().toString().replace("-", ""),"name","name"};
        jdbcTemplate.update("insert into t_ye_user values (?,?,?)",params);
        int i = 1/0;
//        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("D:/eeeee")));
    }

    @Override
    public void delete() {

    }
}
