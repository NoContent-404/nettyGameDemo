package com.hhq.demo.nettywebsocket.Service;

import com.alibaba.fastjson.JSON;
import com.hhq.demo.nettywebsocket.enums.MessageEnums;
import com.hhq.demo.nettywebsocket.pojo.UserInfo;
import com.hhq.demo.nettywebsocket.pojo.vo.Player;
import com.hhq.demo.nettywebsocket.pojo.vo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameService {

    public Map<String, Player> playerList = new HashMap<>();
    public Map<String, Room> roomMap = new HashMap<>();

    @Autowired
    private UserService service;


    /**
     * 登录
     * @param nick_name
     * @param password
     * @return
     */
    public MessageEnums login(String nick_name , String password){
        UserInfo user = this.service.getUserInfoInfoByUsername(nick_name);

        if(!nick_name.equals(user.getNick_name()) && user == null){
            System.out.println("账号不存在");
            return MessageEnums.success(null);
        }else {
            Player player = new Player();
            player.CreatePlayer(user);
            this.playerList.put(player.nick_name,player);
            return MessageEnums.success(player);
        }
    }

    /**
     * 创建房间
     * @param nick_name
     * @return
     */

    public MessageEnums PlayerCreateRoom (String nick_name){

            if(playerList.get(nick_name) != null){
                Player player = playerList.get(nick_name);
                Room room = new Room();
                room.PlayerCreateRoom(player);
                player.setRoom(room);   //记录玩家所在房间
                System.out.println(player.getRoom());
                roomMap.put(room.getRoomId(), room);
                return MessageEnums.success(room);
            }

        return MessageEnums.success(null);

    }

//    public static void main(String[] args) {
//        Room room = new Room();
//        room.setRoomId("1111");
//        Player player = new Player();
//        player.nick_name="aa";
//        room.PlayerCreateRoom(player);
//        player.setRoom(room);
//        System.out.println(JSON.toJSONString(player));
//    }
}
