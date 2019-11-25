package com.hhq.demo.nettywebsocket.dao;

import com.hhq.demo.nettywebsocket.common.base.BaseDao;
import com.hhq.demo.nettywebsocket.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends BaseDao<UserInfo> {


    UserInfo getUserInfoByNickName(@Param("nick_name") String nick_name);

}