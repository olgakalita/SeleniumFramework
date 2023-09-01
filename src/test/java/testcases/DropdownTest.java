package testcases;

import org.testng.annotations.Test;

public class DropdownTest extends BaseTest{

    @Test
    public void dropdown() throws InterruptedException {
        homePage.openPage();
        homePage.signUp();
        signUpPage.dropdownMenu();
    }
}
