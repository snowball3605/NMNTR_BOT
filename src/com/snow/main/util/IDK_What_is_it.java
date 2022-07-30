package com.snow.main.util;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class IDK_What_is_it {

    public static String getData(String url, String au) {
        try {
            HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            if (au != null)
                connection.setRequestProperty("au", au);
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            String result;
            if (connection.getResponseCode() > 399)
                result = readResponse(connection.getErrorStream());
            else
                result = readResponse(connection.getInputStream());
            connection.disconnect();
            return result;


        } catch (Exception e) {
            e.printStackTrace();
        }


        return url;
    }

    public static String readResponse(InputStream in) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int length;
            while ((length = in.read(buff)) > 0)
                out.write(buff, 0, length);

            in.close();
            return out.toString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("[UrlDataGetter] " + e.fillInStackTrace().getMessage());
            return "";
        }
    }
}
