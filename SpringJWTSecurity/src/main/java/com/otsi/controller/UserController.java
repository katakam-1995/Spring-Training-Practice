package com.otsi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.model.ApiResponse;
import com.otsi.model.User;
import com.otsi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    private UserService userService;

    @RequestMapping(value="/usersList", method = RequestMethod.GET)
    public ApiResponse<Iterable<User>> listUser(){
    	 Iterable<User> list=userService.findAll();
    	return new ApiResponse<>(200, "success",list);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ApiResponse<Optional<User>> getOne(@PathVariable(value = "id") Integer id){
        Optional<User> user = userService.findById(id);
        return new ApiResponse<>(200, "success", user);
    }

}
