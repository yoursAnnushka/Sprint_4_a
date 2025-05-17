package ru.scooter.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.scooter.pages.HomePageScooter;

import static ru.scooter.pages.HomePageScooter.HOME_PAGE_SCOOTER_URL;

@RunWith(Parameterized.class)
public class HomePageFAQTest {
    private WebDriver driver;
    private final int number;

    @Before
    public void startUp() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get(HOME_PAGE_SCOOTER_URL);
    }

    public HomePageFAQTest(int number) {
        this.number = number;
    }

    @Parameterized.Parameters(name = "Проверка открытия текста при нажатии на стрелку {0}")
    public static Object[][] getNumberQuestionAndAnswer() {
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
        };
    }

    @Test
    public void openFAQShowsCorrectAnswer() {
        // создать объект класса домашней страницы
        HomePageScooter objOpenFAQ = new HomePageScooter(driver);

        // принять куки
        objOpenFAQ.clickAcceptCookiesButton();

        // раскрыть вопрос и проверить текст ответа
        objOpenFAQ.clickQuestion(number);
        objOpenFAQ.isCorrectText(number);
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}