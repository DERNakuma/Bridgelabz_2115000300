public class Search {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) return sentence;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is a powerful language.",
            "I love programming.",
            "Data structures are important."
        };
        System.out.println(findSentence(sentences, "programming"));
    }
}
