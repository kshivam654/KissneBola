package app.sharma.kissnebola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class SenderReciver extends AppCompatActivity {

    private Button sender, receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_reciver);

        View parentLayout = findViewById(android.R.id.content);

        sender = findViewById(R.id.sender);
        receiver = findViewById(R.id.receiver);

        sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SenderReciver.this, Sender.class);
                startActivity(intent);
            }
        });

        receiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("User", MODE_PRIVATE);
                String messageCount = preferences.getString("count", "");

                if (messageCount.equals("0") || messageCount == "0"){
                    Snackbar snackbar = Snackbar
                            .make(parentLayout, "You have to send message first before read any", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else{
                    Intent intent = new Intent(SenderReciver.this, Receiver.class);
                    startActivity(intent);
                }
            }
        });

    }
}