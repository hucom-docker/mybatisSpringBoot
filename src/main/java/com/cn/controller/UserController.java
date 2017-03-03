
package com.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.model.User;
import com.cn.service.UserService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public PageInfo<User> getAll(User user) {
        List<User> userList = userService.getAll(user);
        return new PageInfo<User>(userList);
    }
    
    @RequestMapping(value = "/view/{id}")
    public User getUserById(@PathVariable Integer id){
    	User user=userService.getUserById(id);
    	return user;
    }
    
    @RequestMapping(value = "/list/{name}")
    public List<User> getUserList(@PathVariable String name,@RequestParam String age){
    	User user=new User();
    	user.setAge(age);
    	user.setName(name);
    	List<User> userList=userService.getUserList(user);
    	return userList;
    }
    
    @RequestMapping(value="/add")
    public void addUser(){
    	User user=new User();
    	user.setId(7);
    	user.setName("dev1");
    	user.setAge("12");
    	user.setPassword("123456");
    	userService.addUser(user);
    }
    
    @RequestMapping(value="/del/{id}")
    public void delUser(@PathVariable Integer id){
    	User user=new User();
    	user.setId(id);
    	userService.delUser(user);
    }
    
    @RequestMapping(value="/update/{id}")
    public void updateUser(@PathVariable Integer id,@RequestParam String name){
    	User user=new User();
    	user.setId(id);
    	user.setName(name);
    	userService.updateUser(user);
    }

   
}
