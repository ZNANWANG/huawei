package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 进制转换
 * <p>
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * <p>
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * <p>
 * 输出描述:
 * 输出该数值的十进制字符串。
 * <p>
 * 示例1
 * 输入
 * 0xA
 * 输出
 * 10
 */
public class Q005 {
    public static final Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('a', 10);
        map.put('b', 11);
        map.put('c', 12);
        map.put('d', 13);
        map.put('e', 14);
        map.put('f', 15);
    }

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            //getResult(keyboard);
            getResult1(keyboard);
        }
        keyboard.close();
    }

    public static void getResult1(Scanner keyboard) {
        char[] num1 = keyboard.next().toCharArray();
        char[] num2 = new char[num1.length - 2];
        for (int i = 2; i < num1.length; i++) {
            num2[i - 2] = num1[i];
        }
        int sum = 0;
        for (int i = 0; i < num2.length; i++) {
            int temp = (int) Math.pow(16, i);
            if (Character.isDigit(num2[num2.length - i - 1])) {
                sum += temp * Integer.parseInt(String.valueOf(num2[num2.length - i - 1]));
            } else {
                char letter = Character.toLowerCase(num2[num2.length - i - 1]);
                sum += temp * map.get(letter);
            }
        }
        System.out.println(sum);
    }

    public static void getResult(Scanner keyboard) {
        char[] num1 = keyboard.next().toCharArray();
        char[] num2 = new char[num1.length - 2];
        for (int i = 2; i < num1.length; i++) {
            num2[i - 2] = num1[i];
        }
        int sum = 0;
        for (int i = 0; i < num2.length; i++) {
            int tmp = (int) Math.pow(16, i);
            if (Character.isDigit(num2[num2.length - i - 1])) {
                sum += tmp * Integer.parseInt(num2[num2.length - i - 1] + "");
            } else if (Character.toLowerCase(num2[num2.length - i - 1]) == 'a') {
                sum += tmp * 10;
            } else if (Character.toLowerCase(num2[num2.length - i - 1]) == 'b') {
                sum += tmp * 11;
            } else if (Character.toLowerCase(num2[num2.length - i - 1]) == 'c') {
                sum += tmp * 12;
            } else if (Character.toLowerCase(num2[num2.length - i - 1]) == 'd') {
                sum += tmp * 13;
            } else if (Character.toLowerCase(num2[num2.length - i - 1]) == 'e') {
                sum += tmp * 14;
            } else if (Character.toLowerCase(num2[num2.length - i - 1]) == 'f') {
                sum += tmp * 15;
            }
        }
        System.out.println(sum);
    }
}
