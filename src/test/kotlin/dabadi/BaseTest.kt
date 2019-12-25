package dabadi

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import pages.main.MainPageSteps
import pages.passport.PassportPageSteps

open class BaseTest {
    lateinit var mainPageSteps: MainPageSteps
    lateinit var passportPageSteps: PassportPageSteps
    lateinit var driver: WebDriver

    @BeforeEach
    fun setUp() {
        driver = ChromeDriver()
        mainPageSteps = MainPageSteps(driver)
        passportPageSteps = PassportPageSteps(driver)
    }

    @AfterEach
    fun showDown() {
        driver.close()
    }
}