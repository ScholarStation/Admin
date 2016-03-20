package WebUtil;


import WebUtil.Login.LoginRes;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static sun.org.mozilla.javascript.internal.ScriptRuntime.typeof;

/**
 * Created by bjc90_000 on 3/20/2016.
 */
public class Webutil {

    private  String Login = "http://70.187.52.39:3000/LoginApp";
    private  String ProfileReq = "http://70.187.52.39:3000/ProfileUtility";
    private  String ProfileEdt = "http://70.187.52.39:3000/ProfileUtility/EditByID";//not implemented
    private  String StudyReq = "http://70.187.52.39:3000/StudyUtility/GetStudyGroupsByMember";
    private  String StudyCrt = "http://70.187.52.39:3000/StudyUtility/Create";
    private  String StudyEdt = "http://70.187.52.39:3000/StudyUtility/EditByID";
    private  String StudyDel = "http://70.187.52.39:3000/StudyUtility/DeleteByID";
    private  String StudySrc = "...";//not implemented

    public Object webRequest(WebRequest payload){


        HttpClient  client = new DefaultHttpClient();
        HttpPost post = new HttpPost(Login);
        Gson gson = new Gson();
        try {
            StringEntity gsonString = new StringEntity(gson.toJson(payload));
            post.setEntity(gsonString);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = client.execute(post);
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String read ="",jsonString="";

//            while((read=br.readLine()) != null) {
//                //System.out.println(read);
//                jsonString+=read;
//            }
            System.out.println();
            return gson.fromJson(new BufferedReader(new InputStreamReader(response.getEntity().getContent())).readLine(),LoginRes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "asdasd";
    }
}
