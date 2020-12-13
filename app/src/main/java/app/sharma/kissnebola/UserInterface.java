package app.sharma.kissnebola;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserInterface {

    @GET("/")
    Call<CustomMessage> getMessage();

    @POST("/")
    Call<ResponseBody> sendMessage(@Body CustomMessage data);

}
