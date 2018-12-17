package ru.qa.st.mail.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailComposerPage {

    protected WebDriver wd;

    @FindBy(className = "b-toolbar__btn")
    private WebElement composeButton;

    @FindBy(css = "textarea[class*='js-input compose__labels__input']")
    private WebElement corrField;

    @FindBy(name = "Subject")
    private WebElement subField;

    @FindBy(xpath = "//iframe[starts-with(@id,'toolkit-')]")
    private WebElement bodyFrame;

    @FindBy(id = "tinymce")
    private WebElement bodyField;

    @FindBy(xpath = "//*[@data-name='send']/span")
    private WebElement sendButton;

    @FindBy(className = "message-sent__title")
    private WebElement confirmationTitle;

    public MailComposerPage(WebDriver wd) {
        PageFactory.initElements(wd, this);
        this.wd = wd;
    }

    public MailComposerPage withCorrespondent(String corr) {
        corrField.sendKeys(corr);
        return this;
    }

    public MailComposerPage withSubject(String subject) {
        subField.sendKeys(subject);
        return this;
    }

    public MailComposerPage inFrame() {
        wd.switchTo().frame(bodyFrame);
        return this;
    }

    public MailComposerPage outFrame() {
        wd.switchTo().defaultContent();
        return this;
    }

    public MailComposerPage withBody(String body) {
        bodyField.click();
        bodyField.sendKeys(body);
        return this;
    }

    public MailComposerPage sendMail() {
        sendButton.click();

        return this;
    }

    public boolean IsMailSent() {
        return confirmationTitle.getText().equals("Ваше письмо отправлено. Перейти во Входящие");
    }

    public void goToComposer() {
        composeButton.click();
    }
}

