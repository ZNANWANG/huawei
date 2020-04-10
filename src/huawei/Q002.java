package huawei;

import java.util.Scanner;

/**
 * 计算字符的个数
 * <p>
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * <p>
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 * <p>
 * 示例1
 * 输入
 * ABCDEF
 * A
 * <p>
 * 输出
 * 1
 */
public class Q002 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNextLine()) {
            //getResult(keyboard);
            getResult1(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        String line1 = keyboard.nextLine();
        char[] chars = line1.toCharArray();
        String line2 = keyboard.nextLine();
        char letter = Character.toLowerCase(line2.charAt(0));
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (letter == Character.toLowerCase(chars[i])) {
                num += 1;
            }
        }
        System.out.println(num);
    }

    public static void getResult1(Scanner keyboard) {
        String line1 = keyboard.nextLine();
        char[] chars = line1.toCharArray();
        String line2 = keyboard.nextLine();
        char letter = Character.toLowerCase(line2.charAt(0));
        int[] counts = new int[128];
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                counts[Character.toLowerCase(chars[i]) - 'a']++;
            } else {
                counts[chars[i]]++;
            }
        }
        System.out.println(counts[letter - 'a']);
    }
}
