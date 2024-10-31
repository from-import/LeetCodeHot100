public class test24 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("test"));
    }


    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] result = new int[n][n];
        result[0][0] = 0;
        for(int i = n-1;i>=0;i--){
            result[i][i] = 1;
            for(int j = i+1;j< n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    result[i][j] = result[i+1][j-1] +2;
                }else{
                    if(result[i+1][j] > result[i][j-1]){
                        result[i][j] = result[i+1][j];
                    }else{
                        result[i][j] = result[i][j-1];
                    }
                }
            }
        }
        return result[0][0];
    }

    public static int[] minNumber (int[] nums1, int[] nums2, int k) {
        int[] result = new int[5];
        return result;
    }

}
