package com.sajan.user.controller;

import com.sajan.user.domain.Users;
import com.sajan.user.service.UsersService;
import com.sajan.user.util.HeaderUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/save")
    public ResponseEntity<Users> save(@RequestBody Users users) throws URISyntaxException {
        Users result = usersService.save(users);
        return ResponseEntity.created(new URI("/users/" + result.getId())).
                headers(HeaderUtil.createEntityCreationAlert("users"))
                .body(users);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Users> find(@PathVariable Long id) {
        Users result = usersService.findById(id);
        return ResponseEntity.ok().headers(HeaderUtil.getEntityAlert("Users"))
                .body(result);
    }

}
