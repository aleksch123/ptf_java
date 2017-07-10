package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {

    private final Properties properties;
    private WebDriver wd;

    private String browser;
    private RegistrationHelper registrationHalper;
    private FtpHelper ftp;
    private MailHelper mailHalper;
    private NavigationHelper navigationHelper;
    private ResetPasswordHelper resetPassword;
    private DbHelper db;
    private SoapHelper soapHelper;

    public ApplicationManager(String browser)  {
        this.browser = browser;
        properties = new Properties();
    }

     public void init() throws IOException {

        String target= System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));




        }
    public void stop() {
        if (wd!=null){
       wd.quit();}
    }
 public HttpSession  newSession() {
     return new HttpSession(this);
 }
 public String getProperty(String key){
        return properties.getProperty(key);
 }

    public RegistrationHelper registration() {
     if(registrationHalper==null) {
         registrationHalper = new RegistrationHelper(this);
     }
     return registrationHalper;
    }
  public ResetPasswordHelper resetPassword() {
    if(resetPassword==null) {
      resetPassword = new ResetPasswordHelper(this);
    }
    return resetPassword;
  }

    public FtpHelper ftp(){
     if (ftp==null){
         ftp= new FtpHelper(this);
     }
     return ftp;
    }
    public DbHelper db(){
        if (db==null){
            db= new DbHelper(this);
        }
        return db;
    }


    public WebDriver getDriver() {
     if (wd==null){
         if (browser.equals(BrowserType.FIREFOX)) {
             wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
         } else if (browser.equals(BrowserType.CHROME)) {
             wd = new ChromeDriver();
         } else if (browser.equals(BrowserType.IE)) {
             wd = new InternetExplorerDriver();
         }
         wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         wd.get(properties.getProperty("web.baseUrl"));
     }
        return wd;
    }

    public MailHelper mail(){
        if(mailHalper==null) {
            mailHalper = new MailHelper(this);
        }
        return mailHalper;
        }
  public NavigationHelper goTo(){
    if(navigationHelper==null) {
      navigationHelper = new NavigationHelper(this);
    }
    return navigationHelper;
  }

  public SoapHelper soap(){

      if(soapHelper==null) {
          soapHelper = new SoapHelper(this);
      }
      return soapHelper;

  }

}
