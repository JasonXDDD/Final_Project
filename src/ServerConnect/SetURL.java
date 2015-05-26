package ServerConnect;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.stream.Stream;

/**
 * Created by JASON_ on 2015/5/26.
 */
public class SetURL {
    private String ADD_URL;
    private static final int sRegist = 1;
    private static final int sLogin = 2;

    public SetURL(){ }


    public String ChooseRequest(int type){
        switch(type){
            case sRegist:
                ADD_URL = new String("http://163.13.128.116:5000/api/user"); break;
            case sLogin:
                ADD_URL = new String("http://163.13.128.116:5000/api/user/login"); break;
        }
        return ADD_URL;
    }


    public HttpURLConnection Astribute(HttpURLConnection connection, String type)
                                                                throws IOException{
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod(type);
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);

        return connection;
    }


    public JSONObject PrintInput(HttpURLConnection connection, JSONObject obj)
                                                            throws IOException{
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }

            System.out.println(sb);
            obj = new JSONObject(sb.toString());
            reader.close();
        }
        catch (IOException I){
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getErrorStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }

            System.out.println(sb);
            obj = new JSONObject(sb.toString());
            reader.close();
        }

        return obj;
    }


    public void SendToServer(HttpURLConnection connection, JSONObject user)
                                                           throws IOException{
        OutputStream out = connection.getOutputStream();
        out.write(user.toString().getBytes());
        out.flush();
        out.close();
    }
}
