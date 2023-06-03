package Network;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class API extends AsyncTask<Void, Void, String> {
    OkHttpClient client = new OkHttpClient();
    okhttp3.Response response;
    @Override
    protected String doInBackground(Void... voids) {


        Request request = new Request.Builder()
                .url("https://taobao-api.p.rapidapi.com/api?api=item_search&page_size=40&q=shoes")
                .get()
                .addHeader("X-RapidAPI-Key", "198508631dmshf2232be10fade0fp19ebfdjsnf9a66c9f5166")
                .addHeader("X-RapidAPI-Host", "taobao-api.p.rapidapi.com")
                .build();

        try {
            response = client.newCall(request).execute();
            Log.e( "onViewCreated: ", response.body().toString() );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response.body().toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }
}
