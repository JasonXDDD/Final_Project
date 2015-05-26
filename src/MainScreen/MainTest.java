package MainScreen;

import DataClass.AccountData;
import DialogData.Login;
import DialogData.Regist;

import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/13.
 */
public class MainTest {
    public static AccountData account = new AccountData();

    public static void main(String[] args) throws IOException{
        MainFrame testFrame = new MainFrame();
        Login login = new Login(testFrame, "Login", true);
        login.setVisible(true);
    }
}
