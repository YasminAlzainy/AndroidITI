package yasmin.ayman.alzainy.myfirebase.note;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import yasmin.ayman.alzainy.myfirebase.R;
import yasmin.ayman.alzainy.myfirebase.RealTimeDB;

public class NoteBodyActivity extends AppCompatActivity {

    EditText titleText, bodyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_body);

        titleText = findViewById(R.id.titleText);
        bodyText = findViewById(R.id.bodyText);

        Intent intent = getIntent();
        titleText.setText(intent.getStringExtra(RealTimeDB.NOTE_TITLE));
        bodyText.setText(intent.getStringExtra(RealTimeDB.NOTE_BODY));
    }
}
