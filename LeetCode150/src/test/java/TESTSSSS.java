import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class TESTSSSS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] workers = new int[n+100];
        int number = 0;
        int result = 2;
        while (in.hasNextInt()) {
            workers[number++] = in.nextInt();
        }
        while(result < 11){
            HashMap<Integer,Integer> map = new HashMap<>();

            int check = 0;
            for(int i=0;i<workers.length;i++){
                for(int j=workers[i];j<result+workers[i];j++){
                    map.put(j,1);
                }
            }
            for(int i=0;i<workers.length+100;i++){
                if(null != map.get(i)){
                    check++;
                }
            }
            if(check >= k){
                System.out.println(result);
                break;
            }
            result++;
        }

        // 2 0.05 3 0.15 5 0.25 10 0.05
    }
}