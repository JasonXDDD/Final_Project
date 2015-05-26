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

    public static void main(String[] args) throws IOException{
        String string;
        Loading frame = new Loading();
        try {
            frame.setVisible(true);
            for(int i = 1; i <= 7; i++){
                Thread.sleep(500);
                string = new String(frame.TXT.getText() + ".");
                frame.TXT.setText(string);
            }
            frame.dispose();
        }
        catch (InterruptedException e){}

        Login login = new Login(null, "Login", true);
        login.setVisible(true);

    }
}
