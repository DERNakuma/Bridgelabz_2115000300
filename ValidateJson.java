import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ValidateJson {
    public static void main(String[] args) {
        String json = "{\"name\":\"Alice\",\"age\":25}";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            System.out.println("Valid JSON: " + jsonNode.toPrettyString());
        } catch (JsonProcessingException e) {
            System.out.println("Invalid JSON");
        }
    }
}
