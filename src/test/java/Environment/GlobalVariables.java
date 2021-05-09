package Environment;


public class GlobalVariables {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet";
    private static final String GET_LIST = "/findByStatus?status=available";

    public String getBaseUrl() {
        return BASE_URL;
    }

    public String getGetList() {
        return GET_LIST;
    }



}
