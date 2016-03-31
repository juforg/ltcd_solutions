package top.appcity.ltcd;

import java.util.Arrays;

public class BestTimetoBuyandSellStockII {
	int[] estimateProfitPDay;
	public int maxProfit(int[] prices) {
		int len = prices.length;
		estimateProfitPDay = new int[len-1];
		return estimateProfit(prices,1);
	}
	
	public int estimateProfit(int[] prices,int level) {
		int len = prices.length;
		int[] estProfittmp = new int[len-1];
		 //buy first day and estimate sell next every day profit
		for(int i = 0; i<len-1;i++){
            for (int j = i+1; j < len; j++) {
            	if (prices[j]<prices[i]) {
					continue;
				}
	             estimateProfitPDay[i] += prices[j]-prices[i];
	           	 if (len>2) {
	           		 estimateProfitPDay[i] += estimateProfit(Arrays.copyOfRange(prices,j,len),level+1);
	           	 }
			}
        }
		return getMaxProfitPday(estimateProfitPDay);
    }
	
	private int getMaxProfitPday(int[] estimateProfitPDay){
		int prof = 0;
		for (int i : estimateProfitPDay) {
			if (i>prof) {
				prof = i;
			}
		}
		return prof;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = new int[]{1,43,4,2};
		BestTimetoBuyandSellStockII t = new BestTimetoBuyandSellStockII();
		System.out.println(t.maxProfit(test));
	}

}
