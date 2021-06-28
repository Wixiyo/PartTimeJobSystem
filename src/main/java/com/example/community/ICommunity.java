package com.example.community;

import com.example.result.ResponseData;

public interface ICommunity {
    ResponseData insertMessage(Message message);
}
