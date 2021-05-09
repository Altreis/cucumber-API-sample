package Environment;


public class GlobalVariables {

    private String baseUrl = "https://petstore.swagger.io/v2/pet";
    private String getList = "/findByStatus?status=available";

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getGetList() {
        return getList;
    }



}
