package pages.passport

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import pages.AbstractPage

class PassportPage(driver: WebDriver) : AbstractPage(driver) {
    @FindBy(css = "div[class='passp-auth]")
    lateinit var passportAuthModule: WebElement

//    @FindBy(css = "input[class='passp-form-field']")
//    lateinit var loginInput: WebElement

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    lateinit var loginInput: WebElement

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    lateinit var passwordInput: WebElement

    @FindBy(css = "*[class~=\"passp-form-field__error\"]")
    lateinit var wrongPasswordHint: WebElement

    @FindBy(css = "*[class~=\"passp-sign-in-button\"]")
    lateinit var buttonEnter: WebElement
}
