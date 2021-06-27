package com.example.unitest;

/**
 * @author panxiangyu
 * 2021年06月23日22:28
 * UpdateStuCoJob函数的桩
 */
final class UpdateStuCoJobStub {
    private UpdateStuCoJobStub() {
    }
    /**
     *
     * @param sid 学生编号
     * @return java.lang.Object 学生编号是否存在
     */
    public static Object getStudentWithSId(int sid) {
        if (sid > 1) {
            return "true";
        } else {
            return null;
        }
    }
}
