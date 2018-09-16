package musipo.utils;

import net.minidev.json.JSONObject;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by G510 on 25-03-2017.
 */
public class PushNotification {

    public final static String AUTH_KEY_FCM = "AIzaSyBBWoTJ5YLBZ76uXye_l3jyLdOO8I83qxw";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    public final static Integer PUSH_FLAG_CHATROOM = 1;
    public final static Integer PUSH_FLAG_USER = 2;
// userDeviceIdKey is the device id you will query from your database

    public static void pushFCMNotification(String userDeviceIdKey, HashMap notificationMsg) throws Exception {

        String authKey = AUTH_KEY_FCM; // You FCM AUTH key
        String FMCurl = API_URL_FCM;

        URL url = new URL(FMCurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + authKey);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        json.put("to", userDeviceIdKey.trim());
        json.put("data", notificationMsg);

     /*
     JSONObject info = new JSONObject();
        info.put("title", "Notificatoin Title"); // Notification title
        info.put("body", "Hello Test notification"); // Notification body
*/

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(json.toString());
        wr.flush();
        conn.getInputStream();

     String dataSrt = conn.getResponseCode()+"";
        System.out.print("notificationMsg"+notificationMsg+dataSrt);
    }
}
