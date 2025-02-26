import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ExtractJsonFields {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(new File("data.json"));
        
        for (JsonNode node : root) {
            System.out.println("Name: " + node.get("name").asText());
            System.out.println("Email: " + node.get("email").asText());
        }
    }
}
