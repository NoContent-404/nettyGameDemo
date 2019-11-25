package com.hhq.demo.nettywebsocket.Service;


import com.hhq.demo.nettywebsocket.dao.UserDao;
import com.hhq.demo.nettywebsocket.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 账号查询
     * @param nick_name
     * @return
     */
    public UserInfo getUserInfoInfoByUsername(String nick_name){
        return this.userDao.getUserInfoByNickName(nick_name);
    }
}
