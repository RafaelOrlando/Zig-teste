package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class microfone {
    @Test
    public void testDesafioMicrofone()  {
        // Configurar o caminho para o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "/home/rafael-orlando/drivers/chromedriver");

        // Como interagir com o pop-up
        //B) Clique em [Click here to allow access to microphone identifiers] e C) Interaja com o pop up do navegador dando permissão ao acesso ao microfone
        HashMap<String, Integer> conentSettings = new HashMap<String, Integer>();
        HashMap<String, Object> profile = new HashMap<String, Object>();
        HashMap<String, Object> prefs = new HashMap<String, Object>();

        conentSettings.put("media_stream", 1);
        profile.put("managed_default_content_settings", conentSettings);
        prefs.put("profile", profile);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();

        // Inicializar o WebDriver do Chrome, maximizar a tela e aguardar os elementos renderizar
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //A) Acessar o site
        driver.get("https://mictests.com/");

        // Esperar o elemento para poder clicar
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Clique em [Click here to allow access to microphone identifiers] - Não tem utilidade por questoẽs da função de permitir os pop-ups
        //driver.findElement(By.xpath("//button[text()='Click here to allow access to microphone identifiers']")).click();

        //D) Verificar a mensagem
        String texto = driver.findElement(By.xpath("//*[contains(text(),'Several microphones were detected. To check the functionality and supported properties of your microphone, select it from the list below and press “Test my mic”. Please note that in order to obtain more accurate results it is recommended to keep enabled only one microphone.')]")).getText();
        System.out.println(texto);


        //Assert.assertEquals("Several microphones were detected. To check the functionality and supported properties of your microphone, select it from the list below and press “Test my mic”. Please note that in order to obtain more accurate results it is recommended to keep enabled only one microphone.", texto);
    }
}