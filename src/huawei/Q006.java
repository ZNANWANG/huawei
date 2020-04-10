package huawei;

import java.util.Scanner;

/**
 * 质数因子
 * <p>
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）
 * <p>
 * 最后一个数后面也要有空格
 * <p>
 * 详细描述：
 * <p>
 * 函数接口说明：
 * public String getResult(long ulDataInput)
 * <p>
 * 输入参数：
 * long ulDataInput：输入的正整数
 * <p>
 * 返回值：
 * String
 * <p>
 * 输入描述:
 * 输入一个long型整数
 * <p>
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 * <p>
 * 示例1
 * 输入
 * 180
 * 输出
 * 2 2 3 3 5
 */
public class Q006 {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()){
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        long num = keyboard.nextLong();
        StringBuffer result = new StringBuffer();
        int index = 2;
        while (index <= num) {
            if (num % index == 0) {
                result.append(index);
                result.append(" ");
                if (index == num) {
                    break;
                } else {
                    num /= index;
                }
            } else {
                index++;
            }
        }
        System.out.println(result.toString());
    }
}
