package ru.scooter.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.scooter.pages.HomePageScooter;

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

    @Parameterized.Parameters
    public static Object[][] getScooterRentDetails() {
        return new Object[][]{
                {"Анна", "Ли", "Суворова, 12", "Чистые пруды", "89333333333", "12.12.2025", "трое суток"},
                {"Мартин", "Норрис", "Кирова, 32", "Сокольники", "89666555432", "11.09.2025", "пятеро суток"},
        };
    }

    @Test
    public void orderAScooterSuccessfulOrderCreation() {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создать объект класса домашней страницы
        HomePageScooter objOrderAScooter = new HomePageScooter(driver);

        // принять куки
        objOrderAScooter.clickAcceptCookiesButton();

        // нажать на кнопку "Заказать" вверху главной страницы
        objOrderAScooter.clickOrderButtonInHeaderHomePage();

        // подождать открытия формы заказа
        objOrderAScooter.waitForScooterRenterDetailsWindow();

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

        // ждём появления всплывающего окна с сообщением об успешном создании заказа
        objOrderAScooter.waitForCreatedOrderWindow();
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}