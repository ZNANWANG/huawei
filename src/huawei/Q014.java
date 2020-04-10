package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串连接最长路径查找
 *
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 *
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 *
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 *
 * 示例1
 * 输入
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class Q014 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        int num = keyboard.nextInt();
        keyboard.nextLine();
        List<String> list = new ArrayList<>();

        for(int i =0; i< num;i++){
            list.add(keyboard.next());
            keyboard.nextLine();
        }

        Collections.sort(list);
        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
