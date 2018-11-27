package demos.example.code.tkmybaits.service.impl;

import demos.example.code.tkmybaits.mapper.UserMapper;
import demos.example.code.tkmybaits.service.UserService;
import demos.example.code.tkmybaits.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public PageInfo<User> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectAll());
        return pageInfo;
    }
}
