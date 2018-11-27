package demos.example.code.tkmybaits.service;

import demos.example.code.tkmybaits.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

    PageInfo<User> selectAll(int pageNum, int pageSize);
}
