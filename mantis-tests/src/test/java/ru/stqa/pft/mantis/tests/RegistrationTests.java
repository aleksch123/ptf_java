package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.Model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Алексей on 05.07.2017.
 */
public class RegistrationTests extends TestBase
{
    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }
    @Test
    public void testRegistration() throws IOException, MessagingException {
        long now =System.currentTimeMillis();
        String email = String.format("user%s@localhost.localdomain",now);
        String user = String.format("user%s",now);
        String password = "password";
        app.registration().start(user, email);
        List<MailMessage> mailMessages= app.mail().waitForMail(2,10000);
        String confiramationLink = findConfiramationLink(mailMessages, email);

        app.registration().finish(confiramationLink, password);
        assertTrue(app.newSession().login(user,password));
    }

    private String findConfiramationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod
            public void stopMailServer(){
        app.mail().stop();
    }

}
