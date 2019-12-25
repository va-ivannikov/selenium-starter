package pages.passport

import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebDriver
import pages.AbstractPageSteps

class PassportPageSteps(driver: WebDriver) : AbstractPageSteps(driver) {
    private val passportPage = PassportPage(driver)

    override fun getPageUrl(): String = "https://passport.yandex.ru/"

    fun enterLogin(login: String) {
        passportPage.loginInput.click()
        passportPage.loginInput.sendKeys(login)
    }

    fun enterPassword(password: String) {
        passportPage.passwordInput.sendKeys(password)
    }

    fun clickEnterButton() {
        clickOnElement(passportPage.buttonEnter)
    }

    fun clickMagicButton() {
        clickOnElement(passportPage.magicLink)
    }

    fun checkLoginForm() {
        waitUntilVisible(passportPage.loginInput)
        waitUntilVisible(passportPage.loginInput)
        waitUntilVisible(passportPage.buttonEnter)
    }

    fun checkWrongPasswordErrorAppear() {
        waitUntilVisible(passportPage.wrongPasswordHint)
        Assertions.assertEquals(
            "Неверный пароль",
            passportPage.wrongPasswordHint.text
        )
    }

    fun checkQrCode() {
        waitUntilVisible(passportPage.qrCode)
    }
}
