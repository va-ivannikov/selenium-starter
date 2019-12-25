package pages.main

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.AbstractPage

class MainPage(driver: WebDriver) : AbstractPage(driver) {
    @FindBy(css = "a[class~='header2__button']")
    lateinit var buttonEnter: WebElement

    @FindBy(css = "span[class~='user__name']")
    lateinit var userName: WebElement

    @FindBy(css = "a[class~='user__logout']")
    lateinit var logOut: WebElement
}
