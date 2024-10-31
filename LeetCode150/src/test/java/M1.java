// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class M1 {
    public static void main(String[] args) {
        System.out.println(function());
        }

        public static int function(){
            int need = 3200;
            int days = 35;
            int maxCardValue = 0;
            int finalCost = 0;
            int MonthCardTime = 0;
            int money = 0;
            int stillNeed = need;
            for (int day = days; day>0; day--) {
                if (MonthCardTime <= 0 && stillNeed >=300){
                    finalCost += 30;
                    MonthCardTime += 30;
                    maxCardValue += 300;
                }
                if (MonthCardTime > 0){
                    MonthCardTime --;
                    maxCardValue += 90;
                }
                stillNeed = need - maxCardValue;
                if(day == 1){
                    money = stillNeed / 10;
                }
            }
            return money + finalCost;
        }
    }
