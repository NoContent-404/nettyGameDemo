package com.hhq.demo.nettywebsocket.controller;

import com.alibaba.fastjson.JSON;
import com.hhq.demo.nettywebsocket.Service.GameService;
import com.hhq.demo.nettywebsocket.enums.MessageEnums;
import com.hhq.demo.nettywebsocket.pojo.vo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @Autowired
    private GameService service;

    @PostMapping(value = "/create")
    public MessageEnums<Room> createRoom(String nick_name){

        MessageEnums messageEnums = this.service.PlayerCreateRoom(nick_name);
        System.out.println("===================================================================================================");
        System.out.println("房间"+messageEnums.getData());
        System.out.println("===================================================================================================");
        return MessageEnums.success(messageEnums);
    }
//
//    @PostMapping(value = "/html/joinroom")
//    public String joinRoom (String username, String account_id, String roomid) {
//        UserInfo user = new UserInfo();
//        user.nick_name = username;
//        user.account_id =account_id;
//        String msg = this.roomManager.joinRoon(user, roomid);
//        return msg;
//    }

}
