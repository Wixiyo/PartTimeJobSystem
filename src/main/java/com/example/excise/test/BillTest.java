package com.example.excise.test;



import com.example.excise.solution.Bill;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author panxiangyu
 * @date 2021年04月06日18:56
 * 电信收费问题测试脚本
 */
public class BillTest {
    public static String test(MultipartFile file){
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
            while(true){
                string=reader.readLine();
                if(string==null)break;
                /*分割字符串*/
                String[] arr=string.split(",");
                int d=Integer.parseInt(arr[0]);
                int f=Integer.parseInt(arr[1]);
                /*期望的结果*/
                String expect=arr[2];
                String result= String.format("%.4f", Bill.calculate(d, f));
                string+=","+result;
                /*与期望相符*/
                if(expect.equals(result))string+=",正确";
                else string+=",错误";
                builder.append("\n").append(string);
            }
            reader.close();
            in.close();
            bin.close();
        }catch (IOException e){
            e.printStackTrace();
            return "测试异常";
        }
        System.out.println();
        return builder.toString();
    }
}
