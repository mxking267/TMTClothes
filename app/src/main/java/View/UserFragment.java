package View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tmtshop.databinding.FragmentUserLoginBinding;
import com.example.tmtshop.databinding.FragmentUserUnoginBinding;

import Utils.EventHandler;
import ViewModel.UserViewModel;

public class UserFragment extends Fragment {

    private static UserFragment instance;
    FragmentUserUnoginBinding unLoginBinding;
    FragmentUserLoginBinding loginBinding;
    UserViewModel userViewModel;

    public static void setUserID(String userID) {
        if (instance == null) {
            UserFragment.userID = userID;

        }
    }

    public String getUserID() {
        return userID;
    }

    private static String userID = "GB1OB0r7H8TN5BTSxOQMWJJsog23";

    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment getInstance() {
        if (instance == null) {
            instance = new UserFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(userID == null)
        {

            unLoginBinding = FragmentUserUnoginBinding.inflate(LayoutInflater.from(container.getContext()), container, false);
            EventHandler eventHandler = new EventHandler(getContext());
            unLoginBinding.setE(eventHandler);
            return unLoginBinding.getRoot();
        }
       else
        {
            userViewModel = new UserViewModel();

            loginBinding = FragmentUserLoginBinding.inflate(LayoutInflater.from(container.getContext()),container, false);
            userViewModel.GetUserInfo(userID);
            loginBinding.setUservm(userViewModel);
            return loginBinding.getRoot();

        }

    }



}