package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSend;
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

                intentSendMessage.putExtra(EXTRA_SENT_MESSAGE, msg);

                startActivity(intentSendMessage);
            }
        });
    }

    private void wireWidgets() {
        buttonSend = findViewById(R.id.button_sendmessage_send);
        editTextmessage = findViewById(R.id.edittext_sendmessage_msg);
    }
}
