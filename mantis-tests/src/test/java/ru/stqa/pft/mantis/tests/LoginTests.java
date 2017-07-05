package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Алексей on 05.07.2017.
 */
public class LoginTests extends TestBase {

    @Test

    public void testLogin()throws IOException{
        HttpSession session =app.NewSession();
        assertTrue(session.login("administrator","root"));
        assertTrue(session.isLoggedInAs("administrator"));
    }
}
