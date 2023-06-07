package Utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import View.UserFragment;

public class LoginEventHandler {
    public LoginEventHandler(Context context) {
        this.context = context;
    }

    public FirebaseUser getUser() {
        return user;
    }

    FirebaseUser user;

    public Context getContext() {
        return context;
    }

    Context context;
    private FirebaseAuth mAuth;

    public void SignIn(String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( task -> {
                    if (task.isSuccessful()) {
                        // Log in success, update UI with the signed-in user's information
                        user = mAuth.getCurrentUser();
                        UserFragment.setUserID(user.getUid());
                        Toast.makeText(context, "Log in successful.",
                                Toast.LENGTH_SHORT).show();

                    } else {
                        // If log in fails, display a message to the user.
                        Exception exception = task.getException();
                        if (exception != null) {
                            String errorMessage = exception.getMessage();
                            Log.e("SignIn: ", errorMessage);
                        }
                        Toast.makeText(context, "Log in failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
