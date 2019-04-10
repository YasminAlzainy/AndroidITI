package yasmin.ayman.alzainy.taps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yasmin.ayman.alzainy.taps.swipLessTaps.SwipLessActivity;
import yasmin.ayman.alzainy.taps.swipTaps.SwipActivity;

public class MainActivity extends AppCompatActivity {

    Button btnSwip , btnSwipLess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSwip = findViewById(R.id.btnSwip);
        btnSwip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , SwipActivity.class);
                startActivity(intent);
            }
        });

        btnSwipLess = findViewById(R.id.btnSwipless);
        btnSwipLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , SwipLessActivity.class);
                startActivity(intent);
            }
        });
    }
}
