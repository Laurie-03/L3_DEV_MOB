package fr.java.smsstats;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MessagesActivity extends AppCompatActivity {

    LinearLayout hidden_layout;
    ImageButton expand_button;
    Button quick_message_button;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);


        hidden_layout = findViewById(R.id.hidden_layout);
        expand_button = findViewById(R.id.expand_button);
        quick_message_button = findViewById(R.id.quick_message_button);

        expand_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hidden_layout.getVisibility() == View.GONE) {
                    hidden_layout.setVisibility
                            (View.VISIBLE);
                } else {
                    hidden_layout.setVisibility(View.GONE);
                }
            }
        });

        quick_message_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MessagesActivity.this, QuickMessageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
