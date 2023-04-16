package activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.tmtshop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import Fragments.HomeFragment;
import Fragments.LoginFragment;
import Fragments.OrderFragment;
import Fragments.WishListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_view, new HomeFragment())
                .addToBackStack(null)
                .commit();


    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        Fragment fragmentSelected = null;
        int itemId = item.getItemId();
        if (itemId == R.id.bottom_menu_home) {
            fragmentSelected = new HomeFragment();
        } else if (itemId == R.id.bottom_menu_wishList) {
            fragmentSelected = new WishListFragment();
        } else if (itemId == R.id.bottom_menu_order) {
            fragmentSelected = new OrderFragment();
        } else if (itemId == R.id.bottom_menu_login) {
            fragmentSelected = new LoginFragment();
        }
        // It will help to replace the
        // one fragment to other.
        if (fragmentSelected != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, fragmentSelected).addToBackStack(null).commit();
        }
        return true;
    };

}