package MainScreen;

import DataClass.AccountData;
import DataClass.BookData;
import DataClass.StoreData;
import DialogData.Login;

import java.io.IOException;

/**
 * Created by JASON_ on 2015/5/13.
 */
public class MainTest {
    public static AccountData accountData = new AccountData();
    public static BookData bookData = new BookData();
    public static StoreData storeData = new StoreData();
    public static MainFrame testFrame;

    public static void main(String[] args) throws IOException{
        String string;
        Loading frame = new Loading();

        Login login = new Login(null, "Login", true);
        login.setVisible(true);

    }
}
