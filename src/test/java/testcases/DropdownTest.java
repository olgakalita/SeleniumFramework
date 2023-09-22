package testcases;

import org.testng.annotations.Test;

public class DropdownTest extends BaseTest{

    @Test(groups={"newFeature"})
    public void dropdown() throws InterruptedException {
        System.out.println("new Feature dropDown");
        homePage.openPage();
        homePage.signUp();
        signUpPage.dropdownMenu();
    }
}
