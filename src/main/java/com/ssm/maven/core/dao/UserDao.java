package com.ssm.maven.core.dao;

import com.ssm.maven.core.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface UserDao
{

     User login(User user);

     List<User> findUsers(Map<String, Object> map);

     Long getTotalUser(Map<String, Object> map);

     int updateUser(User user);

     int addUser(User user);

     int deleteUser(Integer id);
}
