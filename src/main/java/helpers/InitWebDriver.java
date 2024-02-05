package helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InitWebDriver {
    public static WebDriver initWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER); //использован Eager, так как все необходимое загружается, при normal долгая загрузка

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(700,900)); //данное разрешение примененно, так как при изначальном (1440*900) кнопка отпраки перекрыта футером и некликабельна
        return driver;
    }
}
