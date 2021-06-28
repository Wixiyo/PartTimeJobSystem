package com.example.community;

import com.example.student.StudentMapper;
import com.example.result.ExceptionMsg;
import com.example.result.ResponseData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageService implements ICommunity{
    /**
     * 注入消息管理DAO
     */
    @Resource
    private MessageMapper messageMapper;
    /**
     * 注入学生管理DAO
     */
    @Resource
    private StudentMapper studentMapper;

    /**
     * 根据学生ID查询消息
     * @param sid 学生ID
     * @return 消息内容
     */
    public List<Message> searchBySid(int sid) {
        return messageMapper.searchBySid(sid);
    }

    /**
     * 根据学生ID将学生的消息标记为已读
     * @param id 学生ID
     */
    public void setMessageRead(int id) {
        messageMapper.setMessageRead(id);
    }

    /**
     * 新增一条系统消息
     * @param message 消息内容from：消息发送者，to:消息接受者，text:消息内容
     * @return 操作结果
     */
    public ResponseData insertMessage(Message message) {
        message.setState(0);
        if (message.getTo() == null) {
            return new ResponseData(ExceptionMsg.FAILED, "消息接受者不能为空");
        } else if (message.getText() == null) {
            return new ResponseData(ExceptionMsg.FAILED, "消息内容不能为空");
        } else if (message.getFrom() == null) {
            return new ResponseData(ExceptionMsg.FAILED, "消息发送者不能为空");
        } else if (studentMapper.getStudentWithSId(message.getTo()) != null) {
            messageMapper.insertMessage(message);
            return new ResponseData(ExceptionMsg.SUCCESS, "消息发送成功");
        } else {
            return new ResponseData(ExceptionMsg.FAILED, "消息接受者不存在");
        }
    }

}
