package huawei;

import java.util.Scanner;

/**
 * 句子逆序
 *
 * 题目描述
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * 输入描述:
 * 将一个英文语句以单词为单位逆序排放。
 *
 * 输出描述:
 * 得到逆序的句子
 *
 * 示例1
 * 输入
 * I am a boy
 * 输出
 * boy a am I
 */
public class Q013 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        String in = keyboard.nextLine();
        String[] words = in.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += words[words.length - i - 1];
            if (i != words.length - 1) {
                result += " ";
            }
        }
        System.out.println(result);
    }
}
