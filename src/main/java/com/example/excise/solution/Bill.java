package com.example.excise.solution;

import com.example.annotation.TestMethod;

/**
 * @author panxiangyu
 * @date 2021年04月06日18:47
 */
public class Bill {
    /**
     *
     * @author panxiangyu
     * @date 2021/4/6 18:48
     * @param d 通话时间
     * @param f 本年度持续到当月未缴费次数
     * @return double 需缴纳话费
     */
    @TestMethod(
            value = "public static double calculate(int d,int f)",
            description = " d 通话时间,f 本年度持续到当月未缴费次数,返回值:double 需缴纳话费，-1意味着输入异常",
            response = double.class)
    public static double calculate(int d,int f){
        if(d<0||f<0||f>11||d>24*60*365)return -1;
        else{
            double result;
            if(d<=60){
                if(f<=1)result=25+d*0.15*0.99;
                else result=25+d*0.15;
            }
            else if(d<=120){
                if(f<=2)result=25+d*0.15*0.985;
                else result=25+d*0.15;
            }
            else if(d<=180){
                if(f<=3)result=25+d*0.15*0.98;
                else result=25+d*0.15;
            }
            else if(d<=300){
                if(f<=3)result=25+d*0.15*0.975;
                else result=25+d*0.15;
            }
            else {
                if(f<=6)result=25+d*0.15*0.97;
                else result=25+d*0.15;
            }
            return result;
        }
    }
}
