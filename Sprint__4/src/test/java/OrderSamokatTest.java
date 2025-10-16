import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class OrderSamokatTest extends BestTests {

    private String orderButton;
    private String name;
    private String surname;
    private String street;
    private String metroStation;
    private String phoneNumber;

    public OrderSamokatTest(String orderButton, String name, String surname, String street, String metroStation, String phoneNumber) {

        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.street = street;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;

    }

    @Parameterized.Parameters(name = "Test with index {0}")
    public static Collection<Object[]> getDataForTest() {
        return Arrays.asList(new Object[][]{
                {"button-order-top", "Александр", "Хрупин", "улица Ленина", "Лубянка", "89996665544"},
                {"button-order-bottom", "Иван", "Иванов", "улица Мира", "Сокол", "89998887766"},
        });
    }


    @Test

    public void OrderPageTest() {


        orderPage.openPage();
        orderPage.clickButton(orderButton);
        orderPage.fillNameField(name);
        orderPage.fillSurnameField(surname);
        orderPage.fillStreetField(street);
        orderPage.chooseMetroStation(metroStation);
        orderPage.fillPhoneNumberField(phoneNumber);
        orderPage.nextOrderPageButton();

        orderPage.dataOder("15.10.2025");
        orderPage.rentalPeriod("сутки");
        orderPage.chooseСolor();
        orderPage.commentForCourier("Привет, друг!");
        orderPage.buttonOrder();
        orderPage.yesButtonOrder();

        Assert.assertTrue("Сообщение об успешном заказе отсутствует", orderPage.getOrderHasBeenPlaced().contains("Заказ оформлен"));

    }

}