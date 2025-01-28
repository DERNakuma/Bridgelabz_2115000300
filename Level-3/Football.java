public class Football{
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    public static double findMean(int sum, int size) {
        return (double) sum / size;
    }

    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            shortest = Math.min(shortest, height);
        }
        return shortest;
    }

    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            tallest = Math.max(tallest, height);
        }
        return tallest;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }
        int sum = findSum(heights);
        double mean = findMean(sum, heights.length);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);
        
        System.out.println("Shortest Height: " + shortest + " cm");
        System.out.println("Tallest Height: " + tallest + " cm");
        System.out.println("Mean Height: " + mean + " cm");
    }
}
