package ViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Model.UserModel;

public class UserViewModel extends ViewModel {

    public UserViewModel(MutableLiveData<UserModel> userModel) {
        this.userModel = userModel;
    }

    public UserViewModel() {
    }

    public MutableLiveData<UserModel> getUserModel() {
        return userModel;
    }

    private MutableLiveData<UserModel> userModel;

    public void GetUserInfo(String userID)
    {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users").child(userID);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    UserModel userModel1 = new UserModel();
                    userModel1.setName(snapshot.child("name").getValue(String.class));
                    userModel1.setImageURL(snapshot.child("imageURL").getValue(String.class));
                    for(DataSnapshot dataSnapshot : snapshot.child("cart").getChildren())
                        userModel1.getCarts().add(dataSnapshot.toString());

                    userModel.setValue(userModel1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
