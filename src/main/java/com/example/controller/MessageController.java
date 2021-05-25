package com.example.controller;

import com.example.entity.Message;
import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import com.example.service.JobService;
import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/get-by-sid/{sid}", method = RequestMethod.GET)
    ResponseData getBySid(@PathVariable int sid) {
        return new ResponseData(ExceptionMsg.SUCCESS, messageService.searchBySid(sid));
    }

    @RequestMapping(value = "/set-message-read/{id}", method = RequestMethod.GET)
    ResponseData setMessageRead(@PathVariable int id) {
        messageService.setMessageRead(id);
        return new ResponseData(ExceptionMsg.SUCCESS, "Message Read!");
    }

    @RequestMapping(value = "/add-message", method = RequestMethod.POST)
    ResponseData addMessage(Message message) {
        messageService.insertMessage(message);
        return new ResponseData(ExceptionMsg.SUCCESS, "Message added!");
    }


}
