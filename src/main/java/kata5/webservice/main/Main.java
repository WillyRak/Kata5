package kata5.webservice.main;

import kata5.webservice.adapter.Adapter;
import kata5.webservice.adapter.JsonXmlAdapter;
import kata5.webservice.service.InternalService;
import kata5.webservice.service.InternalServiceResponse;
import spark.Spark;

public class Main {

    public static void main(String[] args) {
        Spark.port(8080);

        InternalService internalService = new InternalServiceResponse();
        Adapter adapter = new JsonXmlAdapter();

        Spark.post("/process", ((request, response) -> {
            String jsonRequest = request.body();
            String internalRequest = adapter.adaptRequest(jsonRequest);
            String internalResponse = internalService.processRequest(internalRequest);
            String xmlResponse = adapter.adaptResponse(internalResponse);
            response.type("application/xml");
            return xmlResponse;
        }));
    }
}
