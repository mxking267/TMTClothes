package View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tmtshop.databinding.ActivityAccountBinding;

import Utils.LoginEventHandler;
import ViewModel.UserLoginViewModel;


public class LoginActivity extends AppCompatActivity {


    ActivityAccountBinding binding;
    LoginEventHandler handler;
    UserLoginViewModel loginViewModel;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountBinding.inflate(LayoutInflater.from(getLayoutInflater().getContext()), null, false);
        loginViewModel = new UserLoginViewModel();
        binding.setVm(loginViewModel);
        setContentView(binding.getRoot());
    }

    public void OnSubmitClick(View view) {
        Intent i = new Intent(this, MainActivity.class);
        handler = new LoginEventHandler(this);
        handler.SignIn(loginViewModel.getAccount(), loginViewModel.getPassword());
        startActivity(i);
    }

    public void OnRegisterClick(View view) {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

}