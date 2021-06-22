package com.example.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageMapper messageMapper;

    public List<Message> searchBySid(int sid) {
        return messageMapper.searchBySid(sid);
    }

    public void setMessageRead(int id) {
        messageMapper.setMessageRead(id);
        return;
    }

    public void insertMessage(Message message) {
        messageMapper.insertMessage(message);
        return;
    }

}
