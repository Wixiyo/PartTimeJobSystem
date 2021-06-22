package com.example.community;

import com.example.community.Message;
import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import com.example.community.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*", maxAge = 3600)//用于ajax访问
@Api(tags = "系统通知接口")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "根据学生编号获取消息")
    @GetMapping(value = "/get-by-sid/{sid}")
    ResponseData getBySid(@PathVariable int sid) {
        return new ResponseData(ExceptionMsg.SUCCESS, messageService.searchBySid(sid));
    }

    @ApiOperation(value = "将消息标记为已读")
    @GetMapping(value = "/set-message-read/{id}")
    ResponseData setMessageRead(@PathVariable int id) {
        messageService.setMessageRead(id);
        return new ResponseData(ExceptionMsg.SUCCESS, "Message Read!");
    }

    @ApiOperation(value = "新增系统消息")
    @PostMapping(value = "/add-message")
    ResponseData addMessage(Message message) {
        messageService.insertMessage(message);
        return new ResponseData(ExceptionMsg.SUCCESS, "Message added!");
    }


}
