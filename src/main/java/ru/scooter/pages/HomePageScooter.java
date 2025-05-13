package ru.scooter.pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;

public class HomePageScooter {
    private WebDriver driver;

    // список вопросов в разделе «Вопросы о важном»
    private By questionAboutPrice = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    private By questionAboutRentingSeveralScooters = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    private By questionAboutRentalTime = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    private By questionAboutOrderingForToday = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    private By questionAboutChangingLeaseTerm = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    private By questionAboutCharger = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    private By questionAboutOrderCancellation = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    private By questionAboutDeliveryOutsideMKAD = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");

    // список ответов в разделе «Вопросы о важном»
    private By answerAboutPrice = By.id("accordion__panel-0");
    private By answerAboutRentingSeveralScooters = By.id("accordion__panel-1");
    private By answerAboutRentalTime = By.id("accordion__panel-2");
    private By answerAboutOrderingForToday = By.id("accordion__panel-3");
    private By answerAboutChangingLeaseTerm = By.id("accordion__panel-4");
    private By answerAboutCharger = By.id("accordion__panel-5");
    private By answerAboutOrderCancellation = By.id("accordion__panel-6");
    private By answerAboutDeliveryOutsideMKAD = By.id("accordion__panel-7");

    // кнопка принятия кук
    private By acceptCookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    // кнопка "Заказать" вверху главной страницы
    private By orderButtonInHeaderHomePage = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    // кнопка "Заказать" внизу главной страницы
    private By orderButtonFinishHomePage = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    // окно "Для кого самокат" формы заказа
    private By scooterRenterDetailsWindow = By.xpath(".//div[text()='Для кого самокат']");

    // поле имени
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");

    // поле фамилии
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле адреса
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле станции метро
    private By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");

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
    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // метод для нажатия на кнопку принятия кук
    public void clickAcceptCookiesButton() {
        driver.findElement(acceptCookiesButton).click();
    }

    // методы раскрытия вопросов
    public void clickQuestionAboutPrice() {
        driver.findElement(questionAboutPrice).click();
    }
    public void clickQuestionAboutRentingSeveralScooters() {
        driver.findElement(questionAboutRentingSeveralScooters).click();
    }
    public void clickQuestionAboutRentalTime() {
        driver.findElement(questionAboutRentalTime).click();
    }
    public void clickQuestionAboutOrderingForToday() {
        driver.findElement(questionAboutOrderingForToday).click();
    }
    public void clickQuestionAboutChangingLeaseTerm() {
        driver.findElement(questionAboutChangingLeaseTerm).click();
    }
    public void clickQuestionAboutCharger() {
        driver.findElement(questionAboutCharger).click();
    }
    public void clickQuestionAboutOrderCancellation() {
        driver.findElement(questionAboutOrderCancellation).click();
    }
    public void clickQuestionAboutDeliveryOutsideMKAD() {
        driver.findElement(questionAboutDeliveryOutsideMKAD).click();
    }

    // методы возврата текста ответов
    public String getAnswerAboutPrice() {
        return driver.findElement(answerAboutPrice).getText();
    }
    public String getAnswerAboutRentingSeveralScooters() {
        return driver.findElement(answerAboutRentingSeveralScooters).getText();
    }
    public String getAnswerAboutRentalTime() {
        return driver.findElement(answerAboutRentalTime).getText();
    }
    public String getAnswerAboutOrderingForToday() {
        return driver.findElement(answerAboutOrderingForToday).getText();
    }
    public String getAnswerAboutChangingLeaseTerm() {
        return driver.findElement(answerAboutChangingLeaseTerm).getText();
    }
    public String getAnswerAboutCharger() {
        return driver.findElement(answerAboutCharger).getText();
    }
    public String getAnswerAboutOrderCancellation() {
        return driver.findElement(answerAboutOrderCancellation).getText();
    }
    public String getAnswerAboutDeliveryOutsideMKAD() {
        return driver.findElement(answerAboutDeliveryOutsideMKAD).getText();
    }

    // метод проверки текста ответа
    public void isCorrectText(String answer, String text) {
        MatcherAssert.assertThat(answer, is(text));
    }

    // метод для нажатия на кнопку "Заказать" вверху главной страницы
    public void clickOrderButtonInHeaderHomePage() {
        driver.findElement(orderButtonInHeaderHomePage).click();
    }

    // метод для нажатия на кнопку "Заказать" внизу главной страницы
    public void clickOrderButtonFinishHomePage() {
        driver.findElement(orderButtonFinishHomePage).click();
    }

    // метод ожидания открытия части "Для кого самокат" формы заказа
    public void waitForScooterRenterDetailsWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(scooterRenterDetailsWindow));
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

    // метод заполнения поля станции метро
    public void setMetroStationField(String metroStation) {
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationField).sendKeys(metroStation);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(".//div[contains(text(), '" + metroStation + "')]")));
        driver.findElement(By.xpath(".//div[contains(text(), '" + metroStation + "')]")).click();
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
    }

    // метод заполнения поля даты доставки самоката
    public void setDeliveryDateField(String deliveryDate) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
    }

    // метод заполнения поля срока аренды самоката
    public void setRentalPeriodField(String rentalPeriod) {
        driver.findElement(aboutRentWindow).click();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(".//div[contains(text(), '" + rentalPeriod + "')]")).click();
    }

    // метод для нажатия на кнопку "Заказать" в форме заказа
    public void clickOrderButtonInOrderForm() {
        driver.findElement(orderButtonInOrderForm).click();
    }

    // метод ожидания всплывающего окна подтверждения заказа
    public void waitForOrderConfirmationWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(orderConfirmationWindow));
    }

    // метод для нажатия на кнопку "Да" подтверждения заказа
    public void clickYesCreateOrderButton() {
        driver.findElement(yesCreateOrderButton).click();
    }

    // метод ожидания всплывающего окна с сообщением об успешном создании заказа
    public void waitForCreatedOrderWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(createdOrderWindow));
    }
}