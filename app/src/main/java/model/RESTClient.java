package model;


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
    private String url = "https://socketpowerbackend.herokuapp.com/webapi/services";


    public RESTClient(){
        conversion = new FormatConversion();
    }

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


}