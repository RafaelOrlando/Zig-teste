package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class localizacao {
    @Test
    public void testDesafioLocalizacao() {
        // Configurar o caminho para o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "/home/rafael-orlando/drivers/chromedriver");

        // Como interagir com o pop-up
        //B) Interaja com o pop up do navegador dando permissão ao acesso a localização
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Integer> conentSettings = new HashMap<String, Integer>();
        HashMap<String, Object> profile = new HashMap<String, Object>();
        HashMap<String, Object> prefs = new HashMap<String, Object>();

        conentSettings.put("location", 1);
        profile.put("managed_default_content_settings", conentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //A) Acessar o site
        driver.get("https://my-location.org/");

        //C) Clicar no menu [state]
        driver.findElement(By.linkText("State")).click();

        //D) Verificar se na seção de "your location" está mostrando o endereço.
        try {
            // Localização dos elementos
            WebElement locationElement = driver.findElement(By.cssSelector("div.subtitle"));
            WebElement addressElement = driver.findElement(By.cssSelector("div#address.datavalue"));

            // Obtém o texto dos elementos
            String location = locationElement.getText();
            String address = addressElement.getText();

            // Endereço esperado
            String enderecoEsperado = "Avenida Antônio Diogo, 307, Vila Re, São Paulo - SP, 03669-040, Brazil";

            // Esperar o elemento para poder o endereço ser atualizado
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Validação do endereço
            if (enderecoEsperado.equals(address)) {
                System.out.println("O endereço retornado é válido.");
            } else {
                System.out.println("O endereço retornado não é válido.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
