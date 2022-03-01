package com.xiao.base.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0934 {

    public int shortestBridge(int[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        boolean flipped = false;
        for (int i = 0; i < grid.length; i++) {
            if (flipped) break;
            for (int j = 0; j < grid[0].length; j++) {
                // 找到岛屿
                if (grid[i][j] == 1) {
                    // dfs查找到第一个岛屿
                    dfs(grid, queue, i, j);
                    flipped = true;
                    break;
                }
            }
        }

        // bfs造桥
        return bfs(grid, queue);
    }

    private int bfs(int[][] grid, Queue<Node> queue) {

        int level = 0;
        int i, j;

        while (queue.size() > 0) {
            int currentSize = queue.size();
            level++;
            while (currentSize >= 0) {
                currentSize--;
                Node node = queue.remove();
                i = node.getI();
                j = node.getJ();

                if (find(grid, queue, i, j + 1)) {
                    return level + 1;
                }

                if (find(grid, queue, i, j - 1)) {
                    return level + 1;
                }

                if (find(grid, queue, i + 1, j)) {
                    return level + 1;
                }

                if (find(grid, queue, i - 1, j)) {
                    return level + 1;
                }

            }

        }

        return 0;
    }

    private boolean find(int[][] grid, Queue<Node> queue, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 2) {
            return false;
        }

        if (grid[i][j] == 1) {
            return true;
        }

        // 如果是海，填海造陆
        grid[i][j] = 2;
        queue.add(new Node(i, j));
        return false;
    }

    public void dfs(int[][] grid, Queue<Node> queue, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 2) {
            return;
        }

        if (grid[i][j] == 0) {
            // 发现海岸线
            queue.add(new Node(i, j));
            return;
        }

        // 当前节点是陆地，标记陆地为2
        grid[i][j] = 2;
        dfs(grid, queue, i + 1, j);
        dfs(grid, queue, i - 1, j);
        dfs(grid, queue, i, j + 1);
        dfs(grid, queue, i, j - 1);

    }

    class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.j = j;
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public int getI() {
            return i;
        }

    }

    public static void main(String[] args) {

        boolean flag = false;
        for (int i = 0; i < 50; i++) {
            System.out.println("i" + i);
            if (flag) break;
            for (int j = 0; j < 50; j++) {
                if (i == 3 && j == 25) {
                    System.out.println("j" + j);
                    flag = true;
                    break;
                }
            }

        }
    }

}
