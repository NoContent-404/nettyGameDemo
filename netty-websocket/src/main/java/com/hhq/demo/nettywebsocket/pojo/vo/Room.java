package com.hhq.demo.nettywebsocket.pojo.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Room  {

    private String roomId;
    private Player houseMaster;
    private Map<String, Player> playersList = new HashMap<>();


    public void PlayerCreateRoom (Player player) {
        this.roomId = "123456";
        this.playersList.put(player.nick_name,player);
        this.houseMaster = player;
    }
}
