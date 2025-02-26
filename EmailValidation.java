import org.everit.json.schema.*;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class EmailValidation {
    public static void main(String[] args) {
        String jsonSchema = "{ \"type\": \"object\", \"properties\": { \"email\": { \"type\": \"string\", \"format\": \"email\" } }, \"required\": [\"email\"] }";
        String jsonData = "{ \"email\": \"test@example.com\" }";

        Schema schema = SchemaLoader.load(new JSONObject(jsonSchema));

        try {
            schema.validate(new JSONObject(jsonData));
            System.out.println("Valid email format");
        } catch (ValidationException e) {
            System.out.println("Invalid email: " + e.getMessage());
        }
    }
}
