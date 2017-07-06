package ru.stqa.pft.mantis.tests;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.Model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by user on 06.07.2017.
 */
public class ResetPasswordTests extends TestBase {
  @BeforeMethod
  public void startMailServer(){
   app.mail().start();
  }
  @Test
  public void testResetPassword() throws IOException, MessagingException {
    app.goTo().login("administrator","root");
    app.goTo().manage();
    app.goTo().usersTab();
    String username=app.db().getUserName();
    app.resetPassword().select(username);
    app.resetPassword().init();
    List<MailMessage> mailMessages= app.mail().waitForMail(1,10000);
    String email = username+"@localhost.localdomain";
    String confiramationLink = findConfiramationLink(mailMessages, email);
    String newPassword = String.valueOf(System.currentTimeMillis());
    app.resetPassword().finish(confiramationLink, newPassword);
    Assert.assertTrue(app.newSession().login(username,newPassword));
  }
  @AfterMethod
  public void stopMailServer()
  {
    app.mail().stop();
  }


}
