package ViewModel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.tmtshop.BR;

import Model.UserLoginModel;

public class UserLoginViewModel extends BaseObservable {

    public UserLoginViewModel() {
        userLoginModel = new UserLoginModel("", "");
    }


    @Bindable
    public UserLoginModel getUserLoginModel() {
        return userLoginModel;
    }

    public void setUserLoginModel(UserLoginModel userLoginModel) {
        this.userLoginModel = userLoginModel;
    }

    UserLoginModel userLoginModel;

    @Bindable
    public String getAccount() {
        return userLoginModel.getAccount();
    }

    public void setAccount(String account) {
        userLoginModel.setAccount(account);
        notifyPropertyChanged(BR.account);
    }

    @Bindable
    public String getPassword() {
        return userLoginModel.getPassword();
    }

    public void setPassword(String password) {
        userLoginModel.setPassword(password);
        notifyPropertyChanged(BR.password);
    }

    public void onLoginClick() {
        // Xử lý đăng nhập
    }

}
