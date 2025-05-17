package ru.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class OrderAScooter {
    private WebDriver driver;

    // поле имени
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");

    // поле фамилии
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле адреса
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле станции метро
    private By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");

    // статическая часть локатора для выбора metroStation и RentalPeriod
    private String metroStationAndRentalPeriodXpathTemplate = ".//div[contains(text(), '%s')]";

    // поле телефона
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // кнопка "Далее" в форме заказа
    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    // окно "Про аренду" формы заказа
    private By aboutRentWindow = By.xpath(".//div[text()='Про аренду']");

    // поле даты доставки самоката
    private By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");;

    // поле срока аренды самоката
    private By rentalPeriodField  = By.xpath(".//div[@class='Dropdown-placeholder']");

    // кнопка "Заказать" в форме заказа
    private By orderButtonInOrderForm = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // всплывающее окно подтверждения заказа
    private By orderConfirmationWindow = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");

    // кнопка "Да" подтверждения заказа
    private By yesCreateOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    // всплывающее окно с сообщением об успешном создании заказа
    private By createdOrderWindow = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    // конструктор класса
    public OrderAScooter(WebDriver driver) {
        this.driver = driver;
    }

    // метод заполнения поля имени
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // метод заполнения поля фамилии
    public void setSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    // метод заполнения поля адреса
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // метод для получения полного локатора metroStation
    public By getMetroStationLocator(String metroStation) {
        return By.xpath(String.format(metroStationAndRentalPeriodXpathTemplate, metroStation));
    }

    // метод заполнения поля станции метро
    public void setMetroStationField(String metroStation) {
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationField).sendKeys(metroStation);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(getMetroStationLocator(metroStation)));
        driver.findElement(getMetroStationLocator(metroStation)).click();
    }

    // метод заполнения поля телефона
    public void setPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    // метод для нажатия на кнопку "Далее" в форме заказа
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // метод ожидания открытия части "Про аренду" формы заказа:
    public void waitForAboutRentWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(aboutRentWindow));
        assertEquals(true, driver.findElement(aboutRentWindow).isDisplayed());
    }

    // метод заполнения поля даты доставки самоката
    public void setDeliveryDateField(String deliveryDate) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
    }

    // метод для получения полного локатора RentalPeriod
    public By getRentalPeriodLocator(String rentalPeriod) {
        return By.xpath(String.format(metroStationAndRentalPeriodXpathTemplate, rentalPeriod));
    }

    // метод заполнения поля срока аренды самоката
    public void setRentalPeriodField(String rentalPeriod) {
        driver.findElement(aboutRentWindow).click();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(getRentalPeriodLocator(rentalPeriod)).click();
    }

    // метод для нажатия на кнопку "Заказать" в форме заказа
    public void clickOrderButtonInOrderForm() {
        driver.findElement(orderButtonInOrderForm).click();
    }

    // метод ожидания всплывающего окна подтверждения заказа
    public void waitForOrderConfirmationWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(orderConfirmationWindow));
        assertEquals(true, driver.findElement(orderConfirmationWindow).isDisplayed());
    }

    // метод для нажатия на кнопку "Да" подтверждения заказа
    public void clickYesCreateOrderButton() {
        driver.findElement(yesCreateOrderButton).click();
    }

    // метод проверки появления всплывающего окна с сообщением об успешном создании заказа
    public void isOpenCreatedOrderWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(createdOrderWindow));
        assertEquals(true, driver.findElement(createdOrderWindow).isDisplayed());
    }
}