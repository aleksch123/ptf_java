package ru.qa.st.mail.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMailTest extends TestBase {

    @Test
    public void sendMailViaUI(){

    app.page().goToComposer();
    app.page().withCorrespondent("ssss.utest@gmail.com")
            .withSubject("TestSub")
            .inFrame()
            .withBody("Test Message")
            .outFrame().sendMail();
    Assert.assertTrue(app.page().IsMailSent(),"Письмо не отправлено");
    }

}
