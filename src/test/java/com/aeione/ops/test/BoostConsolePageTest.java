package com.aeione.ops.test;
import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class BoostConsolePageTest extends TestSetUp {
    public LoginPageActions getLoginPage() throws IOException {
        return new LoginPageActions();
    }

    public HomePageActions getHomePageActions() throws IOException {
        return new HomePageActions();
    }

    public BoostConsoleActions getBoostConsoleActions() throws IOException {
        return new BoostConsoleActions();
    }



    public GoogleSheetAPI sheetAPI() throws IOException {
        return new GoogleSheetAPI();
    }

    public GoogleDriveAPI dsriveAPI() throws IOException {
        return new GoogleDriveAPI();
    }

    /**
     * Test_Cases_To_Verify the boost Console under profile drop down
     * Author:- Smita Sahoo
     */


    @Test(priority = 139, enabled = true, alwaysRun = true, description = "Verify the boost Console under profile drop down")
    public void tc_BC_01_P1_verifyBoostConsoleIconInProfileDropdownTest () throws Exception {
        String range = "Login!A9:C9";
        String range1 = "Home page!A2:B2";

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number = val.get("UserName / Email / PhoneNumber");
        String password = val.get("Password");
        String fullname = val.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getBoostConsoleActions().verifyDisplayOfBoostConsoleOption("Verify Step");
    }

    /**
     * Test_Cases_To_Verify the boosted post in the Boosted Console
     * Author:- Smita Sahoo
     */


    @AfterMethod(dependsOnMethods = {"com.aeione.ops.generic.TestSetUp.afterMethod"})
    public void after () throws IOException {
        getHomePageActions().navigateHomePage();
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");
    }


}
