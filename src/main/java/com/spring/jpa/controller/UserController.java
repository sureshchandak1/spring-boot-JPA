package com.spring.jpa.controller;

import com.spring.jpa.entities.User;
import com.spring.jpa.model.ErrorResponseBody;
import com.spring.jpa.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService mUserService;

    public UserController(UserService mUserService) {
        this.mUserService = mUserService;
    }

    public ResponseEntity<?> save(
            @RequestParam("name") String name,
            @RequestParam("emailId") String emailId,
            @RequestParam("mobileNo") String mobileNo,
            @RequestParam("address") String address
    ) {

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        user.setEmailId(emailId);
        user.setMobileNo(mobileNo);
        user.setAddress(address);

        User saveUser = mUserService.save(user);

        if (saveUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorResponseBody.builder().success(false)
                            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message("User not saved!").build()
                    );
        }
    }
}
