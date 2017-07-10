package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.Model.MailMessage;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class TestBase {

    public static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));


    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        //    app.ftp().upload(new File("src/test/resources/config_inc.php"),"config_inc.php","config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)

    public void tearDown() throws IOException {
        //      app.ftp().restore("config_inc.php.bak","config_inc.php");
        app.stop();
    }


    protected String findConfiramationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    public boolean isIssueOpen(int issueId) throws IOException, ServiceException {
        String issueStatus = app.soap().getIssueStatusById(issueId);
        if (issueStatus.equals("resolved") || issueStatus.equals("closed")) {
            return false;
        } else
            return true;
    }

    public void skipIfNotFixed(int issueId) throws IOException, ServiceException, SkipException {
        if (isIssueOpen(issueId)) {
           throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}

