package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private By cookieBtn = By.className("App_CookieButton__3cvqF"); // локатор для куки
    private By scrollToPanel = By.className("accordion"); // локатор для скрола до панели FAQ

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void openPage() {
        driver.get(URL);
    }

    public void scrollPage() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(scrollToPanel));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickCookie() {
        wait.until(ExpectedConditions.elementToBeClickable(cookieBtn)).click();
    }

    public void clickQuestion(int index) {
        By questionLocator = By.id(String.format("accordion__heading-%d", index));
        wait.until(ExpectedConditions.elementToBeClickable(questionLocator)).click();
    }

    public String getQuestionText(int index) {
        By questionTextLocator = By.id(String.format("accordion__heading-%d", index));
        WebElement questionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTextLocator));
        return questionElement.getText();
    }

    public String getAnswerText(int index) {
        By answerTextLocator = By.id(String.format("accordion__panel-%d", index));
        WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTextLocator));
        return answerElement.getText();

    }
}
