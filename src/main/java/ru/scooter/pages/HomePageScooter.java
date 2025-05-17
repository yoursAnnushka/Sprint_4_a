package ru.scooter.pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.scooter.pages.constants.Answers;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class HomePageScooter {
    private WebDriver driver;

    // страница тестового приложения
    public static final String HOME_PAGE_SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";

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

    // массив из локаторов вопросов в разделе «Вопросы о важном»
    By[] question = {
            questionAboutPrice,
            questionAboutRentingSeveralScooters,
            questionAboutRentalTime,
            questionAboutOrderingForToday,
            questionAboutChangingLeaseTerm,
            questionAboutCharger,
            questionAboutOrderCancellation,
            questionAboutDeliveryOutsideMKAD
    };

    // массив из локаторов ответов в разделе «Вопросы о важном»
    By[] answer = {
            answerAboutPrice,
            answerAboutRentingSeveralScooters,
            answerAboutRentalTime,
            answerAboutOrderingForToday,
            answerAboutChangingLeaseTerm,
            answerAboutCharger,
            answerAboutOrderCancellation,
            answerAboutDeliveryOutsideMKAD
    };

    // массив констант текстовок ответов для раздела «Вопросы о важном»
    String[] answerText = {
            Answers.QUESTION_ABOUT_PRICE_TEXT,
            Answers.QUESTION_ABOUT_RENTING_SEVERAL_SCOOTERS_TEXT,
            Answers.QUESTION_ABOUT_RENTAL_TIME_TEXT,
            Answers.QUESTION_ABOUT_ORDERING_FOR_TODAY_TEXT,
            Answers.QUESTION_ABOUT_CHANGING_LEASE_TERM_TEXT,
            Answers.QUESTION_ABOUT_CHARGER_TEXT,
            Answers.QUESTION_ABOUT_ORDER_CANCELLATION_TEXT,
            Answers.QUESTION_ABOUT_DELIVERY_OUTSIDE_MKAD_TEXT,
    };

    // кнопка принятия кук
    private By acceptCookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    // кнопка "Заказать" вверху главной страницы
    private By orderButtonInHeaderHomePage = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    // кнопка "Заказать" внизу главной страницы
    private By orderButtonFinishHomePage = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    // окно "Для кого самокат" формы заказа
    private By scooterRenterDetailsWindow = By.xpath(".//div[text()='Для кого самокат']");

    // конструктор класса
    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // метод для нажатия на кнопку принятия кук
    public void clickAcceptCookiesButton() {
        driver.findElement(acceptCookiesButton).click();
    }

    // метод раскрытия вопроса
    public void clickQuestion(int number) {
        driver.findElement(question[number]).click();
    }

    // метод возврата текста ответа
    public String getAnswerText(int number) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answer[number]));
        return driver.findElement(answer[number]).getText();
    }

    // метод проверки текста ответа
    public void isCorrectText(int number) {
        MatcherAssert.assertThat(getAnswerText(number), is(answerText[number]));
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
        assertEquals(true, driver.findElement(scooterRenterDetailsWindow).isDisplayed());
    }
}