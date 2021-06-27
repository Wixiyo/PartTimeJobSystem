package com.example.excise.solution;


import com.example.annotation.TestMethod;

import java.util.Arrays;

public class TriangleType {
    /**
     * @param a a边
     * @param b b边
     * @param c c边
     * @return java.lang.String
     * @author panxiangyu
     * @date 2021/6/20 18:52
     */
    @TestMethod(value = "public static String determineType(double a,double b,double c)",
            description = " a,b,c分别为三角形三边 返回值:String 三角形类型",
            response = String.class)
    public static String determineType(double a, double b, double c) {
        double[] edges = new double[]{a, b, c};
        String result;
        /*
          先将三边进行排序
         */
        edges = Arrays.stream(edges).sorted().toArray();
        a = edges[0];
        b = edges[1];
        c = edges[2];
        /*
        是否满足三角形条件
         */
        if (a <= 0 || (a + b) <= c) {
            result = "非三角形";
        } else {
            /*
            是否为直角三角形
             */
            boolean isRightAngle = a * a + b * b == c * c;
            if (a == b) {
                if (b == c) result = "等边三角形";
                else if (isRightAngle) result = "等腰直角三角形";
                else result = "等腰三角形";
            } else if (isRightAngle) result = "直角三角形";
            else {
                if (b == c) {
                    result = "等腰三角形";
                } else {
                    result = "一般三角形";
                }
            }
        }
        return result;
    }
}
