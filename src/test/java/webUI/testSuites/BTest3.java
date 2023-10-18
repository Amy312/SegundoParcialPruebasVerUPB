package webUI.testSuites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webUI.pages.todoist.LoginPage;
import webUI.pages.todoist.MenuSection;
import webUI.pages.todoist.OnBoardPage;
import webUI.pages.todoist.SignUpPage;
import webUI.session.Session;

public class BTest3 {
    LoginPage loginPage = new LoginPage();
    SignUpPage signUpPage = new SignUpPage();
    MenuSection menuSection = new MenuSection();

    OnBoardPage onBoardPage = new OnBoardPage();
    @AfterEach
    public void close(){
        Session.getInstance().closeSession();
    }
    @BeforeEach
    public void open(){
        Session.getInstance().getBrowser().get("https://app.todoist.com/");
    }

    @Test
    public void createUserAndProject() throws InterruptedException {

        loginPage.signUpButton.click();
        signUpPage.emailTextBox.setText("amyaa@cosa.coma");
        signUpPage.passTextBox.setText("panqueS1to");
        signUpPage.sendButton.click();

        onBoardPage.nameTextBox.setText("Ambar Rojas");
        onBoardPage.nameButton.click();
        onBoardPage.eduButton.click();
        onBoardPage.goToMenu.click();
        Assertions.assertTrue(menuSection.addTaskButton.isControlDisplayed(),
                       "ERROR no me pude iniciar sesion");





        Thread.sleep(60000);
       //

    }
}
