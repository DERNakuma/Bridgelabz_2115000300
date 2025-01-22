public class ProfitPercentage{
    public static void main(String[] args) {
        int costPrice=129, sellingPrice=191,profit;
        double profittPercentage;
        profit=sellingPrice-costPrice;

        profittPercentage=((double)profit/costPrice)*100;

        System.out.println("The Cost Price is INR "+costPrice+" and Selling Price is INR "+ sellingPrice+"\n"+"The Profit is INR "+profit+"  and the Profit Percentage is "+profittPercentage);


    }
}