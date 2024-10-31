import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class M2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int canFired = 0;
            int n = in.nextInt();
            int m = in.nextInt();
            int[] cover = new int[n+1];
            int[] coverage = new int[n+1];
            int[][] workRange = new int[m][2];

            for (int i = 0; i < m; i++) {
                // 创建二维数组表示每个工人的工作范围
                workRange[i][0] = in.nextInt();
                workRange[i][1] = in.nextInt();
                for (int j = workRange[i][0]; j <= workRange[i][1]; j++) {
                    coverage[j] ++;
                    if(cover[j] == 0){cover[j]++;}
                }
            }

            for (int i = 0; i < m; i++) {
                boolean fire = true;
                for (int j = workRange[i][0]; j <= workRange[i][1]; j++) {
                    // 遍历每个工人的全部工作区域
                    if(coverage[j] == 1){
                        // 这个点只有这一个人在干活，如果解雇这个点就没人干活了
                        fire = false;
                        break;
                    }
                }if(fire){canFired++;}
            }
            System.out.println(canFired);
        }
    }
}