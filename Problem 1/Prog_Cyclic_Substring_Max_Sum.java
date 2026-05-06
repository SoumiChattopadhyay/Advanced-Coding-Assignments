import java.util.Set;
import java.util.HashSet;

public class Prog1_Cyclic_Substring_Max_Sum {
    public static int maxSum(String s) {
        int n = s.length();
        String t = s + s;

        Set<Character> set = new HashSet<>();
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < 2 * n; right++) {
            char ch = t.charAt(right);

            // Remove duplicates
            while (set.contains(ch) || (right - left + 1) > n) {
                char leftChar = t.charAt(left);
                set.remove(leftChar);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }

            // Add current character
            set.add(ch);
            currentSum += (ch - 'a' + 1);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(maxSum(s)); 
    }
}