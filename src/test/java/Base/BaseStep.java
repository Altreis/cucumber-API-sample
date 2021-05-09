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
    private String available = "available";
    private String get = "GET";
    private String put = "PUT";
    private String post = "POST";
    private String delete = "DELETE";
    private String ok = "200";
    private String error = "The petition to the API failed";

    public void loadAllPets() throws IOException {
        assertEquals(error, connectionsTools.getJson(baseUrl + globalVariables.getGetList(), get, true), ok);
    }

    public Ppet createNewPet(String name) throws Exception {
        Ppet ppet = new Ppet(0, new Pcategory(0, ""), name, new ArrayList<>(), new ArrayList<>(), available);
        ppet = connectionsTools.postJson(ppet, baseUrl, post);
        assertNotEquals(error, String.valueOf(ppet.getId()), "0");
        return ppet;
    }

    public Ppet changePet(Ppet ppet, String status) throws Exception {
        ppet.setStatus(status);
        ppet = connectionsTools.postJson(ppet, baseUrl, put);
        assertNotEquals(error, String.valueOf(ppet.getId()), "0");
        return ppet;
    }

    public void checkPet(Ppet ppet, boolean exists) throws Exception{
        if (exists) assertEquals(error, connectionsTools.getJson(baseUrl + "/" + ppet.getId(), delete, true), ok);
        else assertEquals(error, connectionsTools.getJson(baseUrl + "/" + ppet.getId(), delete, false), "404");
    }

    public void deletePet(Ppet ppet) throws Exception {
        connectionsTools.getJson(baseUrl + "/" + ppet.getId(), delete, true);
    }

}
