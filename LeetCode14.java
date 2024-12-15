public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {

        String oriString = strs[0];
        int maxLength = oriString.length();
        for (String s : strs) {
            if (s.equals("")) {
                return "";
            }
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i >= oriString.length()) {
                    break;
                }
                if (oriString.charAt(i) == s.charAt(i)) {
                    length++;
                }
                else {
                    break;
                }
            }
            maxLength = Math.min(length, maxLength);
        }
        return oriString.substring(0, maxLength);
    }
}
