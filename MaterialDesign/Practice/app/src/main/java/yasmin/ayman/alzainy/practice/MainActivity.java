package yasmin.ayman.alzainy.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnRecycle , btnAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRecycle = findViewById(R.id.btnRecycle);

        btnRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , RecycleWithCardsActivity.class);
                startActivity(intent);
            }
        });

        btnAvatar = findViewById(R.id.btnAvatar);
        btnRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , RecycleWithCardsActivity.class);
                startActivity(intent);
            }
        });


    }
}
