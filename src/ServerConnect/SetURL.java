package ServerConnect;

import DataClass.AccountData;
import DataClass.BookData;
import DataClass.StoreData;
import MainScreen.MainTest;
import com.sun.prism.Image;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sun.nio.cs.ext.ISCII91;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.transform.stream.StreamSource;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by JASON_ on 2015/5/26.
 */
public class SetURL {
    private String ADD_URL;
    private static final int sRegist = 1;
    private static final int sLogin = 2;
    private static final int sEditAccount = 3;
    private static final int sUploadFile = 4;
    private static final int sUploadHead = 5;
    private static final int sAddStore = 6;
    private static final int sEditStore = 7;

    public SetURL(){ }


    public String ChooseRequest(int type, int ID){
        switch(type) {
            case sRegist:
                ADD_URL = new String("http://163.13.128.116:5000/api/user");
                break;
            case sLogin:
                ADD_URL = new String("http://163.13.128.116:5000/api/user/login");
                break;
            case sEditAccount:
                ADD_URL = new String("http://163.13.128.116:5000/api/user/" + ID);
                break;
            case sUploadFile:
                ADD_URL = new String("http://163.13.128.116:5000/api/upload");
                break;
            case sUploadHead:
                ADD_URL = new String("http://163.13.128.116:5000/api/upload/user_head_image");
                break;
            case sAddStore:
                ADD_URL = new String("http://163.13.128.116:5000/api/category");
                break;
            case sEditStore:
                ADD_URL = new String("http://163.13.128.116:5000/api/category/" + ID);
                break;
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

    public JSONArray PrintInputArray(HttpURLConnection connection) throws IOException{
        JSONArray objlist;

        try {
            StringBuffer sb = new StringBuffer("");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }

            System.out.println("SetURL PrintInput sb = "+sb);

            objlist = new JSONArray(sb.toString());
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
            System.out.println("SetURL PrintInput IOException " + I.getMessage());
            System.out.println(sb);
            objlist = new JSONArray(sb.toString());
            reader.close();
        }
        return objlist;
    }


    public JSONObject PrintInput(HttpURLConnection connection) throws IOException{
        JSONObject obj;

        try {
            StringBuffer sb = new StringBuffer("");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }

            System.out.println("SetURL PrintInput sb = "+sb);
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
            System.out.println("SetURL PrintInput IOException " + I.getMessage());
            System.out.println(sb);
            obj = new JSONObject(sb.toString());
            reader.close();
        }
        return obj;
    }

    public void SendToServer(HttpURLConnection connection, JSONObject user, FileReader file)
                                                           throws IOException{
        OutputStream out = connection.getOutputStream();
        if(user != null) out.write(user.toString().getBytes());
        else out.write(file.toString().getBytes());
        out.flush();
        out.close();
    }





    public void SetAccountData(JSONObject obj, AccountData user){
        try {
            user.setAccount_Name(obj.getString("username"));
            user.setAccount_Password(obj.getString("password"));
            user.setAccount_Email(obj.getString("email"));
            user.setAccount_ID(obj.getInt("user_id"));
            user.setAccount_deactivated(obj.getBoolean("deactivated"));
            user.setAccount_HeadURL(obj.getString("head_image_url"));
            System.out.println("SetData: JSONObj getHeadURL = " + obj.getString("head_image_url"));
            System.out.println("SetData: Account head_image_url = " + user.getAccount_HeadURL());
        }
        catch (JSONException ex)
        {

        }

        try {
            BufferedImage download = ImageIO.read(new URL(user.getAccount_HeadURL()));
            ImageIcon head = new ImageIcon(download);
            user.setAccount_Head(head);
        }
        catch (MalformedURLException e){
            System.out.println("URLException: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }

        System.out.println("Userdata Name: " + user.getAccount_Name() +
                "  Password: " + user.getAccount_Password() +
                "  Email: " + user.getAccount_Email() +
                "  Id: " + user.getAccount_ID() +
                "  Deactivated: " + user.isAccount_deactivated() +
                "  HeadURL: " + user.getAccount_HeadURL() +
                "  Head: " + user.getAccount_Head().toString());
    }





    public void SetHeadData(JSONObject obj, AccountData user, File upload){
//        File target = new File(System.getProperty("user.dir") +
//                                "\\AccountHead\\");
//
//        user.setAccount_HeadURL(obj.getString("head_image_url"));
//
//        try {
//            InputStream in = new FileInputStream(upload);
//            OutputStream out = new FileOutputStream(target);
//
//            byte[] buffer = new byte[1024];
//            int lines;
//            while ((lines = in.read(buffer)) > 0){
//                out.write(buffer, 0, lines);
//            }
//            in.close();
//            out.close();
//        }
//        catch(FileNotFoundException ex){
//            System.out.println(ex.getMessage() + " in the specified directory.");
//            System.exit(0);
//        }
//        catch(IOException e){
//            System.out.println(e.getMessage());
//        }
        ImageIcon up = new ImageIcon(upload.getPath());
        user.setAccount_Head(up);

        System.out.println("UserData HeadURL: " + user.getAccount_HeadURL() +
                            " Head: w: " + up.getIconHeight() +
                            " h: " + up.getIconHeight());
        System.out.println("Head Position: " + user.getAccount_Head().toString());
    }


    public void SetStoreData(JSONArray objlist, int ID){
        MainTest.storeData = new StoreData();

        for(int i = 0; i < objlist.length(); i++){
            MainTest.storeData.setStore_ID(objlist.getJSONObject(i).getInt("category_id"));
            MainTest.storeData.setStore_Name(objlist.getJSONObject(i).getString("category_name"));
            MainTest.storeData.setUser_ID(objlist.getJSONObject(i).getInt("user_id"));
            MainTest.storeData.setDeleted(objlist.getJSONObject(i).getBoolean("deleted"));
            JSONArray books = objlist.getJSONObject(i).getJSONArray("book_list");


            ArrayList<Integer> booklist = new ArrayList<Integer>();
            for(int j = 0; j < books.length(); j++){
                MainTest.storeData.setBKID(books.getInt(j));
                booklist.add(MainTest.storeData.getBKID());
            }
            MainTest.storeData.setBooks_ID(booklist);
        }

        if(ID == 0) {
            MainTest.stList.add(MainTest.storeData);
        }
        else{
            for(StoreData i : MainTest.stList){
                if(i.getStore_ID() == ID){
                    i = MainTest.storeData;
                    System.out.println("Edit on SetStoreData: ID: " + i.getStore_ID() +
                                        "  Name: " + i.getStore_Name());
                    break;
                }
            }
        }

        for(StoreData a : MainTest.stList) {
            System.out.println("store name: " + a.getStore_Name() +
                    "  ID: " + a.getStore_ID() +
                    "  user ID: " + a.getUser_ID() +
                    "  deleted: " + a.isDeleted());
            System.out.print("store book ID: ");

            for(int b : a.getBooks_ID()){
                 System.out.print(b + " ");
            }

            System.out.println("\n");
        }
    }


    public static String getExtension(File file)
    {
        int startIndex = file.getName().lastIndexOf(46) + 1;
        int endIndex = file.getName().length();
        return  file.getName().substring(startIndex, endIndex);
    }

    public static void main(String[] args){
        File f = new File("MainScreen/head.jpg");
        System.out.println(getExtension(f));
    }
}
