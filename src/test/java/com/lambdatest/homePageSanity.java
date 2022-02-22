package com.lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class homePageSanity {

    public RemoteWebDriver driver;
    public String username = "amitwalia";
    public String accesskey = "KaDA5M7mmYJfhCdF35ApK1dNnHI3Tc8mLkUJyYlKWbIOW8doKm";
    public String gridURL = "@hub.lambdatest.com/wd/hub";

    @org.testng.annotations.Parameters(value = {"browser", "version", "platform"})

    @BeforeMethod
    public void setUp(String browser, String version, String platform) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "AmitAssignmentBuild1.1");
        capabilities.setCapability("name", "1.1");
        capabilities.setCapability("platform", platform);
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version", version);

        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void enterInfoFields () throws InterruptedException {
        driver.get("https://www.globalsqa.com/samplepagetest");
        driver.findElement(By.id("g2599-name")).sendKeys("John Doe");
        driver.findElement(By.id("g2599-email")).sendKeys("john@abc.com");
        driver.findElement(By.id("g2599-website")).sendKeys("https://www.globalsqa.com/samplepagetest");
        driver.findElement(By.id("contact-form-comment-g2599-comment")).sendKeys("Test Comment1");
        Thread.sleep(200);
        driver.quit();
    }

    @Test
    public void selectExperience () throws InterruptedException {
        driver.get("https://www.globalsqa.com/samplepagetest");
        WebElement staticDropdown = driver.findElement(By.id("g2599-experienceinyears"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        Thread.sleep(200);
        driver.quit();
    }

    @Test
    public void selectExpertise() throws InterruptedException {

        driver.get("https://www.globalsqa.com/samplepagetest");
        driver.findElement(By.xpath("//input[@name='g2599-expertise[]'])[2]")).click();
        Thread.sleep(200);
        driver.quit();
    }

    @Test
    public void selectEducation() throws InterruptedException {

        driver.get("https://www.globalsqa.com/samplepagetest");
        driver.findElement(By.xpath("//input[@value='Graduate']")).click();
        Thread.sleep(200);
        driver.quit();
    }

    @Test
    public void clickButton() throws InterruptedException {

        driver.get("https://www.globalsqa.com/samplepagetest");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(200);
        driver.quit();
    }

}
