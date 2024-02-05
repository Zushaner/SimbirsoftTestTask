package helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InitWebDriver {
    public static WebDriver initWebDriver() {
        ChromeOptions options = new ChromeOptions();
        /* использована стратегия загрузки страницы Eager, так как при обычной загрузке страница очень долго загружается
         и может выдать ошибку DOMException: Failed to execute 'querySelectorAll' on 'Element': '\' is not a valid selector.
         */
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(700,900)); //данное разрешение примененно, так как на моем экране (1440*900) кнопка Submit перекрыта футером и некликабельна
        return driver;
    }
}
