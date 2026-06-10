package steps;

import base.BaseTest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {

    private LoginPage loginPage;

    private LoginPage getLoginPage() {

        if (loginPage == null) {
            loginPage = new LoginPage(BaseTest.getDriver());
        }

        return loginPage;
    }

    @Dado("que o usuário está na tela de login")
    public void acessarTelaLogin() {

        BaseTest.getDriver()
                .get("https://tgid-store-test.web.app/login");

        loginPage = new LoginPage(BaseTest.getDriver());
    }

    @Quando("informar email {string}")
    public void informarEmail(String email) {

        getLoginPage().preencherEmail(email);
    }

    @Quando("informar senha {string}")
    public void informarSenha(String senha) {

        getLoginPage().preencherSenha(senha);
    }

    @Quando("clicar em entrar")
    public void clicarEntrar() {

        getLoginPage().clicarEntrar();
    }

    @Entao("o sistema deve autenticar o usuário")
    public void validarAutenticacao() {

        WebDriver driver = BaseTest.getDriver();

        String pagina = driver.getPageSource();

        if (pagina.contains("Credenciais inválidas")) {

            throw new AssertionError(
                    "Falha na autenticação."
            );
        }

        System.out.println("Login realizado com sucesso.");
    }

    @Entao("redirecionar para a página inicial")
    public void validarRedirecionamento() {

        WebDriver driver = BaseTest.getDriver();

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("login")
        ));

        System.out.println(
                "URL atual: " + driver.getCurrentUrl()
        );
    }
    @Entao("exibir o botão {string}")
    public void validarBotao(String texto) {

        WebDriver driver = BaseTest.getDriver();

        boolean encontrado = driver
                .findElements(
                        By.xpath("//*[contains(text(),'" + texto + "')]")
                )
                .size() > 0;

        if (!encontrado) {

            throw new AssertionError(
                    "Botão não encontrado: " + texto
            );
        }

        System.out.println("Botão encontrado: " + texto);
    }
}