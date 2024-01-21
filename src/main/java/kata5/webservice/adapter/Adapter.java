package kata5.webservice.adapter;

public interface Adapter {
    String adaptRequest(String jsonRequest);
    String adaptResponse(String jsonRequest);
}
