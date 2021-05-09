package Base;


import Environment.GlobalVariables;
import Pojo.Pcategory;
import Pojo.Ppet;
import Tools.ConnectionsTools;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BaseStep {

    GlobalVariables globalVariables = new GlobalVariables();
    ConnectionsTools connectionsTools = new ConnectionsTools();

    private String baseUrl = globalVariables.getBaseUrl();
    private static final String AVAILABLE = "available";
    private static final String GET = "GET";
    private static final String PUT = "PUT";
    private static final String POST = "POST";
    private static final String DELETE = "DELETE";
    private static final String OK = "200";
    private static final String ERROR = "The petition to the API failed";

    public void loadAllPets() throws IOException {
        assertEquals(ERROR, connectionsTools.getJson(baseUrl + globalVariables.getGetList(), GET, true), OK);
    }

    public Ppet createNewPet(String name) throws Exception {
        Ppet ppet = new Ppet(0, new Pcategory(0, ""), name, new ArrayList<>(), new ArrayList<>(), AVAILABLE);
        ppet = connectionsTools.postJson(ppet, baseUrl, POST);
        assertNotEquals(ERROR, String.valueOf(ppet.getId()), "0");
        return ppet;
    }

    public Ppet changePet(Ppet ppet, String status) throws Exception {
        ppet.setStatus(status);
        ppet = connectionsTools.postJson(ppet, baseUrl, PUT);
        assertNotEquals(ERROR, String.valueOf(ppet.getId()), "0");
        return ppet;
    }

    public void checkPet(Ppet ppet, boolean exists) throws Exception{
        if (exists) assertEquals(ERROR, connectionsTools.getJson(baseUrl + "/" + ppet.getId(), GET, true), OK);
        else assertEquals(ERROR, connectionsTools.getJson(baseUrl + "/" + ppet.getId(), GET, false), "404");
    }

    public void deletePet(Ppet ppet) throws Exception {
        connectionsTools.getJson(baseUrl + "/" + ppet.getId(), DELETE, true);
    }

}
