package Base;


import Environment.GlobalVariables;
import Pojo.Ppet;
import Tools.ConnectionsTools;

import java.io.IOException;

import static org.junit.Assert.*;

public class BaseStep {

    GlobalVariables globalVariables = new GlobalVariables();
    ConnectionsTools connectionsTools = new ConnectionsTools();

    public String baseUrl = globalVariables.getBaseUrl();

    public void loadAllPets() throws IOException {
        assertNotEquals("The petition to the API failed", connectionsTools.getJson(baseUrl + globalVariables.getGetList()).isEmpty(), "");
    }


    public Ppet createNewPet(String name) throws Exception {

        return null;
    }

}
