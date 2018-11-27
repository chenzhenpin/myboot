package demos.example.code.tkmybaits;


import demos.example.code.tkmybaits.dao.User;
import demos.example.code.tkmybaits.service.TestService;
import demos.example.code.tkmybaits.service.UserService;

import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional//事务
@Rollback //回滚，只用于测试
public class TkMybaitsTest {

    @Autowired
    TestService testService;

     @Autowired
     UserService userService;

    @Test
    public void test1() {
//        testService.saveUser(new User(43,"林","女",37));
        List<User> users = testService.selectAllUser();
        for (User user : users) {
            System.out.println(user.getAge());
        }
    }
     @Test
    public void test2() {
//        testService.saveUser(new User(43,"林","女",37));
        PageInfo<demos.example.code.tkmybaits.entity.User> users = userService.selectAll(1,2);
        for (demos.example.code.tkmybaits.entity.User user : users.getList()) {
            System.out.println(user.getAge());
        }
    }
}
