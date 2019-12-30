class Solution {
    public String longestPalindrome(String s) {
        if (s == null){
            return "";
        }

        int len = s.length();
        if(len < 1){
            return "";
        }

        String sub = s.substring(0, 1);
        int maxSubLen = 1;

        boolean[][] dp = new boolean[len][len];
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    int subLen = j - i + 1;
                    if (subLen > maxSubLen) {
                        maxSubLen = subLen;
                        sub = s.substring(i, j + 1);
                    }
                }
            }
        }

        return sub;
    }
}
