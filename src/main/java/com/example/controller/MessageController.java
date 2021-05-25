package com.example.controller;

import com.example.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
public class MessageController {
    @Autowired
    private MessageService messageService;


}
