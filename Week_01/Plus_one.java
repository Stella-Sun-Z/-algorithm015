package Week1;

public class Plus_one {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        int[] digits = plusOne(input);
        for(int i = 0; i < digits.length; ++i) {
            System.out.println(digits[i]);
        }
    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
