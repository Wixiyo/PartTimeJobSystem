package com.example.unitest;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panxiangyu
 * 2021年06月24日0:16
 * AnalyseTags单元测试脚本
 */
public class AnalyseTagsUnitTest extends TestCase {
    public static Map<String,Object>UT_TC_001_002_Equiv(){
        Map<String,Object>map=new HashMap<>();
        List<String> res=new ArrayList<>();
        List<Boolean> list = new ArrayList<>();
        /*UT_TC_002_001_001,输入学生编号不存在，输出空列表,sid=1,[]*/
        String string=AnalyseTagsService.analyseTags(1).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("[]"));

        /*UT_TC_002_001_002,输入学生编号存在，正常返回兼职标签列表,sid=3,["A";"B"]*/
        string=AnalyseTagsService.analyseTags(3).toString();
        res.add(string.replaceAll(",",";"));
        list.add(string.equals("[A,B]"));
        map.put("result",res);
        map.put("right",list);
        return map;
    }
    public static Map<String,Object>UT_TC_001_002_Statement(){
        Map<String,Object>map=new HashMap<>();
        List<String> res=new ArrayList<>();
        List<Boolean> list = new ArrayList<>();

        /*UT_TC_002_001_003,输入学生编号得到其所收藏的兼职列表为空,sid=2,[]*/
        String string=AnalyseTagsService.analyseTags(1).toString();
        res.add(string.replaceAll(",",";"));
        list.add(string.equals("[]"));

        /*UT_TC_002_001_004,输入学生编号得到其收藏的兼职列表其中标签类别数小于5,sid=3,["A";"B"]*/
        string=AnalyseTagsService.analyseTags(3).toString();
        res.add(string.replaceAll(",",";"));
        list.add(string.equals("[A,B]"));

         /*UT_TC_002_001_006,输入学生编号得到其兼职列表不为空但标签类别数大于5,sid=4,["A";"B";"C";"D";"E"]*/
        string=AnalyseTagsService.analyseTags(5).toString();
        res.add(string.replaceAll(",",";"));
        list.add(string.equals("[A,B,C,D,E]"));
        map.put("result",res);
        map.put("right",list);
        return map;
    }
    public static Map<String,Object>UT_TC_001_002_Path(){
        Map<String,Object>map=new HashMap<>();
        List<String> res=new ArrayList<>();
        List<Boolean> list = new ArrayList<>();

        /*UC_TC_002_001_007,输入学生编号得到其所收藏的兼职列表为空,sid=2,[]*/
        String string=AnalyseTagsService.analyseTags(2).toString();
        res.add(string);
        list.add(string.equals("[]"));

        /*UC_TC_002_001_008,输入学生编号得到其收藏的兼职列表其中标签类别数小于5,sid=3,["A;"B"]*/
        string=AnalyseTagsService.analyseTags(3).toString();
        res.add(string.replaceAll(",",";"));
        list.add(string.equals("[A,B]"));

        /*UC_TC_002_001_0010,输入学生编号得到其兼职列表不为空但标签类别数大于5,sid=4,["A";"B";"C";"D";"E"]*/
        string=AnalyseTagsService.analyseTags(5).toString();
        res.add(string.replaceAll(",",";"));
        list.add(string.equals("[A,B,C,D,E]"));
        map.put("result",res);
        map.put("right",list);
        return map;
    }
}
