package com.example.excise.solution;


import com.example.annotation.TestMethod;

public class Commission {
    /**
     *
     * @param h 主机数量
     * @param d 显示器数量
     * @param p 外设数量
     * @return 佣金或者该销售员本月销售额
     */
    @TestMethod(value = "public static double calculate(int h,int d,int p)",
            description = " h 主机数量,d 显示器数量,p 外设数量 返回值:double 佣金或者该销售员本月销售额，-2意味着统计销售员该月销售总额，-1意味着输入异常",
            response = double.class)
    public static double calculate(int h,int d,int p){
        double result;
        /*
        统计销售员该月销售总额
         */
        if(h==-1){
            result=-2;
        }
        else{
            /*
            数量不符合要求
             */
            if(h<=0||h>70||d<=0||d>80||p<=0||p>90)result=-1;
            else {
                int sales=25*h+30*d+45*p;
                if(sales<1000)result=sales*0.1;
                else if(sales>1800)result=sales*0.2;
                else result=sales*0.15;
            }
        }
        return result;
    }

}
