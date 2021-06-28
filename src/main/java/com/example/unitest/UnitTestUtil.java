package com.example.unitest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panxiangyu
 * @date 2021年06月28日21:33
 */
@Controller
@Api(value = "获取单元测试信息")
public class UnitTestUtil {
    @GetMapping("/getUnit")
    @ApiOperation(value = "根据单元测试类返回单元测试信息,{content:[],method:[],result:[]}",response = Map.class)
    @ApiImplicitParam(
            value = "单元测试类名,JobService,StudentCoJobService,AnalyseTagsService",
            name="name",paramType = "query",
            dataType = "String"
    )
    @ResponseBody
    public Map<String,Object>getUnit(@RequestParam(name = "name",defaultValue = "JobService")String name){
        Map<String,Object>map=new HashMap<>();
        List<UnitTestContent>contents=new ArrayList<>();
        List<UnitTestMethod>methods=new ArrayList<>();
        List<UnitTestMethod>results=new ArrayList<>();
        if(name.equals("JobService")){
            contents.add(new UnitTestContent("模块","兼职管理模块"));
            contents.add(new UnitTestContent("驱动器","JobForStuDriver"));
            contents.add(new UnitTestContent("单元测试脚本","JobForStuUnitTest"));
            contents.add(new UnitTestContent("桩","JobForStuStub"));
            contents.add(new UnitTestContent("被测对象","JobService"));
            contents.add(new UnitTestContent("被测方法","jobForStu"));
            methods.add(new UnitTestMethod("busId","String","兼职编号",""));
            methods.add(new UnitTestMethod("sid","int","学生编号",""));
            results.add(new UnitTestMethod("code","int","code=500意味着兼职编号或者学生编号不存在",""));
            results.add(new UnitTestMethod("isApply","int","是否申请该兼职,-1:未申请,1:已申请",""));
            results.add(new UnitTestMethod("isInterest","int","是否收藏该兼职,0:未收藏,1:已收藏",""));
            results.add(new UnitTestMethod("numOfApply","int","该兼职的申请总数",""));
        }else if(name.equals("StudentCoJobService")){
            contents.add(new UnitTestContent("模块","兼职管理模块"));
            contents.add(new UnitTestContent("驱动器","UpdateStuCoJobDriver"));
            contents.add(new UnitTestContent("单元测试脚本","UpdateStuCoJobUnitTest"));
            contents.add(new UnitTestContent("桩","UpdateStuCoJobStub"));
            contents.add(new UnitTestContent("被测对象","StudentCoJobService"));
            contents.add(new UnitTestContent("被测方法","updateStuCoJob"));
            methods.add(new UnitTestMethod("state","int","学生所申请的兼职的状态",""));
            methods.add(new UnitTestMethod("sid","int","学生编号",""));
            results.add(new UnitTestMethod("string","string","说明方法是否执行成功(原函数无返回值，这里将函数中的一些处理作为输出返回)",""));
        }else{
            contents.add(new UnitTestContent("模块","兼职分析模块"));
            contents.add(new UnitTestContent("驱动器","AnalyseTagsDriver"));
            contents.add(new UnitTestContent("单元测试脚本","AnalyseTagsUnitTest"));
            contents.add(new UnitTestContent("桩","AnalyseTagsStub"));
            contents.add(new UnitTestContent("被测对象","AnalyseTagsService"));
            contents.add(new UnitTestContent("被测方法","analyseTags"));
            methods.add(new UnitTestMethod("sid","int","学生编号",""));
            results.add(new UnitTestMethod("list","ArrayList","返回通过标签分析得到的兼职列表，这里采用大写字母代表一个兼职",""));
        }
        map.put("content",contents);
        map.put("result",results);
        map.put("method",methods);
        return map;
    }
}
