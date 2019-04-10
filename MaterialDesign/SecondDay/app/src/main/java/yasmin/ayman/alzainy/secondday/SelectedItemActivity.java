package yasmin.ayman.alzainy.secondday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectedItemActivity extends AppCompatActivity {

    public static final String EXTRA_CONTACT = "sharedName" ;
    public static final String EXTRA_IMAGE = "image";

    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_item);

        imageView = findViewById(R.id.imageViewSelected);
        textView = findViewById(R.id.textViewDaySelected);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra(EXTRA_CONTACT));
        imageView.setImageResource(intent.getIntExtra(EXTRA_IMAGE , 1));
    }
}
