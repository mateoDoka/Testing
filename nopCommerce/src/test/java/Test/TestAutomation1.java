package Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

public class TestAutomation1 {
@Test
    public void test()throws  InterruptedException{

    System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Module\\src\\main\\resources\\drivers\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    String baseurl="https://demo.nopcommerce.com/";
    Random rand = new Random();
    int int_random = rand.nextInt(25);
    driver.get(baseurl);

    WebElement loginBtn= driver.findElement(By.className("ico-login"));
     loginBtn.click();
    WebElement registerBtn=driver.findElement(By.linkText("Register"));
     registerBtn.click();
       String registerPageTitle=driver.getTitle();
     System.out.println("Page Tittle is : "+ registerPageTitle);

     WebElement radioGender= driver.findElement(By.id("gender-male"));
     radioGender.click();
     WebElement nameInpuField= driver.findElement(By.id("FirstName")) ;
     nameInpuField.sendKeys("Mateo"+int_random);
    WebElement lastNameInpuField= driver.findElement(By.id("LastName")) ;
    lastNameInpuField.sendKeys("Doka"+int_random);
  Select  daySelector=new Select(driver.findElement(By.name("DateOfBirthDay")));
  daySelector.selectByIndex(4);
  Select monthSelector= new Select(driver.findElement(By.name("DateOfBirthMonth")));
  monthSelector.selectByVisibleText("March");
  Select yearSelector= new Select(driver.findElement(By.name("DateOfBirthYear")));
  yearSelector.selectByValue("2002");

  WebElement emailTextInput= driver.findElement(By.id("Email"));
  emailTextInput.sendKeys("mateodoka"+int_random+"@gmail.com");
  String emailInput=emailTextInput.getAttribute("value");

  WebElement companyTextInput = driver.findElement(By.id("Company"));
  companyTextInput.sendKeys("Universiteti Polis");

    WebElement newsLetter= driver.findElement(By.name("Newsletter"));
     newsLetter.click();

      WebElement passwordTextInput= driver.findElement(By.id("Password"));
      passwordTextInput.sendKeys("mateoPass");
      String passInput= passwordTextInput.getAttribute("value");
      WebElement passwordVerifyInput= driver.findElement(By.id("ConfirmPassword"));
      passwordVerifyInput.sendKeys("mateoPass");
        WebElement submitBtn= driver.findElement(By.id("register-button"));
        Thread.sleep(5000);
       submitBtn.click();
       Thread.sleep(5000);
    WebElement loginAfterReg=driver.findElement(By.linkText("Log in"));
    loginAfterReg.click();
        WebElement login1= driver.findElement(By.linkText("Log in"));
    WebElement emailTextInput1= driver.findElement(By.id("Email"));
    emailTextInput1.sendKeys( emailInput);
    WebElement passwordTextInput1= driver.findElement(By.id("Password"));
    passwordTextInput1.sendKeys(passInput);
    Thread.sleep(5000);
        login1.click();
    Thread.sleep(5000);

       driver.close();
}
}
