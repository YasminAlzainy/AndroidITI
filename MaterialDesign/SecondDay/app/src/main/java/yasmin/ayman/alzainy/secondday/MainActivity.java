package yasmin.ayman.alzainy.secondday;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPass;
    private Button btnRegist , btnContentTransition;
    private RadioButton radioMale, radioFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTextPass);
        btnRegist = findViewById(R.id.btnRegist);
        radioFemale = findViewById(R.id.radio_female);
        radioMale = findViewById(R.id.radio_male);

        radioMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_SHORT).show();
            }
        });

        radioFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , RecyclerActivity.class);
                startActivity(intent);
            }
        });

        btnContentTransition = findViewById(R.id.btnContentTransition);
        btnContentTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ContentTransitionActivity.class);
                startActivity(intent ,  ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });


    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkbox_art:
                if (checked) {
                    Toast.makeText(this, "Art checked", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "Art Un-checked", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.checkbox_design:
                if (checked) {
                    Toast.makeText(this, "Design checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Design Un-checked", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.checkbox_editing:
                if (checked) {
                    Toast.makeText(this, "editing checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "editing Un-checked", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.checkbox_tech:
                if (checked) {
                    Toast.makeText(this, "tech checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "tech Un-checked", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
