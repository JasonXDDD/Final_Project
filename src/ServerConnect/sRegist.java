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
public class sRegist {
    private URL ADD_URL;
    private SetURL urlMod = new SetURL();

    private static final int sRegist = 1;
    private HttpURLConnection connection = null;


    public sRegist(String name, String email, String password) throws IOException{
        try {
            ADD_URL = new URL(urlMod.ChooseRequest(sRegist));
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
            SetData(obj, MainTest.account);

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

    public void SetData(JSONObject obj, AccountData user){
        user.setAccount_Name(obj.getString("username"));
        user.setAccount_Password(obj.getString("password"));
        user.setAccount_Email(obj.getString("email"));
        user.setAccount_ID(obj.getInt("user_id"));
        user.setAccount_deactivated(obj.getBoolean("deactivated"));

        System.out.println("Userdata Name: " + user.getAccount_Name() +
                            "  Password: " + user.getAccount_Password() +
                            "  Email: " + user.getAccount_Email() +
                            "  Id: " + user.getAccount_ID() +
                            "  Deactivated: " + user.isAccount_deactivated());
    }
}
