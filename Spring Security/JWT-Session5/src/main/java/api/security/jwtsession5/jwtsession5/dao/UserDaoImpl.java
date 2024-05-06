package api.security.jwtsession5.jwtsession5.dao;

import api.security.jwtsession5.jwtsession5.entity.User;

public class UserDaoImpl implements  UserDao{
    @Override
    public User findUserByEmail(String email) {
        // check for user by email in DB / wink ;)
        User user = new User(email ,"12345");
        user.setFirstName("salma");
        user.setLastName("sobhy");
        return user;
    }
}
