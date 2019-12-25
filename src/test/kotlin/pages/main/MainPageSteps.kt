package pages.main

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import pages.AbstractPageSteps

class MainPageSteps(driver: WebDriver) : AbstractPageSteps(driver) {
    private val mainPage = MainPage(driver)

    override fun getPageUrl(): String = "https://money.yandex.ru/"

    fun clickButtonEnter() {
        clickOnElement(mainPage.buttonEnter)
    }

    fun openDropDownUserMenu() {
        clickOnElement(mainPage.userName)
    }

    fun pressLogOutButtonInMenu() {
        clickOnElement(mainPage.logOut)
    }

    fun checkUserIsLogged() {
        waitUntilVisible(mainPage.userName)
    }

    fun checkUserIsNotLogged() {
        waitElement.until { ExpectedConditions.not(ExpectedConditions.visibilityOf(mainPage.userName)) }
    }
}
