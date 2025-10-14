import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;
import page.OrderPage;

public class BestTests {

    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;

    @Before

    public void startUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @After

    public void treeDown() {

        driver.quit();

    }

}
