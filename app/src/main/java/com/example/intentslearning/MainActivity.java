package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSend;
    private Button buttonShare;
    private EditText editTextmessage;

    public static final String EXTRA_SENT_MESSAGE = "The Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editTextmessage.getText().toString();

                Intent intentSendMessage = new Intent(MainActivity.this, ReciveMessageActivity.class);

                intentSendMessage.putExtra(Intent.EXTRA_TEXT, msg);

                startActivity(intentSendMessage);
            }
        });
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShare = new Intent(Intent.ACTION_SEND);

                //can look up to datatype u need on internet
                intentShare.setType("text/plain");

                intentShare.putExtra(EXTRA_SENT_MESSAGE, editTextmessage.getText().toString());

                startActivity(intentShare);
            }
        });
    }

    private void wireWidgets() {
        buttonSend = findViewById(R.id.button_sendmessage_send);
        buttonShare = findViewById(R.id.button_main_share);
        editTextmessage = findViewById(R.id.edittext_sendmessage_msg);
    }
}
