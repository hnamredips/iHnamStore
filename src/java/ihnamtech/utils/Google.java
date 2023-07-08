/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihnamtech.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import ihnamtech.dto.GoogleDTO;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author LENOVO
 */
public class Google {

    public static String GOOGLE_CLIENT_ID = "130207933117-l55um12f91rrkqlahk7n08got3cqard5.apps.googleusercontent.com";

    public static String GOOGLE_CLIENT_SECRET = "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";

    public static String GOOGLE_REDIRECT_URI = "http://localhost:8084/iHnamTech/MainController?action=Google";

    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";

    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

    public static String GOOGLE_GRANT_TYPE = "authorization_code";

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Google.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Google.GOOGLE_CLIENT_ID)
                        .add("client_secret", Google.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Google.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Google.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static GoogleDTO getUser(final String accessToken) throws ClientProtocolException, IOException {
        String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        System.out.println(response);
        GoogleDTO user = new Gson().fromJson(response, GoogleDTO.class);

        return user;
    }
}
