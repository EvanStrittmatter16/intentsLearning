package com.example.intentslearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReciveMessageActivity extends AppCompatActivity {

    private TextView textViewDisplayMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive_message);

        WireWidgits();
        textViewDisplayMsg.setText(getIntent().getStringExtra(MainActivity.EXTRA_SENT_MESSAGE));
    }

    private void WireWidgits() {
        textViewDisplayMsg = findViewById(R.id.textview_recivemessage_display);
    }
}
