package huawei;

import java.util.Scanner;

/**
 * 取近似值
 *
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * 输入描述:
 * 输入一个正浮点数值
 *
 * 输出描述:
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入
 * 5.5
 * 输出
 * 6
 */
public class Q007 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            //getResult(keyboard);
            getResult1(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard){
        double num = keyboard.nextFloat();
        System.out.println(Math.round(num));
    }

    public static void getResult1(Scanner keyboard){
        double num = keyboard.nextFloat();
        int base = (int)num;
        num -= base;
        if(num >= 0.5){
            System.out.println(base + 1);
        } else {
            System.out.println(base);
        }
    }
}
