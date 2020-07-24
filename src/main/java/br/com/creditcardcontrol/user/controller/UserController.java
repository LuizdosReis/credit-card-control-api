package br.com.creditcardcontrol.user.controller;

import br.com.creditcardcontrol.user.Service.UserService;
import br.com.creditcardcontrol.user.dto.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/user";

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserRequest userRequest){
        userService.create(userRequest);
    }






}
