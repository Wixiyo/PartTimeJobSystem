package com.example.excise.test;


import com.example.excise.solution.TriangleType;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author panxiangyu
 * @date 2021/6/24 16:06
 * 三角形测试脚本
 */
public class TriangleTypeTest {
    public static String test(MultipartFile file) {
        StringBuilder builder=new StringBuilder();
        ByteArrayInputStream bin;
        InputStreamReader in;
        BufferedReader reader;
        try {
            /*转为bufferReader一行一行读取*/
            byte[]cases=file.getBytes();
            bin=new ByteArrayInputStream(cases);
            in=new InputStreamReader(bin, StandardCharsets.UTF_8);
            reader=new BufferedReader(in);
            /*读取说明以及表头*/
            String string=reader.readLine();
            builder.append(string);
            string=reader.readLine();
            builder.append("\n").append(string);
            while (true) {
                string = reader.readLine();
                if (string == null) break;
                /*分割字符串*/
                String[] arr = string.split(",");
                double a = Double.parseDouble(arr[0]);
                double b = Double.parseDouble(arr[1]);
                double c = Double.parseDouble(arr[2]);
                /*期望结果*/
                String expect = arr[3];
                String result = TriangleType.determineType(a, b, c);
                string = string + "," + result;
                /*结果符合*/
                if (result.equals(expect)) {
                    string += ",正确";
                } else string += ",错误";
                builder.append("\n").append(string);
            }
            reader.close();
            in.close();
            bin.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "测试异常";
        }
        return builder.toString();
    }

}
