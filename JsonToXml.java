import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {
    public static void main(String[] args) {
        String json = "{\"name\":\"Alice\",\"age\":25}";
        JSONObject jsonObject = new JSONObject(json);
        String xml = XML.toString(jsonObject);
        System.out.println(xml);
    }
}
