package ru.scooter.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.scooter.pages.HomePageScooter;
import ru.scooter.pages.OrderAScooter;

import static ru.scooter.pages.HomePageScooter.HOME_PAGE_SCOOTER_URL;

@RunWith(Parameterized.class)
public class OrderAScooterTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentalPeriod;

    @Before
    public void startUp() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get(HOME_PAGE_SCOOTER_URL);
    }

    public OrderAScooterTest(String name, String surname, String address, String metroStation, String phoneNumber, String deliveryDate, String rentalPeriod) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
    }

    @Parameterized.Parameters(name = "Тестовые данные для заполнения полей формы заказа: {0}; {1}; {2}; {3}; {4}; {5}; {6}")
    public static Object[][] getScooterRentDetails() {
        return new Object[][]{
                {"Анна", "Ли", "Суворова, 12", "Чистые пруды", "89333333333", "12.12.2025", "трое суток"},
                {"Мартин", "Норрис", "Кирова, 32", "Сокольники", "89666555432", "11.09.2025", "пятеро суток"},
        };
    }

    @Test
    public void orderAScooterSuccessfulOrderCreation() {
        // создать объект класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);

        // принять куки
        objHomePage.clickAcceptCookiesButton();

        // нажать на кнопку "Заказать" вверху главной страницы
        objHomePage.clickOrderButtonInHeaderHomePage();

        // подождать открытия формы заказа
        objHomePage.waitForScooterRenterDetailsWindow();

        // создать объект класса создания заказа
        OrderAScooter objOrderAScooter = new OrderAScooter(driver);

        // заполняем форму заказа
        objOrderAScooter.setNameField(name);
        objOrderAScooter.setSurnameField(surname);
        objOrderAScooter.setAddressField(address);
        objOrderAScooter.setMetroStationField(metroStation);
        objOrderAScooter.setPhoneNumberField(phoneNumber);
        objOrderAScooter.clickNextButton();
        objOrderAScooter.waitForAboutRentWindow();
        objOrderAScooter.setDeliveryDateField(deliveryDate);
        objOrderAScooter.setRentalPeriodField(rentalPeriod);
        objOrderAScooter.clickOrderButtonInOrderForm();
        objOrderAScooter.waitForOrderConfirmationWindow();
        objOrderAScooter.clickYesCreateOrderButton();

        // проверяем появление всплывающего окна с сообщением об успешном создании заказа
        objOrderAScooter.isOpenCreatedOrderWindow();
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}