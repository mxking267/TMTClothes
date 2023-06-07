package Model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.List;

public class UserModel extends BaseObservable {
    public UserModel(String name, String imageURL, List<String> carts) {
        this.name = name;
        this.imageURL = imageURL;
        this.carts = carts;
    }

    public UserModel() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCarts(List<String> carts) {
        this.carts = carts;
    }

    String name, imageURL;
    List<String> carts;

    @Bindable
    public String getName() {
        return name;
    }
    @Bindable
    public String getImageURL() {
        return imageURL;
    }
    @Bindable
    public List<String> getCarts() {
        return carts;
    }
}
