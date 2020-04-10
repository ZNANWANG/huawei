package huawei;

import java.util.Scanner;

/**
 * 识别有效的IP地址和掩码并进行分类
 * <p>
 * 题目描述
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 * <p>
 * 所有的IP地址划分为 A,B,C,D,E五类
 * A类地址1.0.0.0~126.255.255.255;
 * B类地址128.0.0.0~191.255.255.255;
 * C类地址192.0.0.0~223.255.255.255;
 * D类地址224.0.0.0~239.255.255.255；
 * E类地址240.0.0.0~255.255.255.255
 * <p>
 * 私网IP范围是：
 * 10.0.0.0～10.255.255.255
 * 172.16.0.0～172.31.255.255
 * 192.168.0.0～192.168.255.255
 * <p>
 * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * 注意二进制下全是1或者全是0均为非法
 * <p>
 * 注意：
 * 1. 类似于【0.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
 * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
 * <p>
 * 输入描述:
 * 多行字符串。每行一个IP地址和掩码，用~隔开。
 * <p>
 * 输出描述:
 * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 * <p>
 * 示例1
 * 输入
 * 10.70.44.68~255.254.255.0
 * 1.0.0.1~255.0.0.0
 * 192.168.0.2~255.255.255.0
 * 19..0.~255.255.255.0
 * 输出
 * 1 0 1 0 0 2 1
 */
public class Q018 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        int a = 0, b = 0, c = 0, d = 0, e = 0, pri = 0, err = 0;
        String str = keyboard.nextLine();
        String[] ipAndMask = str.split("~");
        String ip = ipAndMask[0];
        String mask = ipAndMask[1];
        if (checkMask(mask)) {
            if (checkIP(ip)) {
                String[] strs = ip.split("\\.");
                int ip1 = Integer.parseInt(strs[0]);
                int ip2 = Integer.parseInt(strs[1]);
                int ip3 = Integer.parseInt(strs[2]);
                int ip4 = Integer.parseInt(strs[3]);
                if (ip1 >= 1 && ip1 <= 126
                        && ip2 >= 0 && ip2 <= 255
                        && ip3 >= 0 && ip3 <= 255
                        && ip4 >= 0 && ip4 <= 255) {
                    if (ip1 == 10 && ip2 >= 0 && ip2 <= 255
                            && ip3 >= 0 && ip3 <= 255
                            && ip4 >= 0 && ip4 <= 255) {
                        pri += 1;
                    }
                    a += 1;
                } else if (ip1 >= 128 && ip1 <= 191
                        && ip2 >= 0 && ip2 <= 255
                        && ip3 >= 0 && ip3 <= 255
                        && ip4 >= 0 && ip4 <= 255) {
                    if (ip1 == 172 && ip2 >= 16 && ip2 <= 31
                            && ip3 >= 0 && ip3 <= 255
                            && ip4 >= 0 && ip4 <= 255) {
                        pri += 1;
                    }
                    b += 1;
                } else if (ip1 >= 192 && ip1 <= 223
                        && ip2 >= 0 && ip2 <= 255
                        && ip3 >= 0 && ip3 <= 255
                        && ip4 >= 0 && ip4 <= 255) {
                    if (ip1 == 192 && ip2 == 168
                            && ip3 >= 0 && ip3 <= 255
                            && ip4 >= 0 && ip4 <= 255) {
                        pri += 1;
                    }
                    c += 1;
                } else if (ip1 >= 224 && ip1 <= 239
                        && ip2 >= 0 && ip2 <= 255
                        && ip3 >= 0 && ip3 <= 255
                        && ip4 >= 0 && ip4 <= 255) {
                    d += 1;
                } else if (ip1 >= 240 && ip1 <= 255
                        && ip2 >= 0 && ip2 <= 255
                        && ip3 >= 0 && ip3 <= 255
                        && ip4 >= 0 && ip4 <= 255) {
                    e += 1;
                }
            } else {
                err += 1;
            }
        } else {
            err += 1;
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + err + " " + pri);
    }


    public static boolean checkIP(String ip) {
        String[] strs = ip.split("\\.");
        return strs.length == 4
                && (!strs[0].equals(""))
                && (!strs[1].equals(""))
                && (!strs[2].equals(""))
                && (!strs[3].equals(""));
    }

    public static boolean checkMask(String mask) {
        String[] strs = mask.split("\\.");
        if (strs[0].equals("255")) {
            if (strs[1].equals("255")) {
                if (strs[2].equals("255")) {
                    return strs[3].equals("254")
                            || strs[3].equals("252")
                            || strs[3].equals("248")
                            || strs[3].equals("240")
                            || strs[3].equals("224")
                            || strs[3].equals("192")
                            || strs[3].equals("128")
                            || strs[3].equals("0");
                } else if (strs[2].equals("254")
                        || strs[2].equals("252")
                        || strs[2].equals("248")
                        || strs[2].equals("240")
                        || strs[2].equals("224")
                        || strs[2].equals("192")
                        || strs[2].equals("128")
                        || strs[2].equals("0")) {
                    return strs[3].equals("0");
                }
            } else if (strs[1].equals("254")
                    || strs[1].equals("252")
                    || strs[1].equals("248")
                    || strs[1].equals("240")
                    || strs[1].equals("224")
                    || strs[1].equals("192")
                    || strs[1].equals("128")
                    || strs[1].equals("0")) {
                return strs[3].equals("0") && strs[2].equals("0");
            }
        } else if (strs[0].equals("254")
                || strs[0].equals("252")
                || strs[0].equals("248")
                || strs[0].equals("240")
                || strs[0].equals("224")
                || strs[0].equals("192")
                || strs[0].equals("128")) {
            return strs[3].equals("0") && strs[2].equals("0") && strs[1].equals("0");
        }
        return false;
    }
}
