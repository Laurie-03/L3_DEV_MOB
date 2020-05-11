package fr.java.smsstats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class QuickMessageActivity extends AppCompatActivity {

    public static ArrayList<QuickMessage> quickMessage_arrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private QuickMessageAdapter quickMessageAdapter;

    private EditText add_quick_message_input;
    private ImageButton add_quick_message_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_message);

        QuickMessage quickMessage1 = new QuickMessage("Message 1");
        QuickMessage quickMessage2 = new QuickMessage("Message 2");
        quickMessage_arrayList.add(quickMessage1);
        quickMessage_arrayList.add(quickMessage2);

        recyclerView = findViewById(R.id.quick_message_recycler_view);
        add_quick_message_input = findViewById(R.id.add_quick_message_input);
        add_quick_message_button = findViewById(R.id.add_quick_message_button);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        quickMessageAdapter = new QuickMessageAdapter(quickMessage_arrayList);
        recyclerView.setAdapter(quickMessageAdapter);

        add_quick_message_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = add_quick_message_input.getText().toString();

                QuickMessage quickMessage = new QuickMessage(message);
                quickMessage_arrayList.add(quickMessage);
                quickMessageAdapter.notifyDataSetChanged();
                add_quick_message_input.getText().clear();
            }
        });
    }
}
