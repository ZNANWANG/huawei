package huawei;

import java.util.Scanner;

/**
 * 购物单
 * <p>
 * 题目描述
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就
 * 是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的
 * 东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品
 * 的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
 * 设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
 * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
 * 请你帮助王强设计一个满足要求的购物单。
 * <p>
 * 输入描述:
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * 其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * 其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主
 * 件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * <p>
 * 输出描述:
 * 输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 * <p>
 * 示例1
 * 输入
 * 1000 5
 * 800 2 0
 * 400 5 1
 * 300 5 1
 * 400 3 0
 * 500 2 0
 * 输出
 * 2200
 */
public class Q016 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext()) {
            getResult(keyboard);
        }
        keyboard.close();
    }

    public static void getResult(Scanner keyboard) {
        int budget = keyboard.nextInt();
        int count = keyboard.nextInt();
        keyboard.nextLine();
        Good[] goods = new Good[count + 1];
        int v, p, q;
        for (int i = 1; i < count + 1; i++) {
            v = keyboard.nextInt();
            p = keyboard.nextInt();
            q = keyboard.nextInt();
            goods[i] = new Good(v, p, q);
            keyboard.nextLine();
            if (q > 0) {
                if (goods[q].a1 == 0) {
                    goods[q].setA1(i);
                } else {
                    goods[q].setA2(i);
                }
            }
        }
        plan(goods, budget + 1);
    }

    public static void plan(Good[] goods, int N) {
        int[][] dp = new int[goods.length][N];
        for (int i = 1; i < goods.length; i++) {
            int v1 = -1, v2 = -1, v3 = -1, tmp1 = -1, tmp2 = -1, tmp3 = -1;
            int v = goods[i].v;
            int tmp = goods[i].v * goods[i].p;
            if (goods[i].a1 != 0) {
                v1 = goods[i].v + goods[goods[i].a1].v;
                tmp1 = goods[i].v * goods[i].p + goods[goods[i].a1].v * goods[goods[i].a1].p;
            }
            if (goods[i].a2 != 0) {
                v2 = goods[i].v + goods[goods[i].a2].v;
                tmp2 = goods[i].v * goods[i].p + goods[goods[i].a2].v * goods[goods[i].a2].p;
            }
            if (goods[i].a1 != 0 && goods[i].a2 != 0) {
                v3 = goods[i].v + goods[goods[i].a1].v + goods[goods[i].a2].v;
                tmp3 = goods[i].v * goods[i].p + goods[goods[i].a1].v * goods[goods[i].a1].p + goods[goods[i].a2].v * goods[goods[i].a2].p;
            }

            for (int j = 1; j < N; j++) {
                if (goods[i].q > 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= v && v != -1)
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v] + tmp);
                    if (j >= v1 && v1 != -1)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v1] + tmp1);
                    if (j >= v2 && v2 != -1)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v2] + tmp2);
                    if (j >= v3 && v3 != -1)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v3] + tmp3);
                }

            }
        }
        System.out.println(dp[goods.length - 1][N - 1]);

    }

    static class Good {
        private int v;
        private int p;
        private int q;
        private int a1 = 0;
        private int a2 = 0;

        public Good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }
    }
}
