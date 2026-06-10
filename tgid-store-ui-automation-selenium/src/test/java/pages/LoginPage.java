package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(name = "email")
    WebElement email;

    @FindBy( name = "senha")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnEntrar;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void preencherEmail(String valor){
        email.sendKeys(valor);
    }

    public void preencherSenha(String valor){
        password.sendKeys(valor);
    }

    public void clicarEntrar(){
        btnEntrar.click();
    }
}