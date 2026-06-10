package steps;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {

    @Before
    public void setup() {

        BaseTest.getDriver();

    }

    @After
    public void tearDown() {

        BaseTest.quitDriver();



    }

    @Before("@carrinho")
    public void setupCarrinho() {

        WebDriver driver = BaseTest.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tgid-store-test.web.app");

        System.out.println("🔧 Criando carrinho para cenário @carrinho");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(normalize-space(),'Comprar Agora')]")
        )).click();

        wait.until(ExpectedConditions.urlContains("checkout"));
    }

}