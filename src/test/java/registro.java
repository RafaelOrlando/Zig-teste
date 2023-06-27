package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class registro {
    @Test
    public void testDesafioRegistro() {
        // Configurar o caminho para o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "/home/rafael-orlando/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Acessar o site
        driver.get("https://demo.automationtesting.in/Register.html");

        //A) Valide os campos obrigatórios
        // Preenche o campo com o nome "Rafael"
        WebElement nomeInput = driver.findElement(By.cssSelector(":nth-child(1) > :nth-child(2) > .form-control"));
        nomeInput.sendKeys("Rafael");

        // Preenche o campo com o sobrenome "Orlando"
        WebElement sobrenomeInput = driver.findElement(By.cssSelector(":nth-child(1) > :nth-child(3) > .form-control"));
        sobrenomeInput.sendKeys("Orlando");

        // Preenche o campo com o email "rafaelorlandoqa@gmail.com"
        WebElement emailInput = driver.findElement(By.cssSelector("#eid > .form-control"));
        emailInput.sendKeys("rafaelorlandoqa@gmail.com");

        // Preenche o campo com o telefone "(11)97585-1132"
        WebElement telefoneInput = driver.findElement(By.cssSelector(":nth-child(4) > .col-md-4 > .form-control"));
        telefoneInput.sendKeys("(11)97585-1132");

        // Clica no botão para selecionar uma opção
        WebElement botaoOpcao = driver.findElement(By.cssSelector(":nth-child(5) > .col-md-4 > :nth-child(1) > input"));
        botaoOpcao.click();

        // Clica no campo para abrir a lista de opções
        WebElement campoOpcoes = driver.findElement(By.cssSelector(".select2-selection"));
        campoOpcoes.click();

        // Preenche o campo de busca de opções com "Japan" e pressiona Enter
        WebElement buscaOpcoes = driver.findElement(By.cssSelector(".select2-search__field"));
        buscaOpcoes.sendKeys("Japan\n");

        //B) Valide o registro com sucesso (informando a foto)
        WebElement fotoInput = driver.findElement(By.cssSelector("#imagesrc"));
        fotoInput.sendKeys("/home/rafael-orlando/Downloads/foto.png");
        String nomeArquivo = fotoInput.getAttribute("value");
        if (nomeArquivo.endsWith("foto.png")) {
            System.out.println("Registro validado com sucesso.");
        } else {
            System.out.println("Erro ao validar o registro.");
        }
    }
}
