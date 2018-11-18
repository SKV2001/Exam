package login;

import org.junit.Test;
import parentTest.ParentTest;

public class Login extends ParentTest {

@Test
    public void validLogin(){
       loginPage.openLoginPage();
  }

}
