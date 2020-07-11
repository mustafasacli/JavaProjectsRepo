/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consuewebapisampleapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import static java.lang.System.out;
import java.net.HttpURLConnection;

/**
 *
 * @author Krkt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String uri = "http://localhost:5050/api/ServiceApi";
        try {
            URL url = null;
            HttpURLConnection conn = null;
            String sData = "";

            while (true) {
                sData = String.format("%s?deviceCode=%d&data=JSN:%d:%f:JK:%s",
                        uri, getDeviceCode(), getSensorType(), getSensorValue(), getSensorTime());
                out.printf("Data: %s\n", sData);
                url = new URL(sData);
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    out.println(output);
                }

                conn.disconnect();

                out.println("-------------------------------------");
                //Thread.sleep(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int getDeviceCode() {
        Random rnd = new Random();
        int rdn = rnd.nextInt(9999);
        //int rdn = rnd.Next(1000, 9999);
        return rdn;
    }

    static int getSensorType() {
        Random rnd = new Random();
        int rdn = rnd.nextInt(20);
        return rdn;
    }

    static double getSensorValue() {
        Random rnd = new Random();
        double rdn = rnd.nextDouble();
        rdn *= 100.0d;
        return rdn;
    }

    static String getSensorTime() {
        //2017-07-09_21-59-01-545431
        String s = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSSSSS").format(Calendar.getInstance().getTime());
        //DateTime.Now.ToString("yyyy-MM-dd_HH-mm-ss-ffffff");
        return s;
    }

}
