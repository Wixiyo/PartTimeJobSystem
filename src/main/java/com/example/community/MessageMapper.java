package com.example.community;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {

    List<Message> searchBySid(int sid);
    void setMessageRead(int id);
    void insertMessage(Message message);

}
