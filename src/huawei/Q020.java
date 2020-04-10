package huawei;

import java.util.Scanner;

/**
 * 密码验证合格程序
 * <p>
 * 题目描述
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 * <p>
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 * <p>
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 * <p>
 * 示例1
 * 输入
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * OK
 * NG
 * NG
 * OK
 */
public class Q020 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        String str = keyboard.nextLine();
        if (str.length() <= 8 || str == null) {
            System.out.println("NG");
            return;
        }

        int hasNumber = 0;
        int hasUpperCaseLetter = 0;
        int hasLowerCaseLetter = 0;
        int hasOtherChar = 0;
        char[] strs = str.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] >= '0' && strs[i] <= '9') {
                hasNumber = 1;
            } else if (strs[i] >= 'a' && strs[i] <= 'z') {
                hasLowerCaseLetter = 1;
            } else if (strs[i] >= 'A' && strs[i] <= 'Z') {
                hasUpperCaseLetter = 1;
            } else {
                hasOtherChar = 1;
            }
        }

        if (hasNumber + hasUpperCaseLetter + hasLowerCaseLetter + hasOtherChar < 3) {
            System.out.println("NG");
            return;
        }

        if (!checkSubstring(str)) {
            System.out.println("NG");
            return;
        }
        System.out.println("OK");
    }

    public static boolean checkSubstring(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            String subString = str.substring(i, i + 3);
            String leftString = str.substring(i + 3);
            if (leftString.contains(subString)) {
                return false;
            }
        }
        return true;
    }
}
