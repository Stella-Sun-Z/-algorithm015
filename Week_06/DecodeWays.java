package Week6;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "10";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int pre = 1, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = pre;
            pre = cur;
            if (s.charAt(i) == '0') {
                cur = 0;
            }
            int n = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (n < 27 && n > 9) {
                cur += temp;
            }
        }
        return cur;
    }
}
