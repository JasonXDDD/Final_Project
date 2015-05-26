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
public class sLogin {
    private URL ADD_URL;
    private SetURL urlMod = new SetURL();
    private String Answer;

    private static final int sLogin = 2;
    private HttpURLConnection connection = null;

    public sLogin(String token, String email, String password) throws IOException {
        try {
            ADD_URL = new URL(urlMod.ChooseRequest(sLogin));
            connection = (HttpURLConnection) ADD_URL.openConnection();

            connection = urlMod.Astribute(connection, "POST");

            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("token", token);

            JSONObject user = new JSONObject();
            user.put("email", email);
            user.put("password", password);

            urlMod.SendToServer(connection, user);

            JSONObject obj = null;
            obj = urlMod.PrintInput(connection, obj);
            Answer = obj.getString("message");
            System.out.println("Answer: " + Answer);

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

    public String getAnswer() {
        return Answer;
    }

    public static void main(String[] args) throws IOException{
        sGetToken sg = new sGetToken();
        Gobel gbl = new Gobel();
        ServerConnect.sLogin sl = new sLogin(gbl.getToken(), "JasonXDDD", "QQ");
        System.out.println("Token: " + gbl.getToken());
    }

}
