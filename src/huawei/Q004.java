package huawei;

import java.util.Scanner;

/**
 * 字符串分割
 *
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 * 示例1
 * 输入
 * abc
 * 123456789
 * 输出
 * abc00000
 * 12345678
 * 90000000
 */
public class Q004 {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard){
        char[] in1 = keyboard.nextLine().toCharArray();
        int length = in1.length;
        int num1 = length / 8;
        int num2 = length % 8;
        for(int i = 0; i < num1; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(in1[i*8+j]);
            }
            System.out.println();
        }

        if(num2 != 0) {
            for(int i = 0; i < 8; i++) {
                if(i < num2) {
                    System.out.print(in1[num1*8+i]);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
}
