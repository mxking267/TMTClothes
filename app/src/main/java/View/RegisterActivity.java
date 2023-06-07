package View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tmtshop.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;

public class RegisterActivity extends AppCompatActivity {

    TextView textView;
    EditText emailEdt, passwordEdt;
    Button signUpButton;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textView = findViewById(R.id.register_tv_login);
        signUpButton = findViewById(R.id.register_btn_dk);

        mAuth = FirebaseAuth.getInstance();
        emailEdt = findViewById(R.id.emailEdt);
        passwordEdt = findViewById(R.id.password_edt);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signUpButton.setOnClickListener(v -> {
                    String email = emailEdt.getText().toString().trim();
                    String password = passwordEdt.getText().toString().trim();

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this, task -> {
                                if (task.isSuccessful()) {
                                    // Sign up success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (user != null) {
                                        user.sendEmailVerification().addOnCompleteListener(send -> {
                                            if (send.isSuccessful()){
                                                Toast.makeText(RegisterActivity.this, "Sign up successful.",
                                                        Toast.LENGTH_SHORT).show();
                                                    Bundle bundle = new Bundle();
                                                    bundle.putSerializable("user", (Serializable) user);
                                                    Intent i = new Intent(this, MainActivity.class);
                                                    i.putExtra("user", user);
                                                    startActivity(i);
                                            }
                                            else if (send.isCanceled()) {
                                                Toast.makeText(RegisterActivity.this, "Please retry",
                                                        Toast.LENGTH_SHORT).show();

                                            }
                                        });
                                    }

                                } else {
                                    // If sign up fails, display a message to the user.
                                    Toast.makeText(RegisterActivity.this, "Sign up failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                }
        );

    }
}