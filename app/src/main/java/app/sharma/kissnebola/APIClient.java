package app.sharma.kissnebola;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit.Builder builder = null;

    public static Retrofit.Builder getClient() {


        builder = new Retrofit.Builder()
                .baseUrl("https://kissnebola.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create());
        return builder;
    }
}
