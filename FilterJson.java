import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FilterJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(new File("data.json"));

        for (JsonNode node : root) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        }
    }
}
