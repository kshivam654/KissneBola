package app.sharma.kissnebola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Receiver extends AppCompatActivity {

    private Button read;
    private TextView message, name, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        read = findViewById(R.id.read);
        message = findViewById(R.id.message);
        name = findViewById(R.id.name);
        time = findViewById(R.id.time);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit.Builder builder = APIClient.getClient();

                final Retrofit retrofit = builder.build();

                final UserInterface userInterface = retrofit.create(UserInterface.class);

                Call<CustomMessage> call = userInterface.getMessage();
                call.enqueue(new Callback<CustomMessage>() {
                    @Override
                    public void onResponse(Call<CustomMessage> call, Response<CustomMessage> response) {
                        message.setText(response.body().getText());
                        name.setText(response.body().getName());
                        time.setText(response.body().getTime());


                        if (message.getText().toString().length() == 0){
                            Toast.makeText(Receiver.this, "No message is the server, send some", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<CustomMessage> call, Throwable t) {

                    }
                });
            }
        });

    }
}