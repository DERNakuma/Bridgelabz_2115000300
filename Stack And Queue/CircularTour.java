public class CircularTour {

    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0; 
        int deficit = 0;
        int surplus = 0; 
        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];
            if (surplus < 0) {
                
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);

        if (start != -1) {
            System.out.println("Starting point for the circular tour: " + start);
        } else {
            System.out.println("No valid starting point exists.");
        }
    }
}