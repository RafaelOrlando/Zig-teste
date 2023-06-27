# Zig-teste
Esse é um repositório que contém a automação de alguns testes referentes ao desafio técnico proposto. Desafio de Automação Web desenvolvido utilizando o Selenium (https://www.selenium.dev/) usando como linguagem de desenvolvimento o JAVA. Abaixo, nos sub-tópicos, segue a descrição de ferramentas, instalações, estrutura e contexto dos testes.

### Tecnologias Utilizadas
Essa framework de teste automatizado utiliza :
Java (https://www.oracle.com/java/technologies/javase/18-0-2-relnotes.html),
Selenium Webdriver  (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java),
Junit  (https://mvnrepository.com/artifact/junit/junit), para realizar os testes automatizados.

## Framework de Teste Automatizado
O ChromeDriver disponível nesse projeto é a versão 114.0.5735.133 para Linux.

Isso significa que ele só funcionará em browsers chrome dessa série.

Caso você queira executar esse projeto em uma outra versão de sistema e chromedriver, remova o seguinte comando de configuração dos arquivos.

       System.setProperty("webdriver.chrome.driver", driverPath);

Acesse o site  (https://sites.google.com/a/chromium.org/chromedriver/) baixe e instale o chromedriver localmente no seu sistema.


    Windows
    	C:\users\seuNome
    
    Mac/Linux
    	/usr/local/bin

Assim, o projeto usará o chromedriver instalado localmente, e não o fornecido no projeto.

## Notas Gerais

#### Executando pelo IntelliJ

Após importar esse projeto no IntelliJ, navegue até a pasta src/test/java e abra a classe dos arquivos :
- camera;
- localizacao;
- microfone;
- registro;

Um botão verde (um play) deve aparecer ao lado do nome da classe, basta apertar ele.

Os testes serão executados e os resultados serão exibidos na tela de execução do Intellij.

## Contexto dos Testes

Os testes tem como base desafios de sites diversos, tem como objetivo a automação de testes web dos seguintes cenários :
- Arquivo ( camera ) :
1.  Validar o acesso a câmera
    A )  Acesa o site "[https://pt.webcamtests.com/](https://pt.webcamtests.com/)"
    B ) Clicar em [Clique aqui para permitir o acesso a identificadores de webcam]
    C ) Interaja com o pop up do navegador dando permissão ao acesso a câmera
    D ) Verificar se é exibido a mensagem  **"Uma webcam foi detectada. Pressione “Teste minha cam” para verificar a funcionalidade e as propriedades suportadas de sua câmera."**

- Arquivo ( microfone ) :
2.  Validar o acesso ao microfone
    A )  Acesa o site "[https://mictests.com/](https://mictests.com/)"
    B ) Clicar em [Click here to allow access to microphone identifiers]
    C ) 1.  Interaja com o pop up do navegador dando permissão ao acesso ao microfone
    D ) 1.  Verifique se a mensagem  **"Several microphones were detected. To check the functionality and supported properties of your microphone, select it from the list below and press “Test my mic”. Please note that in order to obtain more accurate results it is recommended to keep enabled only one microphone.**" foi exibida.

- Arquivo ( localizacao ) :
3.  Validar o acesso a localizacao
    A )  Acesa o site "[https://my-location.org/](https://my-location.org/)"
    B ) Interaja com o pop up do navegador dando permissão ao acesso a localização
    C ) Clicar no menu [state]
    D ) Verificar se na seção de "your location" está mostrando o endereço.

- Arquivo ( registro ) :
4.  Validar o acesso a registro
    A )  Acesa o site **[https://demo.automationtesting.in/Register.html](https://demo.automationtesting.in/Register.html)**
    B ) Valide os campos obrigatórios
    C ) Valide o registro com sucesso (informando a foto)







