package ui.view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class voegToeTest {

    private static final String url = "http://localhost:8080/Volleyball_war_exploded/voegtoe.jsp";
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
    }

    private void fillOutForm(String speler, String leeftijd, String positie, String wedstrijden) {
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
    public void test_voegToe_met_lege_naam_geeft_formulier(){
        driver.get(url);
        fillOutForm("", leeftijd, positie, wedstrijden);
        assertEquals("Voeg Toe",driver.getTitle());
    }

    @Test
    public void test_voegToe_met_lege_leeftijd_geeft_formulier(){
        driver.get(url);
        fillOutForm(speler,"",positie,wedstrijden);
        assertEquals("Voeg Toe",driver.getTitle());
    }

    @Test
    public void test_voegToe_met_lege_positie_geeft_formulier(){
        driver.get(url);
        fillOutForm(speler,leeftijd,"",wedstrijden);
        assertEquals("Voeg Toe",driver.getTitle());
    }

    @Test
    public void test_voegToe_met_lege_wedstrijden_geeft_formulier(){
        driver.get(url);
        fillOutForm(speler,leeftijd,positie,"");
        assertEquals("Voeg Toe",driver.getTitle());
    }

    @Test
    public void test_voegToe_met_leeftijd_kleiner_gelijk_aan_0_geeft_formulier(){
        driver.get(url);
        fillOutForm(speler,"-5",positie,wedstrijden);
        assertEquals("Voeg Toe",driver.getTitle());
    }

    @Test
    public void test_voegToe_met_wedstrijden_kleiner_gelijk_aan_0_geeft_formulier(){
        driver.get(url);
        fillOutForm(speler,leeftijd,positie,"-8");
        assertEquals("Voeg Toe",driver.getTitle());
    }

    @Test
    public void test_voegToe_met_geldige_waarden_geeft_overzicht(){
        driver.get(url);
        fillOutForm(speler,leeftijd,positie,wedstrijden);
        assertEquals("Overzicht",driver.getTitle());
    }



    @After
    public void tearDown(){driver.quit();}

}
