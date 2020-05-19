package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MainPage;

public class ShopStepDefs {

    @Given("I opened 4FRAG home page")
    public void iOpenedHomePage(){
        new MainPage().openHomePage();
    }

    @When("^I search <item>")
    public void iSearch(String product){
        new MainPage().findProductWIthSearchField(product);
    }

    @Then("<item> is on the wish list page")
   public void itemInTheWishList(){
        new MainPage().openProductInTheWishListPage("Bookmarks").buyButtonForProductInTheWishListPage();
    }

    @And("I add <item> to the wish list page")
    public void wishListPage() {
        new MainPage().addProductToWishListFromResultList();
    }
}
