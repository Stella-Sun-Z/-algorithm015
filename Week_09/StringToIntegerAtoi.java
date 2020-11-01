package Week9;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int idx = 0, flag = 1, total = 0;
        while (idx < n && s.charAt(idx) == ' ') idx++;
        if (s.charAt(idx) == '+' || s.charAt(idx) == '-')
            flag = s.charAt(idx++) == '+' ? 1 : -1;
        while (idx < n && (s.charAt(idx) - '0') >= 0 && (s.charAt(idx) - '0') <=9) {
            long temp = (long)total * 10 + (s.charAt(idx++) - '0');
            if (flag == 1) {
                if (temp >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    total = (int)temp;
                }
            } else {
                if (temp > (long)Integer.MAX_VALUE + 1) {
                    return Integer.MIN_VALUE;
                } else {
                    total = (int)temp;
                }
            }
        }
        return total * flag;
    }
}
