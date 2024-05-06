package api.security.jwtsession5.jwtsession5.dao;

import api.security.jwtsession5.jwtsession5.entity.User;

public interface UserDao {

     User findUserByEmail(String email);
}
