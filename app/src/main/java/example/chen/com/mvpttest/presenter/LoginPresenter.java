package example.chen.com.mvpttest.presenter;

import example.chen.com.mvpttest.model.User;
import example.chen.com.mvpttest.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {


    ILoginView mILoginView;


    public LoginPresenter(ILoginView ILoginView) {
        mILoginView = ILoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int validDataCode = user.isValidData();
        if (validDataCode == -1) {
            mILoginView.onLoginError("Email & password are invalid!");
        } else if (validDataCode == 0) {
            mILoginView.onLoginError("Password invalid !");
        } else if (validDataCode == 2) {
            mILoginView.onLoginError("Email is invalid !");
        } else {
            mILoginView.onLoginSuccess("Login success !");
        }
    }
}
