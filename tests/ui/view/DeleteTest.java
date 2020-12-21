package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class DeleteTest {


    private static final String url = "http://localhost:8080/Volleyball_war_exploded/";
    private WebDriver driver;
    private String speler;
    private String leeftijd;
    private String positie;
    private String wedstrijden;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\toond\\OneDrive\\Bureaublad\\Web2\\chromedriver.exe");
        driver = new ChromeDriver();
        speler = "Toon Dubois";
        leeftijd = "19";
        positie = "Left Spiker";
        wedstrijden = "5";
        driver.get(url+"Servlet?command=switchNL&page=add");
        driver.findElement(By.id("speler")).clear();
        driver.findElement(By.id("speler")).sendKeys(speler);
        driver.findElement(By.id("leeftijd")).clear();
        driver.findElement(By.id("leeftijd")).sendKeys(leeftijd);
        driver.findElement(By.id("positie")).clear();
        driver.findElement(By.id("positie")).sendKeys(positie);
        driver.findElement(By.id("wedstrijdenGespeeld")).clear();
        driver.findElement(By.id("wedstrijdenGespeeld")).sendKeys(wedstrijden);
        driver.findElement(By.cssSelector("input[type='submit']")).click();


    }


    @Test
    public void verwijderTochNietVerwijdertNiet(){
        driver.get(url+"Servlet?command=verwijder&naam=Toon%20Dubois");
        driver.findElement(By.cssSelector("input[type='submit'][value='Toch niet']")).click();
        assertTrue(driver.getPageSource().contains("Toon Dubois"));
    }

    @Test
    public void verwijderWelVerwijdertWel(){
        driver.get(url+"Servlet?command=verwijder&naam=Toon%20Dubois");
        driver.findElement(By.cssSelector("input[type='submit'][value='Zeker']")).click();
        assertFalse(driver.getPageSource().contains("Toon Dubois"));
    }

    @After
    public void tearDown(){driver.quit();}

}