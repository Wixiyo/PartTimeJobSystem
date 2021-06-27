package com.example.excise.solution;


import com.example.annotation.TestMethod;

/**
 * @author panxiangyu
 * @date 2021年04月08日12:51
 */
public class NextDate {
    /**
     *
     * @author panxiangyu
     * @date 2021/4/8 12:53
     * @param y 1800<=y<=2100
     * @param m 月份
     * @param d 天数
     * @return java.lang.String 给定日期的下一天
     */
    @TestMethod(value = "public static String calculate(int y,int m,int d)",
            description = " y 1800<=y<=2100,m 月份,d 天数 返回值:String 给定日期的下一天，error意味着输入参数异常",
            response = String.class)
    public static String calculate(int y,int m,int d){
        String result;
        if(y<1800||y>2100||m<1||m>12||d<1||d>31)result="error";
        else{
            String bigMonth="1357810";
            String smallMonth="46911";
            /*
             大月份
             */
            if(bigMonth.contains(Integer.toString(m))){
                if(d<31)result= y +"/"+ m +"/"+ (d + 1);
                else result=y+"/"+(m+1)+"/1";
            }else if(smallMonth.contains(Integer.toString(m))){
                /*
                 *小月份
                 */
                if(d<30)result= y +"/"+ m +"/"+ (d + 1);
                else if(d==30)result=y+"/"+(m+1)+"/1";
                else result="error";
            }else if(m==12){
                if(d<31)result= y +"/"+ m +"/"+ (d + 1);
                else result=(y+1)+"/1/1";
            }else {
                boolean isLeap=(y%4==0&&y%100!=0)||(y%400==0);
                 if(d<28)result= y +"/"+ m +"/"+ (d + 1);
                 else if(d==28){
                     /*
                      *闰年
                      */
                     if(isLeap)result= y +"/"+ m +"/"+ (d + 1);
                     else result=y+"/"+(m+1)+"/1";
                 }else if(d==29){
                     /*
                      *闰年
                      */
                     if(isLeap)result=y+"/"+(m+1)+"/1";
                     else result="error";
                 }else result="error";
            }
        }
        return result;
    }
}
