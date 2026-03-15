

public class LongestCommonSubsequence {

   

    // Function to find LCS length and sequence
    public static void findLCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Step 1: Build dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: LCS length
        System.out.println("Length of LCS: " + dp[n][m]);

        // Step 3: Reconstruct LCS string (backtracking)
        int i = n, j = m;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Since we added characters in reverse order
        System.out.println("LCS: " + lcs.reverse().toString());
    }

    public static void main(String[] args) {
        String s1 = "abaaba";
        String s2 = "babbab";

        findLCS(s1, s2);
    }
}


