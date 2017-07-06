package ru.stqa.pft.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.mantis.tests.TestBase;

/**
 * Created by user on 06.07.2017.
 */
public class ResetPasswordHelper extends HelperBase{

  private  ApplicationManager app;
  private WebDriver wd;

  public ResetPasswordHelper(ApplicationManager app) {
    super(app);
    wd =app.getDriver();
  }

  public void select(String username){
    click(By.linkText("user1499304967042"));
  }

  public void init() {
    click(By.xpath("//input[@value='Reset Password']"));

  }

  public void finish(String confiramationLink, String password) {
    wd.get(confiramationLink);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.xpath("//button[@type='submit']"));

  }
}
