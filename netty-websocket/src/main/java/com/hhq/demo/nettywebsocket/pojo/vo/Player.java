package com.hhq.demo.nettywebsocket.pojo.vo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hhq.demo.nettywebsocket.pojo.UserInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Player {

    @Getter
    @Setter
    public String acction_id;
    @Getter
    @Setter
    public String nick_name;
    private Room room;


    public Player CreatePlayer (UserInfo user) {
        this.acction_id = user.getAccount_id();
        this.nick_name = user.getNick_name();
        return this;
    }


    public Room getRoom() {
        return room;
    }

    @JsonBackReference
    public void setRoom(Room room) {
        this.room = room;
    }


}
