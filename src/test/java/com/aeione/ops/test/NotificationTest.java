package com.aeione.ops.test;

import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.LoginPageActions;
import com.aeione.ops.pageactions.NotificationActions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class NotificationTest extends TestSetUp
{
    public LoginPageActions getLoginPage() throws IOException {
        return new LoginPageActions();
    }

    public NotificationActions getNotificationActions() throws IOException {
        return new NotificationActions();
    }
    public GoogleSheetAPI sheetAPI() throws IOException

    {
        return new GoogleSheetAPI();
    }

    @Test(priority = 92, enabled = true, alwaysRun = true, description = "Verify Notification icon functionality")
    public void tc_NT_01_P1_VerifyNotificationIconTest() throws Exception
    {
        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getNotificationActions().clickOnNotificationBellIcon("Action  Step");
        getNotificationActions().verifyDisplayOfNotificationDropdown("Verify Step");

    }
}
