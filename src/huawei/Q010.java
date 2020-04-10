package huawei;

import java.util.Scanner;

/**
 * 字符个数统计
 *
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 * abc
 * 输出
 * 3
 */
public class Q010 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        String str = keyboard.nextLine();
        int count = 0;
        int[] test = new int[128];
        for(int i = 0; i<str.length();i++){
            char c = str.charAt(i);;
            if(c >= 0 && c <= 127 && test[c] == 0){
                count++;
            }
            test[c] = 1;
        }
        System.out.println(count);
    }
}
