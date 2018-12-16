package com.example.secondkill.miaosha.redis;

public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
