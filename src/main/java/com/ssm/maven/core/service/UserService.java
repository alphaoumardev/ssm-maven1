package com.ssm.maven.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.maven.core.entity.User;

public interface UserService
{
     User login(User user);

     List<User> findUser(Map<String, Object> map);

     Long getTotalUser(Map<String, Object> map);

     int updateUser(User user);

     int addUser(User user);

     void deleteUser(Integer id);
}
