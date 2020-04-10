package huawei;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 提取不重复的数
 * <p>
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * <p>
 * 输入描述:
 * 输入一个int型整数
 * <p>
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * <p>
 * 示例1
 * 输入
 * 9876673
 * 输出
 * 37689
 */
public class Q009 {
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
        StringBuffer sb = new StringBuffer(in);
        in = sb.reverse().toString();
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < in.length(); i++) {
            set.add(in.charAt(i));
        }
        Object[] res = set.toArray();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
        System.out.println();
    }

    public static void getResult1(Scanner keyboard) {
        String in = keyboard.next();
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < in.length(); i++) {
            set.add(in.charAt(i));
        }
        Object[] res = set.toArray();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res.length - 1 - i);
        }
        System.out.println();
    }
}
