package com.simpleL.mproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExpediaDemo {
	WebDriver driver;
    String baseURL = "https://www.expedia.com.au/";
    
    //private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(ExpediaDemo.class.getName());

    
    @BeforeMethod
    public void setUp() throws Exception {
    	//log.setLevel(Level.WARN);
    /*	log.trace("Trace Message Logged");
    	log.debug("Debug Message Logged");
    	log.info("Info Message Logged");
    	log.warn("Warn Message Logged");
    	log.error("Error Message Logged");	
    	log.fatal("Fatal Message Logged");*/
    	System.out.println("tedt before method");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws Exception {
    //	log.info("Execute after method");
       driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
     System.out.println("test1");
        driver.get(baseURL);
        WebElement goButton = driver.findElement(By.xpath("//button[@aria-label='Going to']"));
        goButton.click();
        
      //  log.info("This message is about go to button");

        WebElement destination= driver.findElement(By.xpath("//input[@id='location-field-destination']"));
        destination.click();
        destination.sendKeys("Sydney");
        destination.sendKeys(Keys.RETURN);

       // log.debug("This message is about send destination");
        
        WebElement checkinBtn = driver.findElement(By.xpath("//button[@id='d1-btn']"));
        checkinBtn.click();

        WebElement table = driver.findElement(By.xpath("//div[@class='uitk-date-picker-month'][position()=1]/table"));

        List<WebElement> tds = table.findElements(By.tagName("button"));

        System.out.println("list length" + tds.size());
        for(WebElement td : tds)
        {
            System.out.println("td.getAttribute(\"data-day\")" + td.getAttribute("data-day"));
            if(td.getAttribute("data-day").equals("26"))
            {
                td.click();
            }

            if(td.getAttribute("data-day").equals("28"))
            {
                td.click();
                break;
            }

        }
      //  log.debug("This message is about getting all the date in the calendar");
        
       /* WebElement checkInDate = driver.findElement(By.xpath("//table[@class='uitk-date-picker-weeks']//button[@aria-label='4 Apr. 2022']"));

        checkInDate.click();

        WebElement checkoutDate = driver.findElement(By.xpath("//table[@class='uitk-date-picker-weeks']//button[@aria-label='12 Apr. 2022']"));
        checkoutDate.click();*/

        WebElement doneBtn = driver.findElement(By.xpath("//button[text()='Done']"));
        doneBtn.click();

        WebElement traveller = driver.findElement(By.xpath("//button[@data-testid='travelers-field-trigger']"));
        traveller.click();

       // WebElement adults = driver.findElement(By.xpath("[aria-labelledby='uitk-step-increment-adults-930-title']"));
       // adults.click();

        //WebElement children = driver.findElement(By.xpath("[aria-labelledby='uitk-step-increment-children-340-title']"));
       // children.click();

     /*   WebElement childAge = driver.findElement(By.xpath("//select[@id='child-age-input-0-0']"));
        Select s = new Select(childAge);
        s.selectByValue("9");

      */  
        
        WebElement done = driver.findElement(By.xpath("//button[@data-testid='guests-done-button']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(done));
        
       
        done.click();
        
        Thread.sleep(3000);
        
        /*    WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        searchBtn.click();

       WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        searchBtn.click();
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd mm yy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        Thread.sleep(3000);*/
            }



}

