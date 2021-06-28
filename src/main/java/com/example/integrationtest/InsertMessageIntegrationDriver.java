package com.example.integrationtest;

import com.example.community.ICommunity;
import com.example.community.Message;
import com.example.result.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.*;

@Controller
@RequestMapping("/insertMessageIntegration")
@Api(value = "集成测试对insertMessage接口测试")
public class InsertMessageIntegrationDriver {
    /**
     * 注入被测对象MessageService
     */
    @Resource
    private ICommunity messageService;

    /**
     * 一个系统中可用的用户ID是10006
     */
    private static final int SID = 10006;

    /**
     * @return 测试结果
     */
    @ApiOperation(value = "集成测试对insertMessage接口测试", response = String.class)
    @GetMapping("/insertMessageTest")
    @ResponseBody
    public Map<Object, Object> insertMessageTest() {
        Message message = new Message();
        HashMap<Object, Object> result = new HashMap<>();
        List<String> testResult = new ArrayList<>();
        List<String> res = new ArrayList<>();
        ResponseData responseData;

        /*对IT＿TD＿001_001测试*/
        message.setFrom("管理员");
        message.setText(null);
        message.setTo(SID);
        responseData = messageService.insertMessage(message);
        testResult.add(responseData.toString());
        res.add(responseData.getRspMsg());

        message.setFrom(null);
        message.setText("abc");
        message.setTo(SID);
        responseData = messageService.insertMessage(message);
        testResult.add(responseData.toString());
        res.add(responseData.getRspMsg());


        message.setFrom("管理员");
        message.setText("abc");
        message.setTo(null);
        responseData = messageService.insertMessage(message);
        testResult.add(responseData.toString());
        res.add(responseData.getRspMsg());

        /*对IT＿TD＿001_002测试*/
        message.setFrom("管理员");
        message.setText("abc");
        message.setTo(0);
        responseData = messageService.insertMessage(message);
        testResult.add(responseData.toString());
        res.add(responseData.getRspMsg());

        /*对IT＿TD＿001_003测试*/
        message.setFrom("管理员");
        message.setText("abc");
        message.setTo(SID);
        responseData = messageService.insertMessage(message);
        testResult.add(responseData.toString());
        res.add(responseData.getRspMsg());

        result.put("result", testResult);
        result.put("right", res);
        return result;
    }
}
