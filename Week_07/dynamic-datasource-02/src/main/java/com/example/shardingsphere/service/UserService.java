package com.example.shardingsphere.service;

import com.example.shardingsphere.mapper.UserMapper;
import com.example.shardingsphere.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public void addUser(User user) {
        int i = userMapper.insert(user);
    }

    public List<User> getAll() {
        return userMapper.selectAll();
    }
}
