/**
Suppose we could access yesterday's stock prices as an array, where:

The values are the price in dollars of Apple stock.
A higher index indicates a later time.
So if the stock cost $500 at 10:30am and $550 at 11:00am, then:

stockPricesYesterday[60] = 500;

Write an efficient function that takes stockPricesYesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

For example:

  int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};

getMaxProfit(stockPricesYesterday);
// returns 6 (buying for $5 and selling for $11)

No "shorting"—you must buy before you sell. You may not buy and sell in the same time step (at least 1 minute must pass).

*/

public static int findProfit(int arr[]) { // 7, 1, 5, 3, 6, 4

        if(arr.length < 2){
			throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }

       	int maxProfit = arr[1] - arr[0];
        int minPrice = arr[0];
        for(int i = 1; i < arr.length; i++){
			int currPrice = arr[i];

            int potentialProf = currPrice - minPrice;

            if(potentialProf > maxProfit)
                maxProfit = potentialProf;

            if(currPrice < minPrice)
                minPrice = currPrice;
        }


		return maxProfit;
}
