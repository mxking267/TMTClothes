package View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.tmtshop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;

import Adapter.MainPagerAdapter;

public class MainActivity extends AppCompatActivity implements Serializable {
    ViewPager viewPager;
    MainPagerAdapter adapterView;
    BottomNavigationView bottomNavigationView;
    String userID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set color status bar
/*        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            window.setStatusBarColor(Color.TRANSPARENT);
            View decor = getWindow().getDecorView();
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }*/

        viewPager = this.findViewById(R.id.main_view_pager);
        adapterView = new MainPagerAdapter(getSupportFragmentManager());
        bottomNavigationView = findViewById(R.id.bottom_nav);

        //ViewPager Fragment
        adapterView.addFragment(new HomeFragment());
        adapterView.addFragment(new WishListFragment());
        adapterView.addFragment(new OrderFragment());
        adapterView.addFragment(new UserFragment());
        viewPager.setAdapter(adapterView);

        //Firebase
        FirebaseApp.initializeApp(this);
        FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");



        //Bottom navigation event
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_view_pager, new HomeFragment())
                .addToBackStack(null)
                .commit();

        //two way binding (view pager - bottom nav)
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_wishList);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_order);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_login);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    //Bottom navigation set event function
    final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        int itemId = item.getItemId();
        if (itemId == R.id.bottom_menu_home) {
            viewPager.setCurrentItem(0, true);
        } else if (itemId == R.id.bottom_menu_wishList) {
            viewPager.setCurrentItem(1, true);
        } else if (itemId == R.id.bottom_menu_order) {
            viewPager.setCurrentItem(2, true);
        } else if (itemId == R.id.bottom_menu_login) {
            viewPager.setCurrentItem(3, true);
        }
        // It will help to replace the
        // one fragment to other.

        return true;
    };


    public String getUserID() {
        return userID;
    }
}