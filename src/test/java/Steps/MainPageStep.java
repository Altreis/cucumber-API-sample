package Steps;

import Pages.MainPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class MainPageStep {

    public MainPage mainPage = new MainPage();

    @Given("^All the available pets$")
    public void all_the_available_pets() throws Throwable {
        mainPage.loadAllPets();
    }

    @When("^Add a new pet named \"([^\"]*)\"$")
    public void add_a_new_pet_named(String arg1) throws Throwable {
        mainPage.createNewPet(arg1);
    }

    @When("^Change the pet status to \"([^\"]*)\"$")
    public void change_the_pet_status_to(String arg1) throws Throwable {
        mainPage.changePetStatus(arg1);
    }

    @Then("^Delete the pet$")
    public void delete_the_pet() throws Throwable {
        mainPage.deletePet();
    }

}
