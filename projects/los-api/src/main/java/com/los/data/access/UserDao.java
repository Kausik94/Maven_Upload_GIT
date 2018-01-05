package com.los.data.access;

import com.los.entity.User;
import java.util.List;

/**
 * Created by nuwantha on 11/10/16.
 */
public interface UserDao {

    void updateUserAccount(User user);
    void createUserAccount(User user);
    List<User> getAllUsers();
    User getUserByName(String name);
    User getUserById(int id);
    User getUserByEmail(String email);
    int getUserCount();
    boolean isUserHasAccount(String userName);
    List getUserHasNotLeaveToday();
    boolean isUserHasAccountByEmail(String email);

}
