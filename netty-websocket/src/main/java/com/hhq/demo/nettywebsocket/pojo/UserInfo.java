package com.hhq.demo.nettywebsocket.pojo;

import lombok.Data;

@Data
public class UserInfo {
    private String unique_id;
    private String account_id;
    private String nick_name;
    private Integer gold_count;
    private String avatar_url;
    private String openId;
    private String sex;
    private String isrobot;
    private String isoccupy;

    public UserInfo() {
    }

    public UserInfo(String unique_id, String account_id, String nick_name, Integer gold_count, String avatar_url, String openId, String sex, String isrobot, String isoccupy) {
        this.unique_id = unique_id;
        this.account_id = account_id;
        this.nick_name = nick_name;
        this.gold_count = gold_count;
        this.avatar_url = avatar_url;
        this.openId = openId;
        this.sex = sex;
        this.isrobot = isrobot;
        this.isoccupy = isoccupy;
    }
}
