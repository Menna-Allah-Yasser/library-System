package controller;

import entity.User;
import service.UserService;

public class UserController {

    private UserService userService = new UserService();

    public boolean authentication (){

       return userService.authentication();
    }

    public void addUser(){
        userService.addUser();
    }
}
