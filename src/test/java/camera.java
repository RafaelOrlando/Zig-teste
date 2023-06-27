package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class camera {
    @Test
    public void testDesafioCamera() {
        // Configurar o caminho para o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "/home/rafael-orlando/drivers/chromedriver");

        // Como interagir com o pop-up
        //B) Clique em [Clique aqui para permitir o acesso a identificadores de webcam] e C) Interaja com o pop up do navegador dando permissão ao acesso ao microfone
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
        driver.get("https://pt.webcamtests.com/");

        // Esperar o elemento para poder clicar
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Clique em [Clique aqui para permitir o acesso a identificadores de webcam] - Não tem utilidade por questoẽs da função de permitir os pop-ups
        //driver.findElement(By.cssSelector("#webcam-notices > li.notice-injected.notice-fail > button")).click();

        //D) Verificar a mensagem
        String texto = driver.findElement(By.xpath("//*[@class='notice-done done_webcamDetectedOne']")).getText();


        //Assert.assertEquals("Uma webcam foi detectada. Pressione “Teste minha cam” para verificar a funcionalidade e as propriedades suportadas de sua câmera.", texto);
        //String expectedString = "Uma webcam foi detectada. Pressione “Teste minha cam” para verificar a funcionalidade e as propriedades suportadas de sua câmera.";
        //assertTrue(texto.contains(expectedString));
    }
}
