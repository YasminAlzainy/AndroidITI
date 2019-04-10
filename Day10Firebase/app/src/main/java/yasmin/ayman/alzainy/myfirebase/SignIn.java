package yasmin.ayman.alzainy.myfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import yasmin.ayman.alzainy.myfirebase.note.NoteActivity;

public class SignIn extends AppCompatActivity {

    private static final int GOOGLE_SIGN_IN = 1 ;
    private EditText editTextEmail, editTextPass;
    private Button btnRegist, btnLogin;
    private FirebaseAuth mAuth;
    private GoogleSignInOptions gso;
    private GoogleSignInClient mGoogleSignInClient;
    private SignInButton btnGoogle ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initComponents();

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent googleIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(googleIntent,GOOGLE_SIGN_IN);
            }
        });

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FBCreateEmail(editTextEmail.getText().toString(), editTextPass.getText().toString());
                Intent intent = new Intent(SignIn.this, NoteActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FBSignInEmail(editTextEmail.getText().toString(), editTextPass.getText().toString());
            }
        });

    }

    private void initComponents() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTextPass);
        btnRegist = findViewById(R.id.btnRegist);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogle = findViewById(R.id.btnGoogle);

        mAuth = FirebaseAuth.getInstance();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GOOGLE_SIGN_IN) {
            try {
                GoogleSignInAccount googleSignInAccount = GoogleSignIn.getSignedInAccountFromIntent(data)
                        .getResult(ApiException.class);
                String email = googleSignInAccount.getEmail();
                Toast.makeText(SignIn.this, "Welcome ya " + email, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SignIn.this, NoteActivity.class);
                startActivity(intent);

            } catch (ApiException e) {
                e.printStackTrace();
                Toast.makeText(SignIn.this, "Fail :( " , Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    }

    public void FBSignInEmail(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignIn.this, "Sign Successes ^_^", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignIn.this, NoteActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignIn.this, "Sign Fail :(", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void FBCreateEmail(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignIn.this, "Create Successes ^_^", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignIn.this, NoteActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignIn.this, "Create Fail :(", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    public void googleSginIn(String email, String password) {

    }

}
