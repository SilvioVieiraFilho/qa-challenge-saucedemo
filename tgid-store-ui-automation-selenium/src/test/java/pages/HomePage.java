package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔥 LOCATORS MELHORADOS (mais estáveis)

    private By btnEntrar = By.xpath("//button[contains(text(),'Entrar')]");
    private By btnProdutos = By.xpath("//a[contains(@href,'produtos')]");
    private By btnHome = By.xpath("//a[contains(text(),'Home')]");
    private By btnCarrinho = By.xpath("//a[contains(@href,'carrinho')]");
    private By btnComprarAgora = By.xpath("//button[contains(text(),'Comprar')]");

    // AÇÕES

    public void clicarEntrar() {
        wait.until(ExpectedConditions.elementToBeClickable(btnEntrar)).click();
    }

    public void clicarProdutos() {
        wait.until(ExpectedConditions.elementToBeClickable(btnProdutos)).click();
    }

    public void clicarHome() {
        wait.until(ExpectedConditions.elementToBeClickable(btnHome)).click();
    }

    public void clicarCarrinho() {
        wait.until(ExpectedConditions.elementToBeClickable(btnCarrinho)).click();
    }

    public void clicarComprarAgora() {
        wait.until(ExpectedConditions.elementToBeClickable(btnComprarAgora)).click();
    }

    // VALIDAÇÕES

    public boolean isBotaoEntrarVisivel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(btnEntrar)).isDisplayed();
    }

    public boolean isBotaoProdutosVisivel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(btnProdutos)).isDisplayed();
    }

    public boolean isBotaoCarrinhoVisivel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(btnCarrinho)).isDisplayed();
    }

    public boolean isBotaoComprarVisivel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(btnComprarAgora)).isDisplayed();
    }
}