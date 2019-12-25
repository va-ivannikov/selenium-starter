package pages.passport

import org.junit.jupiter.api.Assertions
import org.openqa.selenium.WebDriver
import pages.AbstractPageSteps

class PassportPageSteps(driver: WebDriver) : AbstractPageSteps(driver) {
    private val passportPage = PassportPage(driver)

    override fun getPageUrl(): String = "https://passport.yandex.ru/"

    fun checkLoginForm() {
        waitUntilVisible(passportPage.loginInput)
        waitUntilVisible(passportPage.loginInput)
        waitUntilVisible(passportPage.buttonEnter)
    }

    fun enterLogin(login: String) {
        waitUntilVisible(passportPage.loginInput)
        passportPage.loginInput.click()
        passportPage.loginInput.sendKeys(login)
    }

    fun enterPassword(password: String) {
        waitUntilVisible(passportPage.passwordInput)
        passportPage.passwordInput.sendKeys(password)
    }

    fun clickEnterButton() {
        waitUntilVisible(passportPage.buttonEnter)
        passportPage.buttonEnter.click()
    }

    fun checkWrongPasswordErrorAppear() {
        waitUntilVisible(passportPage.wrongPasswordHint)
        Assertions.assertEquals(
            "Неверный пароль",
            passportPage.wrongPasswordHint.text
        )
    }
}
