package com.xxx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode207 {
    /**
     * 统计每个课被指向次数，初始被指向次数为0的肯定是安全的（不在环上）。
     * 每被安全课程指向一次，被指次数减一，
     * 如果被指次数减到0，说明该课程全部指向都来自安全课程，则它也是安全的。
     * 依此进行队列循环。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建邻接表和入度数组
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 构建图和入度数组
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            graph.get(pre).add(course);
            indegree[course]++;
        }

        // 初始化队列，将所有入度为 0 的课程加入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 计数已完成的课程
        int completedCourses = 0;

        // BFS 遍历
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 检查是否能完成所有课程
        return completedCourses == numCourses;
    }
}
