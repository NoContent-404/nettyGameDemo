package com.hhq.demo.nettywebsocket.enums;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class MessageEnums<T> {

    private boolean success;
    private T data;


    public MessageEnums() {
        this.success = true;
    }

    public MessageEnums(String data) {
        this.success = false;
    }

    public MessageEnums(T data) {
        this.data = data;
        if(data == null){
            this.success = false;
        }else {
            this.success = true;
        }

    }


    public static MessageEnums success(){
        return new MessageEnums();
    }


    public static MessageEnums success(Object data){
        return new MessageEnums(data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
