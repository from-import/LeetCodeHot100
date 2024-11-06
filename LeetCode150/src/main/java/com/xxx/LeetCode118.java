package com.xxx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        //存储要返回的杨辉三角
        List<List<Integer>> dg = new ArrayList<>();
        //若0行，则返回空
        if(numRows == 0){
            return dg;
        }
        //递归出口，这是第一步！找到出口
        if(numRows == 1){
            dg.add(new ArrayList<>());
            dg.get(0).add(1);
            return dg;
        }
        //递归，注意返回值！！！这是第二步
        dg = generate(numRows-1);
        //一级递归要做啥，我们可以看第二行到第三行需要做啥
        //首先是要申请一个list来存储第三行，然后通过第二行得到第三行
        //第三行的首尾为1是确定了的，然后就是中间的数如何得到
        //通过观察很容易拿到for循环里面的式子
        //最后别忘了返回值！！！
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int j = 1;j < numRows - 1;j++){
            row.add(dg.get(numRows-2).get(j-1) + dg.get(numRows-2).get(j));
        }
        row.add(1);
        dg.add(row);
        return dg;
    }
}
