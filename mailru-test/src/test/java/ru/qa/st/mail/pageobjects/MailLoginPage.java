package ru.qa.st.mail.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailLoginPage  {


    protected WebDriver wd;


    @FindBy(name = "login")
    private  WebElement loginField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(id = "mailbox:submit")
    private WebElement submit;

    public MailLoginPage(WebDriver wd) {
        PageFactory.initElements(wd, this);
        this.wd = wd;
    }

    public MailLoginPage withLogin(String login){
        loginField.sendKeys(login);
        return this;
    }

    public MailLoginPage withPass(String pass){
        passwordField.sendKeys(pass);
        return this;
    }

    public MailLoginPage logInMailBox(){
        submit.click();
        return this;
    }
}
