public class StringConcat{
    public static String concatenateUsingString(int iterations) {
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "a";
        }
        return result;
    }

    public static String concatenateUsingStringBuilder(int iterations) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append("a");
        }
        return builder.toString();
    }

    public static String concatenateUsingStringBuffer(int iterations) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            buffer.append("a");
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        int[] testSizes = {1000, 10000, 100000};
        
        for (int size : testSizes) {
            
            long startTime = System.nanoTime();
            String stringResult = concatenateUsingString(size);
            long endTime = System.nanoTime();
            long stringTime = endTime - startTime;
            
            startTime = System.nanoTime();
            String stringBuilderResult = concatenateUsingStringBuilder(size);
            endTime = System.nanoTime();
            long stringBuilderTime = endTime - startTime;
            
            startTime = System.nanoTime();
            String stringBufferResult = concatenateUsingStringBuffer(size);
            endTime = System.nanoTime();
            long stringBufferTime = endTime - startTime;

            System.out.println("Length: " + size);
            System.out.println("String Concatenation Time: " + stringTime / 1000000.0 + " ms");
            System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime / 1000000.0 + " ms");
            System.out.println("StringBuffer Concatenation Time: " + stringBufferTime / 1000000.0 + " ms");
        }
    }
}
