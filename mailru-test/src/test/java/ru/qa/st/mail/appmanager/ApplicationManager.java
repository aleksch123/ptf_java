package ru.qa.st.mail.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa.st.mail.pageobjects.MailComposerPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    private final Properties properties;
    private SessionHelper sessionHelper;
    private MailComposerPage mailComposerPage;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();

    }

    public void init() throws IOException {
        wd = new ChromeDriver();
        properties.load(new FileReader(new File("src/test/resources/test.properties")));
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        mailComposerPage = new MailComposerPage(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.Login(properties.getProperty("web.userLogin"), properties.getProperty("web.userPassword"));

    }
    public void stop() {
        wd.quit();
    }

    public MailComposerPage page() {
        return mailComposerPage;
    }

}
