package yasmin.ayman.alzainy.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnConstraint , btnRelative , btnFrame , btnGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConstraint = findViewById(R.id.btnConstraint);
        btnRelative = findViewById(R.id.btnRelative);
        btnFrame = findViewById(R.id.btnFrame);
        btnGrid = findViewById(R.id.btnGrid);

        btnConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ConstraintActivity.class);
                startActivity(intent);
            }
        });

        btnRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , RelativeActivity.class);
                startActivity(intent);
            }
        });

        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , FrameActivity.class);
                startActivity(intent);
            }
        });

        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , GridActivity.class);
                startActivity(intent);
            }
        });

    }
}
