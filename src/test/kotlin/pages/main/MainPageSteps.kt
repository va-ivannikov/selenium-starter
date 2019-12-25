package pages.main

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import pages.AbstractPageSteps

class MainPageSteps(driver: WebDriver) : AbstractPageSteps(driver) {
    private val mainPage = MainPage(driver)

    override fun getPageUrl(): String = "https://money.yandex.ru/"

    fun clickButtonEnter() {
        val buttonEnter = waitUntilVisible(mainPage.buttonEnter)
        buttonEnter.click()
    }

    fun checkUserIsLogged() {
        waitUntilVisible(mainPage.userName)
    }

    fun checkUserIsNotLoged() {
        waitElement.until { ExpectedConditions.not(ExpectedConditions.visibilityOf(mainPage.userName)) }
    }

    fun openDropDownUserMenu() {
        waitUntilVisible(mainPage.userName)
        mainPage.userName.click()
    }

    fun pressLogOutButtonInMenu() {
        waitUntilVisible(mainPage.logOut)
        mainPage.logOut.click()
    }
}
