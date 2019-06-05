import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
/**
 * @author mateus.spagnol
 */
public class testTrabalho {
    static WebDriver driver = null;
    private static String namePaginaPrincipal;
    private static String caminhoPagina = "C:\\Users\\mateus.spagnol\\Documents\\Mateus-trabalho-ts-git\\Trabalho-Teste_Software\\JavaApplication7\\src\\javaapplication7\\trabalho2-1.html";
    
    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mateus.spagnol\\Documents\\Mateus-trabalho-ts-git\\Trabalho-Teste_Software\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(caminhoPagina);
        namePaginaPrincipal= driver.getWindowHandle();
    }
    
    @Test
    public void validaTituloPagina(){
        String titulo = driver.getTitle();
        Assert.assertEquals(titulo, "Trabalho 2-1");
    }
    
    @Test
    public void validaNomeVazio(){
        driver.get(caminhoPagina);
        WebElement botao = driver.findElement(By.id("botao_somar"));
        botao.click();
        String resultado = driver.findElement(By.id("resultado")).getText();
        Assert.assertEquals(resultado, "Preencha o campo nome");
    }
    
    @Test
    public void validaEnderecoVazio(){
        driver.get(caminhoPagina);
        WebElement botao = driver.findElement(By.id("botao_somar"));
        WebElement valorNome = driver.findElement(By.id("nome"));
        valorNome.sendKeys("Mateus");
        botao.click();
        String resultado = driver.findElement(By.id("resultado")).getText();
        Assert.assertEquals(resultado, "Preencha o campo endereco");
    }
    
    @Test
    public void validaSexoInvalido(){
        driver.get(caminhoPagina);
        WebElement botao = driver.findElement(By.id("botao_somar"));
        WebElement valorNome = driver.findElement(By.id("nome"));
        WebElement valorEndereco = driver.findElement(By.id("endereco"));
        valorNome.sendKeys("Mateus");
        valorEndereco.sendKeys("Clóvis");
        botao.click();
        String resultado = driver.findElement(By.id("resultado")).getText();
        Assert.assertEquals(resultado, "Selecione um valor para o campo sexo");
    }
    
    @Test
    public void validaIdadeVazia(){
        driver.get(caminhoPagina);
        WebElement botao = driver.findElement(By.id("botao_somar"));
        WebElement valorNome = driver.findElement(By.id("nome"));
        WebElement valorEndereco = driver.findElement(By.id("endereco"));
        WebElement valorSexo = driver.findElement(By.id("sexo"));
        valorNome.sendKeys("Mateus");
        valorEndereco.sendKeys("Clóvis");
        valorSexo.sendKeys("m");
        botao.click();
        String resultado = driver.findElement(By.id("resultado")).getText();
        Assert.assertEquals(resultado, "Preencha o campo idade, somente com numeros");
    }
    
    @Test
    public void validaIdadeInvalida(){
        driver.get(caminhoPagina);
        WebElement botao = driver.findElement(By.id("botao_somar"));
        WebElement valorNome = driver.findElement(By.id("nome"));
        WebElement valorEndereco = driver.findElement(By.id("endereco"));
        WebElement valorSexo = driver.findElement(By.id("sexo"));
        WebElement valorIdade = driver.findElement(By.id("idade"));
        valorNome.sendKeys("Mateus");
        valorEndereco.sendKeys("Clóvis");
        valorSexo.sendKeys("m");
        valorIdade.sendKeys("A");
        botao.click();
        String resultado = driver.findElement(By.id("resultado")).getText();
        Assert.assertEquals(resultado, "Preencha o campo idade, somente com numeros");
    }
    
    @Test
    public void validaSucessoDoCadastro(){
        driver.get(caminhoPagina);
        WebElement botao = driver.findElement(By.id("botao_somar"));
        WebElement valorNome = driver.findElement(By.id("nome"));
        WebElement valorEndereco = driver.findElement(By.id("endereco"));
        WebElement valorSexo = driver.findElement(By.id("sexo"));
        WebElement valorIdade = driver.findElement(By.id("idade"));
        valorNome.sendKeys("Mateus");
        valorEndereco.sendKeys("Clóvis");
        valorSexo.sendKeys("m");
        valorIdade.sendKeys("18");
        botao.click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals(alerta.getText(), "Cadastro realizado com sucesso");
        alerta.accept();
    }
    
    @Test
    public void validaNomeComSucesso(){
        driver.get(caminhoPagina);
        WebElement botao = driver.findElement(By.id("botao_somar"));
        WebElement valorNome = driver.findElement(By.id("nome"));
        valorNome.sendKeys("Fabiano");
        botao.click();
        String resultado = driver.findElement(By.id("resultado")).getText();
        Assert.assertEquals(resultado, "Preencha o campo endereco");
    }
    
    @Test
    public void validaEnderecoComSucesso(){
        driver.get(caminhoPagina);
        WebElement botao = driver.findElement(By.id("botao_somar"));
        WebElement valorNome = driver.findElement(By.id("nome"));
        WebElement valorEndereco = driver.findElement(By.id("endereco"));
        valorNome.sendKeys("Miguel");
        valorEndereco.sendKeys("Gravataí");
        botao.click();
        String resultado = driver.findElement(By.id("resultado")).getText();
        Assert.assertEquals(resultado, "Selecione um valor para o campo sexo");
    }
    
    @Test
    public void validaSexoComSucesso(){
        driver.get(caminhoPagina);
        WebElement botao = driver.findElement(By.id("botao_somar"));
        WebElement valorNome = driver.findElement(By.id("nome"));
        WebElement valorEndereco = driver.findElement(By.id("endereco"));
        WebElement valorSexo = driver.findElement(By.id("sexo"));
        valorNome.sendKeys("Luciano");
        valorEndereco.sendKeys("POA");
        valorSexo.sendKeys("m");
        botao.click();
        String resultado = driver.findElement(By.id("resultado")).getText();
        Assert.assertEquals(resultado, "Preencha o campo idade, somente com numeros");
    }
    
    @Test
    public void validaIdadeComSucesso(){
        driver.get(caminhoPagina);
        WebElement botao = driver.findElement(By.id("botao_somar"));
        WebElement valorNome = driver.findElement(By.id("nome"));
        WebElement valorEndereco = driver.findElement(By.id("endereco"));
        WebElement valorSexo = driver.findElement(By.id("sexo"));
        WebElement valorIdade = driver.findElement(By.id("idade"));
        valorNome.sendKeys("Marcelo");
        valorEndereco.sendKeys("Florianopolis");
        valorSexo.sendKeys("m");
        valorIdade.sendKeys("20");
        botao.click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals(alerta.getText(), "Cadastro realizado com sucesso");
        alerta.accept();
    }
    
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}