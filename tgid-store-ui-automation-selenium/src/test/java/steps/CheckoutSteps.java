package steps;

import base.BaseTest;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutPage;

import java.time.Duration;

public class CheckoutSteps {

    private CheckoutPage checkoutPage;

    private CheckoutPage page() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(BaseTest.getDriver());
        }
        return checkoutPage;
    }

    // -------------------------
    // GIVEN
    // -------------------------

    @Dado("usuário está na página inicial")
    public void home() {
        BaseTest.getDriver().get("https://tgid-store-test.web.app");
    }

    @Dado("usuário está na tela de checkout")
    public void checkout() {
        BaseTest.getDriver().get("https://tgid-store-test.web.app/checkout");
    }

    @Dado("usuário possui um produto no carrinho")
    public void produtoNoCarrinho() {

        System.out.println("Adicionando produto no carrinho...");

        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        // EXEMPLO: ajustar conforme seu site real
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(.,'Adicionar ao carrinho') or contains(.,'Comprar')]")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(.,'Carrinho') or contains(.,'Checkout')]")
        )).click();
    }

    // -------------------------
    // WHEN
    // -------------------------

    @Quando("preencher todos os campos obrigatórios")
    public void preencherCampos() {
        page().preencherEndereco();
    }

    @Quando("deixar campos obrigatórios vazios")
    public void limparCampos() {
        page().limparCampos();
    }

    @Quando("confirmar pedido")
    public void confirmar() {
        page().clicarConfirmarPedido();
    }

    @Quando("clicar em {string}")
    public void clicarBotao(String texto) {

        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(.,'" + texto + "')]")
        )).click();
    }

    // -------------------------
    // THEN
    // -------------------------

    @Entao("deve ser redirecionado para checkout")
    public void validaCheckout() {
        Assert.assertTrue(BaseTest.getDriver().getCurrentUrl().contains("checkout"));
    }

    @Entao("botão confirmar pedido deve permanecer desabilitado")
    public void botaoDesabilitado() {
        Assert.assertFalse(page().botaoConfirmarHabilitado());
    }

    @Entao("pedido deve ser finalizado com sucesso")
    public void sucesso() {

        WebDriverWait wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(15));

        String texto = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Pedido realizado')]")
                )
        ).getText();

        Assert.assertTrue(texto.toLowerCase().contains("pedido realizado"));
    }

    @Entao("exibir mensagem de confirmação")
    public void mensagem() {
        Assert.assertTrue(page().mensagemSucessoVisivel());
    }
}