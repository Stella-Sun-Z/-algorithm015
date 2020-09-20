package Week4;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    //贪心算法
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i])
                res += prices[i + 1] - prices[i];
        }
        return res;
    }
}
