package com.example.unitest;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panxiangyu
 * 2021年06月23日20:20
 * JobForStu函数测试脚本
 */
public class JobForStuUnitTest extends TestCase {
    public static Map<String,Object> UT_TC_001_001_Equiv() {
        Map<String,Object>map=new HashMap<>();
        List<String>res=new ArrayList<>();
        List<Boolean> list = new ArrayList<>();

        /*UT_TC_001_001_001,输入的兼职编号和学生编号均不存在,busId="error";sid=1,{code=500}*/
        String string=JobService.jobForStu("error",1).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{code=500}"));

        /*UT_TC_001_001_002,输入的兼职编号存在，学生编号不存在,busId="error";sid=2,{code=500}*/
        string=JobService.jobForStu("error",2).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{code=500}"));

        /*UT_TC_001_001_003,输入的兼职编号不存在，学生编号存在,busId="apply";sId=1,{code=500}*/
        string=JobService.jobForStu("apply",1).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{code=500}"));

        /*UT_TC_001_001_004,输入的兼职编号和学生编号均存在,busId="apply";sId=2,{isApply=1;isInterest=0;numsOfApply=1}*/
        string=JobService.jobForStu("apply",2).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{isApply=1, isInterest=0, numsOfApply=1}"));
        map.put("result",res);
        map.put("right",list);
        return map;

    }
    public static Map<String,Object> UT_TC_001_001_Statement() {
        Map<String,Object>map=new HashMap<>();
        List<String>res=new ArrayList<>();
        List<Boolean> list = new ArrayList<>();

        /*UT_TC_001_001_005,输入的兼职编号和学生编号均不存在,busId="error";sid=1,{code=500}*/
        String string=JobService.jobForStu("error",1).toString();
        res.add(string.replace(",",";"));
        list.add(JobService.jobForStu("error",1).toString().equals("{code=500}"));

        /*UT_TC_001_001_006,输入的兼职编号和学生编号存在，该学生未申请和收藏该兼职,busId="other";sid=6,{isApply=-1;isInterest=0;numsOfApply=1}*/
        string=JobService.jobForStu("other",6).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{isApply=-1, isInterest=0, numsOfApply=1}"));

        /*UT_TC_001_001_007,输入的兼职编号和学生编号存在，该学生未申请该兼职，但收藏了该兼职	,busId="apply";sid=5,{isApply=-1;isInterest=1;numsOfApply=1}*/
        string=JobService.jobForStu("apply",5).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{isApply=-1, isInterest=1, numsOfApply=1}"));

        /*UT_TC_001_001_008,输入的兼职编号和学生编号存在，该学生申请了该兼职，但未收藏该兼职	,busId="apply";sid=2,{isApply=1;isInterest=0;numsOfApply=1}*/
        string=JobService.jobForStu("apply",2).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{isApply=-1, isInterest=0, numsOfApply=1}"));

        /*UT_TC_001_001_009,输入的兼职编号和学生编号存在，该学生申请和收藏了该兼职,busId="apply";sId=3,{isApply=1;isInterest=1;numsOfApply=1}*/
        string=JobService.jobForStu("apply",3).toString();
        res.add(string.replace(",",";"));
        System.out.println(string);
        list.add(string.equals("{isApply=1, isInterest=1, numsOfApply=1}"));
        map.put("result",res);
        map.put("right",list);
        return map;
    }
    public static Map<String,Object> UT_TC_001_001_Condition() {
        Map<String,Object>map=new HashMap<>();
        List<String>res=new ArrayList<>();
        List<Boolean> list = new ArrayList<>();

        /*UT_TC_001_001_010,输入的兼职编号存在，学生编号不存在,busId="other";sid=1,{code=500}*/
        String string=JobService.jobForStu("other",1).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{code=500}"));

        /*UT_TC_001_001_011,输入的兼职编号不存在，学生编号存在,busId="error";sid=2,{code=500}*/
        string=JobService.jobForStu("error",2).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{code=500}"));

        /*UT_TC_001_001_012,输入的兼职编号和学生编号存在，该学生申请了该兼职，但未收藏该兼职	,busId="apply";sid=2,{isApply=1;isInterest=0;numsOfApply=1}*/
        string=JobService.jobForStu("apply",2).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{isApply=1, isInterest=0, numsOfApply=1}"));

        /*UT_TC_001_001_013,输入的兼职编号和学生编号存在，该学生未申请该兼职，但收藏了该兼职	,busId="apply";sid=5,{isApply=-1;isInterest=1;numsOfApply=1}*/
        string=JobService.jobForStu("apply",5).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{isApply=-1, isInterest=1, numsOfApply=1}"));
        map.put("result",res);
        map.put("right",list);
        return map;
    }
    public static Map<String,Object> UT_TC_001_001_Path() {
        Map<String,Object>map=new HashMap<>();
        List<String>res=new ArrayList<>();
        List<Boolean> list = new ArrayList<>();

        /*UT_TC_001_001_014,输入的兼职编号和学生编号均不存在,busId="error";sid=1,{code=500}*/
        String string=JobService.jobForStu("error",1).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{code=500}"));

        /*UT_TC_001_001_015,输入的兼职编号和学生编号存在，该学生未申请和收藏该兼职,busId="apply";sid=6,{isApply=-1;isInterest=0;numsOfApply=1}*/
        string=JobService.jobForStu("apply",6).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{isApply=-1, isInterest=0, numsOfApply=1}"));

        /*UT_TC_001_001_016,输入的兼职编号和学生编号存在，该学生未申请该兼职，但收藏了该兼职	,busId="apply";sid=5,{isApply=-1;isInterest=1;numsOfApply=1}*/
        string=JobService.jobForStu("apply",5).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{isApply=-1, isInterest=1, numsOfApply=1}"));

        /*UT_TC_001_001_017,输入的兼职编号和学生编号存在，该学生申请和收藏了该兼职,busId="apply";sid=3,{isApply=1;isInterest=1;numsOfApply=1}
         */
        string=JobService.jobForStu("apply",3).toString();
        res.add(string.replace(",",";"));
        list.add(string.equals("{isApply=1, isInterest=1, numsOfApply=1}"));
        map.put("result",res);
        map.put("right",list);
        return map;
    }
}
