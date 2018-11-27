package demos.example.code.tkmybaits.service.impl;


import demos.example.code.tkmybaits.mapper.TestMapper;
import demos.example.code.tkmybaits.service.TestService;
import demos.example.code.tkmybaits.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;
    @Override
    public void saveUser(User user) {
        if (user !=null){
            testMapper.saveUser(user);
        }

    }

    @Override
    public List<User> selectAllUser() {
        return testMapper.selectAllUser();
    }
}
