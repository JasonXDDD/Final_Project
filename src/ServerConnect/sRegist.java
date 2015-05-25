package ServerConnect;

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

            urlMod.PrintInput(connection);
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
}
