package kata5.webservice.service;

public class InternalServiceResponse implements InternalService {

    @Override
    public String processRequest(String jsonRequest) {
        return jsonRequest;
    }
}
