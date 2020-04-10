package huawei;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * <p>
 * 输入描述:
 * 输入N个字符
 * <p>
 * 输出描述:
 * 输出该字符串反转后的字符串
 * <p>
 * 示例1
 * 输入
 * abcd
 * 输出
 * dcba
 */
public class Q012 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
            getResult1(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        String in = keyboard.next();
        StringBuilder sb = new StringBuilder(in);
        String str = sb.reverse().toString();
        System.out.println(str);
    }

    public static void getResult1(Scanner keyboard) {
        String in = keyboard.next();
        for (int i = 0; i < in.length(); i++) {
            System.out.print(in.charAt(in.length() - 1 - i));
        }
        System.out.println();
    }
}
