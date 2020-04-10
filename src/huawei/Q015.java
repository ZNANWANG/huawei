package huawei;

import java.util.Scanner;

/**
 * 求int型正整数在内存中存储时1的个数
 * <p>
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * <p>
 * 输入描述:
 * 输入一个整数（int类型）
 * <p>
 * 输出描述:
 * 这个数转换成2进制后，输出1的个数
 * <p>
 * 示例1
 * 输入
 * 5
 * 输出
 * 2
 */
public class Q015 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
//            getResult1(keyboard);
//            getResult2(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        int in = keyboard.nextInt();
        String binary = Integer.toBinaryString(in);
        int num = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                num += 1;
            }
        }
        System.out.println(num);
    }

    public static void getResult1(Scanner keyboard) {
        int in = keyboard.nextInt();
        int flag = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((in & flag) == flag) {
                count++;
            }
            flag = flag << 1;
        }
        System.out.println(count);
    }

    public static void getResult2(Scanner keyboard) {
        int in = keyboard.nextInt();
        int count = 0;
        while (in != 0) {
            in = (in - 1) & in;
            count++;
        }
        System.out.println(count);
    }
}
