package com.testwe.mobile.learn;

/**
 * 来自字节
 * 给定一个n*m的二位矩阵 ，每个位置都是字符 UDLR表示传送带的位置，会被传送到上下左右
 * . 0 分别表示空地 目标 一定只有一个目标点 可以在空地上选择 上下左右 四个方向的一个
 * 到达传送带的点会被强制移动到其指向的下一个位置
 * 如果越界直接返回 返回有几个点可以到达0点
 */
public class Code05_WhereCanReachNumber {
    public static void main(String[] args) {

        char[][] map = {{'U', 'D', '.', 'L'}, {'D', 'L', 'R', 'O'}, {'L', 'R', 'U', 'L'}};
        int i = Code05_WhereCanReachNumber.number2(map);
        System.out.println(i);


    }

    public static int number2(char[][] map) {

        int m = map.length;
        int n = map[0].length;

        //先找0点
        boolean[][] visited = new boolean[m + 1][n + 1];
        int[][] queue = new int[m * n][2];

        int l = 0, r = 0;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'O') {
                    visited[i][j] = true;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                    break;
                }
            }

        }
        while (l < r) {//队列里还有位置
            ans ++;
            //取出来O点，从queue二维的数组中
            int[] cur = queue[l++];
            int row = cur[0];
            int col = cur[1];
            //开始bfs
            //往上判断
            if (row - 1 > 0 && !visited[row - 1][col] && (map[row - 1][col] == '.' || map[row - 1][col] == 'D')) {
                visited[row - 1][col] = true;
                queue[r][0] = row - 1;
                queue[r++][1] = col;
            }
            //往下判断
            if (row + 1 < m && !visited[row + 1][col] && (map[row + 1][col] == '.' || map[row + 1][col] == 'U')) {
                visited[row + 1][col] = true;
                queue[r][0] = row + 1;
                queue[r++][1] = col;
            }
            //往左判断
            if (col - 1 > 0 && !visited[row][col - 1] && (map[row][col - 1] == '.' || map[row][col - 1] == 'R')) {
                visited[row][col - 1] = true;
                queue[r][0] = row;
                queue[r++][1] = col - 1;
            }

            //往右判断
            if (col + 1 < n && !visited[row][col + 1] && (map[row][col + 1] == '.' || map[row][col + 1] == 'L')) {
                visited[row][col + 1] = true;
                queue[r][0] = row;
                queue[r++][1] = col + 1;
            }


        }
        return ans;

    }
}
