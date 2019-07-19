package example.chen.com.mvpttest.model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser{

    String email;
    String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public int isValidData() {

        if ((TextUtils.isEmpty(getPassword()) || (getPassword().length() > 6) ) && !Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            return -1;//Email & Password both invalid.
        } else if (TextUtils.isEmpty(getPassword()) || (getPassword().length() < 6) ) {
            return 0;// Password invalid.
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            return 2; // Email invalid
        }
        return 1;
    }
}
