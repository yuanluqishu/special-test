package com.dao;

import com.domain.User;

public interface LoginDao {
    public User LoginUsernamePassword(String username, String password);
}
