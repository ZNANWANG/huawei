package huawei;

import java.util.Scanner;

/**
 * 坐标移动
 * <p>
 * 题目描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些
 * 坐标，并将最终输入结果输出到输出文件里面。
 * <p>
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）坐标之间以;分隔。非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * <p>
 * 处理过程：
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)
 * 结果 （10， -10）
 * <p>
 * 注意请处理多组输入输出
 * <p>
 * 输入描述:
 * 一行字符串
 * <p>
 * 输出描述:
 * 最终坐标，以,分隔
 * <p>
 * 示例1
 * 输入
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出
 * 10,-10
 */
public class Q017 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        String[] moves = keyboard.nextLine().split(";");
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length; i++) {
            String move = moves[i];
            if (move.length() > 0) {
                char direction = Character.toLowerCase(move.charAt(0));
                String num = move.substring(1);
                if (direction == 'a' && isNumber(num.toCharArray())) {
                    x = x - Integer.parseInt(num);
                } else if (direction == 'd' && isNumber(num.toCharArray())) {
                    x = x + Integer.parseInt(num);
                } else if (direction == 'w' && isNumber(num.toCharArray())) {
                    y = y + Integer.parseInt(num);
                } else if (direction == 's' && isNumber(num.toCharArray())) {
                    y = y - Integer.parseInt(num);
                }
            }
        }
        System.out.println(x + "," + y);
    }

    public static boolean isNumber(char[] letters) {
        for (int i = 0; i < letters.length; i++) {
            if (!Character.isDigit(letters[i])) {
                return false;
            }
        }
        return true;
    }
}
