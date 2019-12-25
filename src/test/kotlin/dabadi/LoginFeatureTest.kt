package dabadi

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LoginFeatureTest : BaseTest() {
    private val login = "testittesttest"
    private val password = "TestItNow2020"
    private val wrongPassword = "TestItNow2019"

    @BeforeEach
    fun prepare() {
        mainPageSteps.run {
            openThisPage()
            checkUserIsNotLoged()
        }
    }

    @Test
    @DisplayName("Пользователь может залогиниться с правильными кредами")
    fun login() {
        mainPageSteps.run {
            clickButtonEnter()
        }
        passportPageSteps.run {
            checkThisPageIsOpened()
            checkLoginForm()
            enterLogin(login)
            clickEnterButton()
            enterPassword(password)
            clickEnterButton()
        }
        mainPageSteps.run {
            checkThisPageIsOpened()
            checkUserIsLogged()
        }
    }

    @DisplayName("Залогиненный пользователь может разлогиниться")
    @Test
    fun logout() {
        login()
        mainPageSteps.run {
            openDropDownUserMenu()
            pressLogOutButtonInMenu()
            checkThisPageIsOpened()
            checkUserIsNotLoged()
        }
    }

    @Test
    @DisplayName("Пользователь не может залогиниться с неправильным паролем")
    fun wrongPasswordCantLogin() {
        mainPageSteps.run {
            clickButtonEnter()
        }
        passportPageSteps.run {
            checkThisPageIsOpened()
            checkLoginForm()
            enterLogin(login)
            clickEnterButton()
            enterPassword(wrongPassword)
            clickEnterButton()
            checkWrongPasswordErrorAppear()
        }
    }
}