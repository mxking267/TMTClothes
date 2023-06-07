package Utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import View.LoginActivity;
import View.RegisterActivity;

public class EventHandler {
    private Context context;

    public EventHandler(Context context) {
        this.context = context;
    }

    public void startRegisterActivity(View view) {
        Intent i = new Intent(context, RegisterActivity.class);
        context.startActivity(i);
    }

    public void startLoginActivity(View view) {
        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);
    }
}
