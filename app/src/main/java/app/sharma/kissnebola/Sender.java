package app.sharma.kissnebola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Sender extends AppCompatActivity {

    private EditText message, name;
    private Button write;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        message = findViewById(R.id.message);
        name = findViewById(R.id.name);
        write = findViewById(R.id.write);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vaild()){
                    //make the request
                    Retrofit.Builder builder = APIClient.getClient();

                    final Retrofit retrofit = builder.build();

                    final UserInterface userInterface = retrofit.create(UserInterface.class);
                    Date currentTime = Calendar.getInstance().getTime();
                    Call<ResponseBody> call = userInterface.sendMessage(new CustomMessage(message.getText().toString(), name.getText().toString(), "",currentTime.toString() ));
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.code() == 200){
                                Toast.makeText(Sender.this, "Message is send to someone", Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(Sender.this, "Ops something went wrong! ps. I'm NOOB", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    });
                }
                else {
                    Toast.makeText(Sender.this, "Invalid name or message", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private boolean vaild() {
        if (message.getText().toString().length() > 5 && name.getText().toString().length() > 4){
            return  true;
        }
        return false;
    }
}