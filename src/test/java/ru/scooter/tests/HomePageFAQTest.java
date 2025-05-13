package ru.scooter.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.scooter.pages.HomePageScooter;
import ru.scooter.pages.constants.Answers;

public class HomePageFAQTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
    }

    @Test
    public void openFAQShowsCorrectAnswer() {
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // создать объект класса домашней страницы
        HomePageScooter objOpenFAQ = new HomePageScooter(driver);

        // принять куки
        objOpenFAQ.clickAcceptCookiesButton();

        // раскрыть вопрос и проверить текст ответа
        objOpenFAQ.clickQuestionAboutPrice();
        objOpenFAQ.isCorrectText(objOpenFAQ.getAnswerAboutPrice(), Answers.questionAboutPriceText);

        objOpenFAQ.clickQuestionAboutRentingSeveralScooters();
        objOpenFAQ.isCorrectText(objOpenFAQ.getAnswerAboutRentingSeveralScooters(), Answers.questionAboutRentingSeveralScootersText);

        objOpenFAQ.clickQuestionAboutRentalTime();
        objOpenFAQ.isCorrectText(objOpenFAQ.getAnswerAboutRentalTime(), Answers.questionAboutRentalTimeText);

        objOpenFAQ.clickQuestionAboutOrderingForToday();
        objOpenFAQ.isCorrectText(objOpenFAQ.getAnswerAboutOrderingForToday(), Answers.questionAboutOrderingForTodayText);

        objOpenFAQ.clickQuestionAboutChangingLeaseTerm();
        objOpenFAQ.isCorrectText(objOpenFAQ.getAnswerAboutChangingLeaseTerm(), Answers.questionAboutChangingLeaseTermText);

        objOpenFAQ.clickQuestionAboutCharger();
        objOpenFAQ.isCorrectText(objOpenFAQ.getAnswerAboutCharger(), Answers.questionAboutChargerText);

        objOpenFAQ.clickQuestionAboutOrderCancellation();
        objOpenFAQ.isCorrectText(objOpenFAQ.getAnswerAboutOrderCancellation(), Answers.questionAboutOrderCancellationText);

        objOpenFAQ.clickQuestionAboutDeliveryOutsideMKAD();
        objOpenFAQ.isCorrectText(objOpenFAQ.getAnswerAboutDeliveryOutsideMKAD(), Answers.questionAboutDeliveryOutsideMKADText);
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}