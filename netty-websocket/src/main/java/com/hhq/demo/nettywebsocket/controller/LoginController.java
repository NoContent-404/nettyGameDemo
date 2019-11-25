package com.hhq.demo.nettywebsocket.controller;


import com.hhq.demo.nettywebsocket.Service.GameService;
import com.hhq.demo.nettywebsocket.enums.MessageEnums;
import com.hhq.demo.nettywebsocket.pojo.vo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/html")
public class LoginController {





    @Autowired
    private GameService service;


    @PostMapping(value = "/login")
    @ResponseBody
    public MessageEnums<Player> loginmain(String nick_name , String password){
        MessageEnums user = this.service.login(nick_name,password);
        System.out.println(user);
        System.out.println("登录成功!");
        return MessageEnums.success(user);
    }


}
