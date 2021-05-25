package com.example.service;

import com.example.entity.Message;
import com.example.entity.Post;
import com.example.mapper.MessageMapper;
import com.example.mapper.PostMapper;
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