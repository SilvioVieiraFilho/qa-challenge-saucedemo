package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // LOCATORS
    private By cep = By.name("cep");
    private By rua = By.name("rua");
    private By numero = By.name("numero");
    private By cidade = By.name("cidade");
    private By estado = By.name("estado");

    private By botaoConfirmar = By.xpath("//button[contains(.,'Confirmar Pedido')]");
    private By mensagemSucesso = By.xpath("//*[contains(text(),'Pedido realizado')]");

    // ACTIONS

    public void preencherEndereco() {
        preencher(cep, "09720000");
        preencher(rua, "Rua Teste");
        preencher(numero, "100");
        preencher(cidade, "São Bernardo do Campo");
        preencher(estado, "SP");
    }

    private void preencher(By locator, String value) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        el.clear();
        el.sendKeys(value);
    }

    public void limparCampos() {
        limpar(cep);
        limpar(rua);
        limpar(numero);
        limpar(cidade);
        limpar(estado);
    }

    private void limpar(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }

    public void clicarConfirmarPedido() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(botaoConfirmar));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", btn);

        btn.click();
    }

    // VALIDATIONS

    public boolean botaoConfirmarHabilitado() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(botaoConfirmar)).isEnabled();
    }

    public boolean mensagemSucessoVisivel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemSucesso))
                .getText()
                .toLowerCase()
                .contains("pedido realizado");
    }
}