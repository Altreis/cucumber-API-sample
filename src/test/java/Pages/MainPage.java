package Pages;

import Base.BaseStep;
import Environment.GlobalVariables;
import Pojo.Ppet;
import Tools.ConnectionsTools;


import java.io.IOException;


public class  MainPage {
    Ppet pet;
    BaseStep baseStep = new BaseStep();

    public void loadAllPets() throws IOException {
        baseStep.loadAllPets();
    }

    public void createNewPet(String name) throws Exception {
        pet = baseStep.createNewPet(name);
    }

}
