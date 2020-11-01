package Week9;

public class ReverseStringII {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
    public static String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        for (int n = 0; n < len; n += 2 * k) {
            int left = n, right = Math.min(len - 1, n + k - 1);
            while (left < right) {
                char temp = cs[left];
                cs[left++] = cs[right];
                cs[right--] = temp;
            }
        }
        return new String(cs);
    }
}
