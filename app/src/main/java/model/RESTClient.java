package model;


import android.os.AsyncTask;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Home on 11/1/2017.
 */

public class RESTClient {

    private FormatConversion conversion;
    private String myResponse;
    private String url = "https://socketpowerbackend.herokuapp.com/webapi/services";
    private String direct = "https://api.particle.io/v1/devices/460028000751353530373132/outletToggle?access_token=9753c88bb2723d4a882497bc80627a62270cb683";


    public RESTClient(){
        conversion = new FormatConversion();
    }

   // public String test

    public String authenticate(String usernamePassword) throws IOException {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(2000, TimeUnit.MILLISECONDS)
                .readTimeout(2000, TimeUnit.MILLISECONDS)
                .writeTimeout(2000, TimeUnit.MILLISECONDS)
                .build();

        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), usernamePassword);

        Request request = new Request.Builder()
                .url(url + "/authentification")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public Client login(String usernamePassword){

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(2000, TimeUnit.MILLISECONDS)
                .readTimeout(2000, TimeUnit.MILLISECONDS)
                .writeTimeout(2000, TimeUnit.MILLISECONDS)
                .build();

        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), usernamePassword);

        Request request = new Request.Builder()
                .url(url + "/login")
                .post(body)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Client newClient = null;
        try {
            newClient = conversion.convertJsonToClient(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newClient;
    }

    public void outletToggleDirect(boolean status, String id){

        String command;

        if (status) {
            command = "outletToggle=" + id + "%20ON";
            new SendCommandToServer().execute(command);
        } else {
            command = "outletToggle=" + id + "%20OFF";
            new SendCommandToServer().execute(command);

        }



    }

    public Outlet outletToggle(Outlet outlet){

        String jsonOutlet = conversion.convertOutletToJson(outlet);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(2000, TimeUnit.MILLISECONDS)
                .readTimeout(2000, TimeUnit.MILLISECONDS)
                .writeTimeout(2000, TimeUnit.MILLISECONDS)
                .build();

        RequestBody body;
        body = RequestBody.create(MediaType.parse("application/json"), jsonOutlet);

        Request request = new Request.Builder()
                .url(url + "/outlettoggle")
                .post(body)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Outlet outlet1 = null;
        try {
            outlet1 = conversion.convertJsonToOutlet(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outlet1;
    }

    private void getServerResponse(String response){
        myResponse = response;
    }

    public class SendCommandToServer extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {



            try {

                String command = strings[0];
                //String testCommand = "{\"yo\": 9}";

                //Create client object
                OkHttpClient client = new OkHttpClient();

                //Transport the request and wait for response to process next
                RequestBody body =
                        RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), command);

                Request request = new Request.Builder()
                        .url(direct)
                        .post(body)
                        .build();
                Response response = client.newCall(request).execute();

                return response.body().string();

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }

            return "ERROR";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }


    }




}