package com.xxx;

import java.util.Random;

public class LeetCode470 {
    public static int rand7() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    public int rand10() {
            while(true) {
            int idx = (rand7() - 1) * 7 + rand7();
            if (idx <= 40) {
                return(idx % 10 + 1);
            }
        }
    }

}
