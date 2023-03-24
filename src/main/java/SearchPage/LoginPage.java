package SearchPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;

    }
    By bmLogin = By.xpath("//button[text()='Bank Manager Login']");
    By addcus = By.xpath("//button[@ng-class='btnClass1']");
    By fName = By.xpath("//input[@placeholder='First Name']");
    By lName = By.xpath("//input[@placeholder='Last Name']");
    By pCode = By.xpath("//input[@placeholder='Post Code']");
    By button = By.xpath("//button[text()='Add Customer']");
    

    public void addCustomers(String firstName, String lastName, String postCode){
        driver.findElement(bmLogin).click();
        driver.findElement(addcus).click();
        driver.findElement(fName).click();
        driver.findElement(fName).sendKeys(firstName);
        driver.findElement(lName).click();
        driver.findElement(lName).sendKeys(lastName);
        driver.findElement(pCode).click();
        driver.findElement(pCode).sendKeys(postCode);

    }
    public void clickButton(){
        driver.findElement(button).click();

    }
    public void popUp(){
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        System.out.println("Confirmation message: "+msg);
        alert.accept();



    }
}