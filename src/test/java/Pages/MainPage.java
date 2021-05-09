package Pages;

import Base.BaseStep;
import Pojo.Ppet;


import java.io.IOException;


public class  MainPage {
    Ppet pet;
    BaseStep baseStep = new BaseStep();

    public void loadAllPets() throws IOException {
        baseStep.loadAllPets();
    }

    public void createNewPet(String name) throws Exception {
        pet = baseStep.createNewPet(name);
        baseStep.checkPet(pet, true);
    }

    public void changePetStatus(String status) throws Exception {
        pet = baseStep.changePet(pet, status);
        baseStep.checkPet(pet, true);
    }

    public void deletePet() throws Exception {
        baseStep.deletePet(pet);
        baseStep.checkPet(pet, false);
    }

}
