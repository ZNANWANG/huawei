package huawei;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 简单错误记录
 * <p>
 * 题目描述
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * <p>
 * 处理：
 * 1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名称和行号完全匹配）只记录一
 * 条，错误计数增加；
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 * <p>
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * <p>
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 * <p>
 * 示例1
 * 输入
 * E:\V1R2\product\fpgadrive.c   1325
 * 输出
 * fpgadrive.c 1325 1
 */
public class Q019 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String str = keyboard.nextLine();
        String path = str.split("\\s+")[0];
        String row = str.split("\\s+")[1];
        String file = path.substring(path.lastIndexOf("\\") + 1);
        if (file.length() > 16) {
            file = file.substring(file.length() - 16);
        }
        String record = file + " " + row;
        if (map.containsKey(record)) {
            map.put(record, map.get(record) + 1);
        } else {
            map.put(record, 1);
        }

        int count = 0;
        for (String key : map.keySet()) {
            count++;
            if (count > (map.size() - 8)) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
