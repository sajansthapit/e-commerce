package com.sajan.user.service.serviceImpl;

import com.sajan.user.domain.Users;
import com.sajan.user.repository.UsersRepository;
import com.sajan.user.service.UsersService;
import com.sajan.user.util.exception.NoSuchElementException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users findById(Long id) {
        Optional<Users> users = usersRepository.findById(id);
        return users.orElseThrow(() -> new NoSuchElementException("Users not found"));
    }
}
