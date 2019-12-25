package pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit

abstract class AbstractPageSteps(private val driver: WebDriver) {
    private val waitPage = WebDriverWait(driver, 10)
    val waitElement = WebDriverWait(driver, 5)

    init {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().maximize()
    }

    fun openUrl(url: String) {
        driver.get(url)
        isUrlIsOpened(url)
    }

    fun openThisPage() {
        openUrl(getPageUrl())
    }

    abstract fun getPageUrl(): String

    fun isUrlIsOpened(url: String) {
        waitPage.until { it.currentUrl.startsWith(url)}
    }

    fun checkThisPageIsOpened() {
        isUrlIsOpened(getPageUrl())
    }

    fun waitUntilVisible(webElement: WebElement): WebElement {
        waitElement.until { ExpectedConditions.visibilityOf(webElement) }
        return webElement
    }
}