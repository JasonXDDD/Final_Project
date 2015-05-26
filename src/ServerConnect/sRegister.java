package ServerConnect;

import DataClass.AccountData;
import MainScreen.MainTest;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by JASON_ on 2015/5/26.
 */
public class sRegister {
    private URL ADD_URL;
    private SetURL urlMod = new SetURL();
    private int respondcode = 0;

    private static final int sRegist = 1;
    private HttpURLConnection connection = null;


    public sRegister(String name, String email, String password) throws IOException{
        try {
            ADD_URL = new URL(urlMod.ChooseRequest(sRegist, 0));
            connection = (HttpURLConnection) ADD_URL.openConnection();

            connection = urlMod.Astribute(connection, "POST");

            connection.setRequestProperty("Content-Type", "application/json");

            JSONObject user = new JSONObject();
            user.put("username", name);
            user.put("email", email);
            user.put("password", password);

            urlMod.SendToServer(connection, user);

            JSONObject obj = new JSONObject();
            obj = urlMod.PrintInput(connection, obj);
            respondcode = connection.getResponseCode();

            if(respondcode/100 == 2) {
                urlMod.SetData(obj, MainTest.accountData);
            }

            connection.disconnect();
        }
        catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int getRespondcode() {
        return respondcode;
    }

}
