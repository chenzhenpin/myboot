package demos.example.code.tkmybaits.service;



import demos.example.code.tkmybaits.dao.User;

import java.util.List;

public interface TestService {
    void saveUser(User user);
    List<User> selectAllUser();
}
