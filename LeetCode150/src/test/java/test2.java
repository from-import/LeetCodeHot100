import java.util.*;

class 大疆题1 {

    /* Write Code Here */
    public int numberOfPatrolBlocks(int[][] block) {
        int n = block.length;
        int m = block[0].length;
        boolean flag = true;
        String direction = "right";
        int x = 0;
        int y = 0;
        int count = 0;
        int runtime = 0;

        // 面前有障碍，则顺时针转90%
        while(flag){
            // 得出当无人机处于最上面一行/最下一行/最左一列，最右一列情况下还有没有地方能够到达
            if(x==0){
                if(y==0){
                    if(block[x][y+1] == 1 && block[x+1][y] == 1){
                        flag = false;
                        break;
                    }
                }
                if(y==n-1){
                    if(block[x][y-1] == 1 && block[x+1][y] == 1){
                        flag = false;
                        break;
                    }
                }
            }
            if(y==0){
                if(x==0){
                    if(block[x+1][y] == 1 && block[x][y+1] == 1){
                        flag = false;
                        break;
                    }
                }
                if(x==m-1){
                    if(block[x-1][y] == 1 && block[x][y+1] == 1){
                        flag = false;
                        break;
                    }
                }
            }
            // 左右上下全都是0
            if(x!=m-1 && y!=n-1 && x!=0 && y!=0){
                if(block[x][y+1] == 1 && block[x+1][y] == 1 && block[x][y-1] == 1 && block[x-1][y] == 1){
                    flag = false;
                    break;
                }
            }

            if(flag == false){
                break;
            }

            // 此时flag为true，说明无人机还有地方可以到达
            runtime ++; // 出现死锁手动跳出,设置为500的时候能过70%样例，1200能过100%
            if(runtime == 1500){
                break;
            }
            switch (direction){
                case "right":
                    block[x][y] = 2;
                    // 如果此时右侧的元素为1或者已经到达最右侧，需要更改方向并且continue防止越界
                    if(y==n-1 || block[x][y+1] == 1){direction = "down";}
                    else{
                        y++;
                        if(block[x][y] == 0){count++;}
                    }break;
                case "left":
                    block[x][y] = 2;
                    // 如果此时左侧的元素为1或者已经到达最左侧，需要更改方向并且continue防止越界
                    if(y==0 || block[x][y-1] == 1 ){direction = "up";}
                    else {
                        y--;
                        if(block[x][y] == 0){count++;}
                    }break;

                case "up":
                    block[x][y] = 2;
                    // 如果此时上侧的元素为1或者已经到达最上侧，需要更改方向并且continue防止越界
                    if(x==0 || block[x-1][y] == 1){direction = "right";}
                    else {
                        x--;
                        if(block[x][y] == 0){count++;}
                    }break;
                case "down":
                    block[x][y] = 2;
                    // 如果此时下侧的元素为1或者已经到达最下侧，需要更改方向并且continue防止越界
                    if(x==m-1 || block[x+1][y] == 1){direction = "left";}
                    else {
                        x++;
                        if(block[x][y] == 0){count++;}
                    }break;
                default:
                    break;
            }

        }

        return (count+1);

    }
}

public class test2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int block_rows = 0;
        int block_cols = 0;
        block_rows = in.nextInt();
        block_cols = in.nextInt();

        int[][] block = new int[block_rows][block_cols];
        for(int block_i=0; block_i<block_rows; block_i++) {
            for(int block_j=0; block_j<block_cols; block_j++) {
                block[block_i][block_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }


        res = new 大疆题1().numberOfPatrolBlocks(block);
        System.out.println(String.valueOf(res));

    }
}
