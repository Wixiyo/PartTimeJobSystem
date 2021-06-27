package com.example.unitest;

import com.example.jobmanager.Studentcojob;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author panxiangyu
 * 2021年06月23日22:32
 * UpdateStuCoJob测试脚本
 */
public class UpdateStuCoJobUnitTest extends TestCase {
    public static Map<String, Object> UT_TC_002_001_Equiv() {
        /*UT_TC_001_002_001,学生信息为空,null,学生信息异常*/
        Map<String, Object> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        List<Boolean> list = new ArrayList<>();
        String string = StudentCoJobService.updateStuCoJob(null);
        res.add(string);
        list.add(string.equals("学生信息异常"));

        /*UT_TC_001_002_002,学生信息不为空,{sid:2;state:1},通过*/
        Studentcojob scJob = new Studentcojob();
        scJob.setSid(2);
        scJob.setState(1);
        string = StudentCoJobService.updateStuCoJob(scJob);
        res.add(string);
        list.add(string.equals("通过"));
        map.put("result", res);
        map.put("right", list);
        return map;
    }

    public static Map<String, Object> UT_TC_002_001_Statement() {
        Map<String, Object> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        List<Boolean> list = new ArrayList<>();

        /*UT_TC_001_002_003,输入学生信息为空,null,学生信息异常*/
        String string = StudentCoJobService.updateStuCoJob(null);
        res.add(string);
        list.add(string.equals("学生信息异常"));

        /*UT_TC_001_002_004,输入学生信息不为空，学生编号不存在,{sid:1;state:1},学生信息异常*/
        Studentcojob scJob = new Studentcojob();
        scJob.setSid(1);
        scJob.setState(1);
        string = StudentCoJobService.updateStuCoJob(scJob);
        res.add(string);
        list.add(string.equals("学生信息异常"));

        /*UT_TC_001_002_005,输入学生信息不为空，学生编号存在，申请兼职通过,{sid:2;state:1},通过*/
        scJob.setSid(2);
        scJob.setState(1);
        string = StudentCoJobService.updateStuCoJob(scJob);
        res.add(string);
        list.add(string.equals("通过"));

        /*UT_TC_001_002_006,输入学生信息不为空，学生编号存在，申请的兼职结束,{sid:2;state:2},结束*/
        scJob.setSid(2);
        scJob.setState(2);
        string = StudentCoJobService.updateStuCoJob(scJob);
        res.add(string);
        list.add(string.equals("结束"));

        /*UT_TC_001_002_007,输入学生信息不为空，学生编号存在，申请兼职被拒绝,{sid:2;state:3},拒绝*/
        scJob.setSid(2);
        scJob.setState(3);
        string = StudentCoJobService.updateStuCoJob(scJob);
        res.add(string);
        list.add(string.equals("拒绝"));

        /*UT_TC_001_002_008,输入学生信息不为空，学生编号存在，兼职状态异常,{sid:2;state:0},兼职状态异常*/
        scJob.setSid(2);
        scJob.setState(0);
        string = StudentCoJobService.updateStuCoJob(scJob);
        res.add(string);
        list.add(string.equals("兼职状态异常"));
        map.put("result", res);
        map.put("right", list);
        return map;
    }

    public static Map<String, Object> UT_TC_002_001_Path() {
        Map<String, Object> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        List<Boolean> list = new ArrayList<>();
        /*UT_TC_001_002_009,输入学生信息为空,null,学生信息异常*/
        String string = StudentCoJobService.updateStuCoJob(null);
        res.add(string);
        list.add(string.equals("学生信息异常"));

        /*UT_TC_001_002_010,输入学生信息不为空，学生编号不存在,{sid:1;state:1},学生信息异常*/
        Studentcojob scJob = new Studentcojob();
        scJob.setSid(1);
        scJob.setState(1);
        string = StudentCoJobService.updateStuCoJob(scJob);
        res.add(string);
        list.add(string.equals("学生信息异常"));

        /* UT_TC_001_002_011,输入学生信息不为空，学生编号存在，申请兼职通过,{sid:2;state:1},通过*/
        scJob.setSid(2);
        scJob.setState(1);
        string = StudentCoJobService.updateStuCoJob(scJob);
        res.add(string);
        list.add(string.equals("通过"));

        /*UT_TC_001_002_012,输入学生信息不为空，学生编号存在，兼职状态异常,{sid:2;state:2},结束*/
        scJob.setSid(2);
        scJob.setState(2);
        string = StudentCoJobService.updateStuCoJob(scJob);
        res.add(string);
        list.add(string.equals("结束"));

        map.put("result", res);
        map.put("right", list);
        return map;
    }
}
