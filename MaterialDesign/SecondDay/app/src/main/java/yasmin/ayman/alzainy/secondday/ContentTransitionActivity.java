package yasmin.ayman.alzainy.secondday;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ContentTransitionActivity extends AppCompatActivity {

    private Button btnBackToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_content_transition);

        getWindow().setExitTransition(new ChangeTransform());
        getWindow().setEnterTransition(new Explode());
        btnBackToMain = findViewById(R.id.btnBackToMain);
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContentTransitionActivity.this,MainActivity.class);
                startActivity(intent ,   ActivityOptions.makeSceneTransitionAnimation(ContentTransitionActivity.this).toBundle());
            }
        });
    }
}
