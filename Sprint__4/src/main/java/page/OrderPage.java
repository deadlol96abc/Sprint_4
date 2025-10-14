package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    private By orderButtons = By.xpath("//button[contains(text(), 'Заказать')]");
    private By nameLocator = By.cssSelector("input[placeholder='* Имя']");
    private By surnameLocator = By.cssSelector("input[placeholder='* Фамилия']");
    private By streetLocator = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private By metroStationLocator = By.className("select-search__input");
    private By metroSelectInput = By.xpath(".//input[@class='select-search__input']");
    private By metroSearchSelect = By.xpath(".//div[@class='select-search__select']");
    private By phoneNumberLocator = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private By buttonNext = By.className("Button_Middle__1CSJM");
    private By dataField = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    private By rentalPeriodLocator = By.className("Dropdown-arrow");
    private String rentPeriodChoose = ".//div[text()='%s']";
    ;
    private By colorButton = By.id("black");
    private By commentForCourierLocator = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private By buttonOrderLocator = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    private By yesButton = By.xpath("//button[text() = 'Да']");
    private By orderHasBeenPlacedText = By.className("Order_ModalHeader__3FDaJ");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openPage() {
        driver.get(URL);
    }

    public void clickButton(String buttons) {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtons)).click();
    }

    public void fillNameField(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameLocator)).sendKeys(name);
    }

    public void fillSurnameField(String surname) {
        driver.findElement(surnameLocator).sendKeys(surname);
    }

    public void fillStreetField(String street) {
        driver.findElement(streetLocator).sendKeys(street);
    }

    public void chooseMetroStation(String metroStation) {
        driver.findElement(metroStationLocator).click();
        driver.findElement(metroSelectInput).sendKeys(metroStation);
        wait.until(ExpectedConditions.elementToBeClickable(metroSearchSelect)).click();

    }

    public void fillPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberLocator).sendKeys(phoneNumber);
    }

    public void nextOrderPageButton() {
        driver.findElement(buttonNext).click();
    }

    public void dataOder(String data) {
        wait.until(ExpectedConditions.elementToBeClickable(dataField)).sendKeys(data);

    }

    public void rentalPeriod(String rentTime) {
        driver.findElement(rentalPeriodLocator).click();
        driver.findElement(By.xpath(String.format(rentPeriodChoose, rentTime))).click();
    }

    public void ChooseСolor() {
        driver.findElement(colorButton).click();

    }

    public void commentForCourier(String comment) {
        driver.findElement(commentForCourierLocator).sendKeys(comment);

    }

    public void buttonOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonOrderLocator)).click();

    }

    public void yesButtonOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }

    public String getOrderHasBeenPlaced() {
        WebElement orderHasBeenPlaced = wait.until(ExpectedConditions.visibilityOfElementLocated(orderHasBeenPlacedText));
        String orderText = orderHasBeenPlaced.getText();
        return orderText;
    }

}
