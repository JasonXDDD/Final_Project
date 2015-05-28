package ServerConnect;

import MainScreen.MainTest;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;



/**
 * Created by JASON_ on 2015/5/27.
 */
public class sUploadHead {
    private URL ADD_URL;
    private SetURL urlMod = new SetURL();
    private int respondcode = 0;

    private static final int sUploadHead = 5;


    public sUploadHead(String token, File uploadfile) throws IOException {
        System.out.println("--upload Head---");
        try {
            CloseableHttpClient client = HttpClients.createDefault();

            ADD_URL = new URL(urlMod.ChooseRequest(sUploadHead, 0));
            HttpPost post = new HttpPost(ADD_URL.toString());
            post.addHeader("token", token);
            //post.addHeader("Content-Type", "multipart/form-data");

            FileBody upload = new FileBody(uploadfile);

            HttpEntity request = MultipartEntityBuilder.create()
                    .addPart("head_image", upload).build();

            post.setEntity(request);


            CloseableHttpResponse response = client.execute(post);

            try {
                System.out.println(response.getStatusLine());
                HttpEntity responceEntity = response.getEntity();
                String responseStr = EntityUtils.toString(responceEntity);

                if (responceEntity != null){
                    System.out.println("Head upload: " + responseStr);

                    JSONObject obj = new JSONObject(responseStr);
                    urlMod.SetHeadData(obj, MainTest.accountData, uploadfile);
                    respondcode = response.getStatusLine().getStatusCode();
                }
                else
                    System.out.println("No Response");

            }
            finally {
                response.close();
            }
            client.close();
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

