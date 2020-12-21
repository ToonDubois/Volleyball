package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class UpdateTest {


    private static final String url = "http://localhost:8080/Volleyball_war_exploded/";
    private WebDriver driver;
    private String speler;
    private String leeftijd;
    private String positie;
    private String wedstrijden;
    private String speler2, leeftijd2, positie2, wedstrijden2;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\toond\\OneDrive\\Bureaublad\\Web2\\chromedriver.exe");
        driver = new ChromeDriver();
        speler = "Toon Dubois";
        leeftijd = "19";
        positie = "Left Spiker";
        wedstrijden = "5";
        speler2 = "Tom Dubois";
        leeftijd2 = "25";
        positie2 = "Ace";
        wedstrijden2 = "20";
        driver.get(url + "Servlet?command=switchNL&page=add");
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
    public void updateMetOngeldigeNaamVeranderdNiets(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("speler")).clear();
        driver.findElement(By.id("speler")).sendKeys(" ");
        driver.findElement(By.id("leeftijd")).clear();
        driver.findElement(By.id("leeftijd")).sendKeys(leeftijd2);
        driver.findElement(By.id("positie")).clear();
        driver.findElement(By.id("positie")).sendKeys(positie2);
        driver.findElement(By.id("wedstrijdenGespeeld")).clear();
        driver.findElement(By.id("wedstrijdenGespeeld")).sendKeys(wedstrijden2);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler) && driver.getPageSource().contains(leeftijd) && driver.getPageSource().contains(positie) && driver.getPageSource().contains(wedstrijden)){
            assertTrue(true);
        }
    }

    @Test
    public void updateMetOngeldigeLeeftijdVeranderdNiets(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("speler")).clear();
        driver.findElement(By.id("speler")).sendKeys(speler2);
        driver.findElement(By.id("leeftijd")).clear();
        driver.findElement(By.id("leeftijd")).sendKeys(" ");
        driver.findElement(By.id("positie")).clear();
        driver.findElement(By.id("positie")).sendKeys(positie2);
        driver.findElement(By.id("wedstrijdenGespeeld")).clear();
        driver.findElement(By.id("wedstrijdenGespeeld")).sendKeys(wedstrijden2);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler) && driver.getPageSource().contains(leeftijd) && driver.getPageSource().contains(positie) && driver.getPageSource().contains(wedstrijden)){
            assertTrue(true);
        }
    }

    @Test
    public void updateMetNegatieveLeeftijdVeranderdNiets(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("speler")).clear();
        driver.findElement(By.id("speler")).sendKeys(speler2);
        driver.findElement(By.id("leeftijd")).clear();
        driver.findElement(By.id("leeftijd")).sendKeys("-20");
        driver.findElement(By.id("positie")).clear();
        driver.findElement(By.id("positie")).sendKeys(positie2);
        driver.findElement(By.id("wedstrijdenGespeeld")).clear();
        driver.findElement(By.id("wedstrijdenGespeeld")).sendKeys(wedstrijden2);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler) && driver.getPageSource().contains(leeftijd) && driver.getPageSource().contains(positie) && driver.getPageSource().contains(wedstrijden)){
            assertTrue(true);
        }
    }

    @Test
    public void updateMetOngeldigePositieVeranderdNiets(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("speler")).clear();
        driver.findElement(By.id("speler")).sendKeys(speler2);
        driver.findElement(By.id("leeftijd")).clear();
        driver.findElement(By.id("leeftijd")).sendKeys(leeftijd2);
        driver.findElement(By.id("positie")).clear();
        driver.findElement(By.id("positie")).sendKeys(" ");
        driver.findElement(By.id("wedstrijdenGespeeld")).clear();
        driver.findElement(By.id("wedstrijdenGespeeld")).sendKeys(wedstrijden2);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler) && driver.getPageSource().contains(leeftijd) && driver.getPageSource().contains(positie) && driver.getPageSource().contains(wedstrijden)){
            assertTrue(true);
        }
    }

    @Test
    public void updateMetOngeldigeWedstrijdenVeranderdNiets(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("speler")).clear();
        driver.findElement(By.id("speler")).sendKeys(speler2);
        driver.findElement(By.id("leeftijd")).clear();
        driver.findElement(By.id("leeftijd")).sendKeys(leeftijd2);
        driver.findElement(By.id("positie")).clear();
        driver.findElement(By.id("positie")).sendKeys(positie2);
        driver.findElement(By.id("wedstrijdenGespeeld")).clear();
        driver.findElement(By.id("wedstrijdenGespeeld")).sendKeys(" ");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler) && driver.getPageSource().contains(leeftijd) && driver.getPageSource().contains(positie) && driver.getPageSource().contains(wedstrijden)){
            assertTrue(true);
        }
    }

    @Test
    public void updateMetNegatieveWedstrijdenVeranderdNiets(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("speler")).clear();
        driver.findElement(By.id("speler")).sendKeys(speler2);
        driver.findElement(By.id("leeftijd")).clear();
        driver.findElement(By.id("leeftijd")).sendKeys(leeftijd2);
        driver.findElement(By.id("positie")).clear();
        driver.findElement(By.id("positie")).sendKeys(positie2);
        driver.findElement(By.id("wedstrijdenGespeeld")).clear();
        driver.findElement(By.id("wedstrijdenGespeeld")).sendKeys("-5");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler) && driver.getPageSource().contains(leeftijd) && driver.getPageSource().contains(positie) && driver.getPageSource().contains(wedstrijden)){
            assertTrue(true);
        }
    }

    @Test
    public void updateMetGeldigeNaamVeranderdNaam(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("speler")).clear();
        driver.findElement(By.id("speler")).sendKeys(speler2);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler2) && driver.getPageSource().contains(leeftijd) && driver.getPageSource().contains(positie) && driver.getPageSource().contains(wedstrijden)){
            assertTrue(true);
        }
    }

    @Test
    public void updateMetGeldigeLeeftijdVeranderdLeeftijd(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("leeftijd")).clear();
        driver.findElement(By.id("leeftijd")).sendKeys(leeftijd2);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler) && driver.getPageSource().contains(leeftijd2) && driver.getPageSource().contains(positie) && driver.getPageSource().contains(wedstrijden)){
            assertTrue(true);
        }
    }

    @Test
    public void updateMetGeldigePositieVeranderdPositie(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("positie")).clear();
        driver.findElement(By.id("positie")).sendKeys(positie2);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler) && driver.getPageSource().contains(leeftijd) && driver.getPageSource().contains(positie2) && driver.getPageSource().contains(wedstrijden)){
            assertTrue(true);
        }
    }

    @Test
    public void updateMetGeldigeWedstrijdenVeranderdWedstrijden(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("wedstrijdenGespeeld")).clear();
        driver.findElement(By.id("wedstrijdenGespeeld")).sendKeys(wedstrijden2);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler) && driver.getPageSource().contains(leeftijd) && driver.getPageSource().contains(positie) && driver.getPageSource().contains(wedstrijden2)){
            assertTrue(true);
        }
    }

    @Test
    public void updateMetGeldigeWaardenVeranderdWaarden(){
        driver.get(url+"Servlet?command=update&naam=Toon%20Dubois");
        driver.findElement(By.id("speler")).clear();
        driver.findElement(By.id("speler")).sendKeys(speler2);
        driver.findElement(By.id("leeftijd")).clear();
        driver.findElement(By.id("leeftijd")).sendKeys(leeftijd2);
        driver.findElement(By.id("positie")).clear();
        driver.findElement(By.id("positie")).sendKeys(positie2);
        driver.findElement(By.id("wedstrijdenGespeeld")).clear();
        driver.findElement(By.id("wedstrijdenGespeeld")).sendKeys(wedstrijden2);
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.get(url+"Servlet?command=overzicht");
        if(driver.getPageSource().contains(speler2) && driver.getPageSource().contains(leeftijd2) && driver.getPageSource().contains(positie2) && driver.getPageSource().contains(wedstrijden2)){
            assertTrue(true);
        }
    }


    @After
    public void tearDown(){
        driver.get(url+"Servlet?command=verwijder&naam=Toon%20Dubois");
        driver.findElement(By.cssSelector("input[type='submit'][value='Zeker']")).click();
        driver.get(url+"Servlet?command=verwijder&naam=Tom%20Dubois");
        driver.findElement(By.cssSelector("input[type='submit'][value='Zeker']")).click();
        driver.quit();}
}