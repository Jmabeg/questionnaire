package selenium;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Apptest {
 
    @Test
    public void ConnectToWeb()
    {
        System.setProperty("webdriver.edge.driver","C:\\Users\\Juan.Adones\\OneDrive - Solera Holdings, Inc\\Documents\\Selenium_JAVA\\Driver Edge\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.get("http://localhost:8080/");
        WebElement question = driver.findElement(By.id("question")) ;
        assertEquals("options",  question.getAttribute("value"));

    }

    @Test
    public void CanWriteQuestion()
    {
        WebDriver driver = new EdgeDriver();
        
        driver.get("http://localhost:8080/");
        WebElement question = driver.findElement(By.id("question")) ;

        question.sendKeys("I can fly?");
        assertEquals("I can fly?", question.getText());

        question.sendKeys(".'ewfWQWD_;:!13350247||ºº?¿'¡");
        assertEquals(".'ewfWQWD_;:!13350247||ºº?¿'¡", question.getText());

        question.sendKeys("djoiawdoiahdaowidhawoidhawodkahwdoaikhdawdhia");
        assertEquals("djoiawdoiahdaowidhawoidhawodkahwdoaikhdawdhia", question.getText());

        question.sendKeys("的的是的的");
        assertEquals("的的是的的", question.getText());

    }

    @Test
    public void CanSelectCategory()
    {
        WebDriver driver = new EdgeDriver();
        driver.get("http://localhost:8080/");

        Select category = new Select(driver.findElement(By.id("Categ"))) ;

        category.selectByIndex(2); 
        assertEquals(2, category.getFirstSelectedOption());

        category.selectByIndex(1); 
        assertEquals(1, category.getFirstSelectedOption());

        category.selectByIndex(0);  
        assertEquals(0, category.getFirstSelectedOption());  

    }

    @Test
    public void CanWriteawnsers()
    {
        WebDriver driver = new EdgeDriver();
        driver.get("http://localhost:8080/");

        Select category = new Select(driver.findElement(By.id("Categ"))) ;
        category.selectByIndex(2); 


        WebElement answer = driver.findElement(By.id("answers")) ;    
        answer.sendKeys("A,B,C,D,E");
        assertEquals("A,B,C,D,E", answer.getText());

    }

    
    @Test
    public void CanCreateQuestionCategory2() throws Exception
    {
        WebDriver driver = new EdgeDriver();
        driver.get("http://localhost:8080/");


        WebElement answer = driver.findElement(By.id("answers")) ;    
        answer.sendKeys("A,B,C,D,E");
        assertEquals("A,B,C,D,E", answer.getText());

        try
        {
            WebElement badanswer1 = driver.findElement(By.id("answers")) ;    
            badanswer1.sendKeys("A,B,C,D,E");
            WebElement submit = (driver.findElement(By.id("submit"))) ;
            submit.click();
        }
        catch(Exception e)
        {
            assertEquals("Error: You have to actually write a question", e.getMessage());
        }

        try
        {
            WebElement badanswer2 = driver.findElement(By.id("answers")) ;    
            badanswer2.sendKeys("A,B,C,D,E");
            WebElement question = driver.findElement(By.id("question")) ;
            question.sendKeys("I can fly?");
   
            WebElement submit = (driver.findElement(By.id("submit"))) ;
            submit.click();
        }
        catch(Exception e)
        {
            assertEquals("Error: Category not valid for customized questions , select the right category ", e.getMessage());
        }

        try
        {
            WebElement badanswer3 = driver.findElement(By.id("answers")) ;    
            badanswer3.sendKeys("ABCDE");
            WebElement submit = (driver.findElement(By.id("submit"))) ;
            submit.click();
        }
        catch(Exception e)
        {
            assertEquals("Error: Anwsers have to be separated by ','", e.getMessage());
        }

        try
        {
            WebElement badanswer4 = driver.findElement(By.id("answers")) ;    
            badanswer4.sendKeys(",,,,");
            WebElement submit = (driver.findElement(By.id("submit"))) ;
            submit.click();
        }
        catch(Exception e)
        {
            assertEquals("Error: It's obligatory to have at least 2 answers", e.getMessage());
        }

        try
        {
            WebElement badanswer5 = driver.findElement(By.id("answers")) ;    
            badanswer5.sendKeys("");
            WebElement submit = (driver.findElement(By.id("submit"))) ;
            submit.click();
        }
        catch(Exception e)
        {
            assertEquals("Error: It's obligatory to have at least 2 answers", e.getMessage());
        }

            Select category = new Select(driver.findElement(By.id("Categ"))) ;
            category.selectByIndex(2); 
            WebElement rightanswer = driver.findElement(By.id("answers")) ;    
            rightanswer.sendKeys("A,B,C,D,E");
            WebElement question = driver.findElement(By.id("question")) ;
            question.sendKeys("I can fly?");
            WebElement submit = (driver.findElement(By.id("submit"))) ;
                submit.click();
            WebElement gotoquiz = (driver.findElement(By.id("startquiz"))) ;
                gotoquiz.click();

            WebElement anwser1 = (driver.findElement(By.id("cbox1"))) ;
            assertEquals("A", anwser1.getText());
    }

    @Test
    public void CanCreateQuestionCategory0() throws Exception
    {
        WebDriver driver = new EdgeDriver();
        driver.get("http://localhost:8080/");

        try
        {
            WebElement submit = (driver.findElement(By.id("submit"))) ;
            submit.click();
        }
        catch(Exception e)
        {
            assertEquals("Error: You have to actually write a question", e.getMessage());
        }

        WebElement question = driver.findElement(By.id("question")) ;    
        question.sendKeys("Are you ready?");

        WebElement submit = (driver.findElement(By.id("submit"))) ;
        submit.click();

        WebElement gotoquiz = (driver.findElement(By.id("startquiz"))) ;
        gotoquiz.click();
        
        WebElement anwser1 = (driver.findElement(By.id("cbox1"))) ;
        assertEquals("Yes", anwser1.getText());
     
        
    }

    @Test
    public void CanCreateQuestionCategory1() throws Exception
    {
        WebDriver driver = new EdgeDriver();
        driver.get("http://localhost:8080/");

        try
        {
            WebElement submit = (driver.findElement(By.id("submit")));
            submit.click();
        }
        catch(Exception e)
        {
            assertEquals("Error: You have to actually write a question", e.getMessage());
        }

        WebElement question = driver.findElement(By.id("question")) ;    
        question.sendKeys("Are you ready?");

        WebElement submit = (driver.findElement(By.id("submit"))) ;
        submit.click();

        Select category = new Select(driver.findElement(By.id("Categ"))) ;
        category.selectByIndex(1); 

        WebElement gotoquiz = (driver.findElement(By.id("startquiz"))) ;
        gotoquiz.click();
        
        WebElement anwser1 = (driver.findElement(By.id("cbox1"))) ;
        assertEquals("Yes", anwser1.getText());
     
        
    }
} 
