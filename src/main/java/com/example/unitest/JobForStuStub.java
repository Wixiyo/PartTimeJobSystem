package com.example.unitest;

/**
 * @author panxiangyu
 * 2021年06月23日20:20
 * JobForStu函数测试的桩
 */
final class JobForStuStub {
    private JobForStuStub() {
    }
    /**
     *
     * @param busId 兼职编号
     * @return java.lang.Object 兼职编号是否存在
     */
    public static Object searchById(String busId) {
        if (busId.equals("error")) {
            return null;
        } else {
            return busId;
        }
    }
    /**
     *
     * @param sid 学生编号
     * @return java.lang.Object 学生编号是否存在
     */
    public static Object getStudentWithSId(int sid) {
        if (sid <= 1) {
            return null;
        } else {
            return "true";
        }
    }
    /**
     *
     * @param buSId 兼职编号
     * @return int 返回申请兼职总数
     */
    public static int numsOfApply(String buSId) {
        return 1;
    }
    /**
     *
     * @param busId 兼职编号
     * @param sid 学生编号
     * @return java.lang.Integer 是否申请
     */
    public static Integer isStuInApply(String busId, int sid) {
        if (busId.equals("apply") && sid > 1 && sid<= 4) {
            return 1;
        } else {
            return null;
        }
    }
    /**
     *
     * @param busId 兼职编号
     * @param sid 学生编号
     * @return java.lang.Object 是否收藏
     */
    public static Object isStuInterest(String busId, int sid) {
        if (busId.equals("apply") && sid >= 3 && sid <= 5) {
            return busId;
        } else {
            return null;
        }
    }
}
