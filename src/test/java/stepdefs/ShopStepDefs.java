package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.User;
import org.testng.Assert;
import pages.MainPage;
import pages.PersonalAreaPage;
import pages.WishListPage;
import service.UserCreator;

public class ShopStepDefs {

    private MainPage mainPage = new MainPage();
    private WishListPage wishListPage = new WishListPage();

    @Given("^I opened 4FRAG home page$")
    public void iOpenedHomePage() {
        mainPage.openHomePage();
    }

    @When("^I search \"([^\"]*)\"$")
    public void iSearch(String product) {
        mainPage.findProductWIthSearchField(product);
    }

    @When("^I add \"([^\"]*)\" to the wish list page$")
    public void iAddItemToTheWishListPage(String item) {
        mainPage.addProductToWishListFromResultList(item);
    }

    @Then("^\"([^\"]*)\" is on the wish list page$")
    public void isOnWishListPage(String item) {
        Assert.assertTrue(wishListPage.isProductInTheWithListPageDisplayed(item),
                "The product " + item + " wasn't displayed on the with list page");
    }

    @When("^I log in to the site using header tab \"([^\"]*)\"$")
    public void iLogInToSiteUsingHeaderTab(String loginTabLabel) {
        User testUser = UserCreator.withCredentialsFromProperty();
        PersonalAreaPage loginPage = new MainPage()
                .openHomePage()
                .openLoginPage(loginTabLabel)
                .fillOutLoginInformation(testUser);
        Assert.assertEquals(loginPage.personalPageHeader().getText(), "Подписка");
    }

    @When("^I close \"([^\"]*)\" notification pop-up$")
    public void iCloseNotificationPopUp(String popUpTitle) {
        mainPage.notificationPopUpCloseButton(popUpTitle).click();
        mainPage.waitPageIsLoadedAndJQueryIsProcessed();
    }

    @When("^I open tab \"([^\"]*)\"$")
    public void iOpenTab(String tab) {
        mainPage.headerTab(tab).click();
        mainPage.waitPageIsLoadedAndJQueryIsProcessed();
    }
}
