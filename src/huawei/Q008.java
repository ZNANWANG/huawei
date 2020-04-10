package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 合并表记录
 * <p>
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * <p>
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 * <p>
 * 输出描述:
 * 输出合并后的键值对（多行）
 * <p>
 * 示例1
 * 输入
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 0 3
 * 1 2
 * 3 4
 */
public class Q008 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        int num = keyboard.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            int num1 = keyboard.nextInt();
            int num2 = keyboard.nextInt();
            if (map.containsKey(num1)) {
                int value = map.get(num1);
                map.put(num1, value + num2);
            } else {
                map.put(num1, num2);
            }
            keyboard.nextLine();
        }

        for (Object number : map.keySet()) {
            System.out.println(number + " " + map.get(number));
        }
    }
}
