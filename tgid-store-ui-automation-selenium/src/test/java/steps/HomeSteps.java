package steps;

import base.BaseTest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomeSteps {

    private WebDriver driver;
    private HomePage home;

    @Dado("que o usuário está na página inicial")
    public void abrirHome() {

        driver = BaseTest.getDriver();
        driver.get("https://tgid-store-test.web.app/");

        home = new HomePage(driver);
    }

    @Quando("o usuário clica no botão {string}")
    public void clicarBotao(String botao) {

        switch (botao.toLowerCase()) {

            case "entrar":
                home.clicarEntrar();
                break;

            case "produtos":
                home.clicarProdutos();
                break;

            case "carrinho":
                home.clicarCarrinho();
                break;

            case "comprar agora":
                home.clicarComprarAgora();
                break;

            default:
                throw new RuntimeException("Botão não encontrado: " + botao);
        }
    }

    @Entao("o sistema deve redirecionar para a tela de login")
    public void validarLogin() {

        validarUrl("login");
    }

    @Entao("o sistema deve exibir a lista de produtos")
    public void validarProdutos() {

        validarUrl("produtos");
    }

    @Entao("o sistema deve redirecionar para o checkout")
    public void validarCheckout() {

        validarUrl("checkout");
    }

    private void validarUrl(String expected) {

        String url = driver.getCurrentUrl();

        if (!url.contains(expected)) {
            throw new AssertionError(
                    "Esperado conter: " + expected + " | Atual: " + url
            );
        }
    }
}