package com.sajan.user.service;

import com.sajan.user.domain.Users;

public interface UsersService {

    Users save(Users users);

    Users findById(Long id);
}
