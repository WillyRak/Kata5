package kata5.webservice.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonXmlAdapter implements Adapter{
    @Override
    public String adaptRequest(String jsonRequest) {
        return jsonRequest;
    }

    @Override
    public String adaptResponse(String jsonResponse) {
        try {
            JsonNode jsonNode = new ObjectMapper().readTree(jsonResponse);
            return new XmlMapper().writeValueAsString(jsonNode);
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
