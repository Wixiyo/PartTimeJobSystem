package com.example.excise.handler;

import com.example.annotation.TestMethod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author panxiangyu
 * @date 2021年06月20日16:32
 */
@Controller
@Api(value = "根据类名获取练习的方法列表")
public class GetSolution {
    @ApiOperation(
            value = "根据类名获取方法以及相应方法注释，例如：{method:'f1()',description:'***'}",
            response = Map.class
    )
    @ApiImplicitParam(
            value = "类名,电信收费:Bill,万年历:NextDate,三角形:TriangleType,销售额:Commission",
            dataType = "String",
            paramType = "query"
    )
    @GetMapping("/getSolution")
    @ResponseBody
    public Map<String, Object> getName(String name) {
        String packageName = "com.example.excise.solution.";
        Map<String, Object> map = new HashMap<>();
        try {
            /*获取类*/
            Class<?> solution = Class.forName(packageName + name);
            /*获取方法*/
            Method[] methods = solution.getMethods();
            TestMethod annotation;
            for (Method method : methods) {
                annotation = method.getAnnotation(TestMethod.class);
                if (annotation != null) {
                    map.put("method", annotation.value());
                    map.put("description", annotation.description());
                    break;
                }
            }
            map.put("code", "200");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            map.put("code", "500");
        }
        return map;
    }
}
