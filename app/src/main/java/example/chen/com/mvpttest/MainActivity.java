package example.chen.com.mvpttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import es.dmoral.toasty.Toasty;
import example.chen.com.mvpttest.presenter.ILoginPresenter;
import example.chen.com.mvpttest.presenter.LoginPresenter;
import example.chen.com.mvpttest.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    
    ILoginPresenter mILoginPresenter;
    EditText mUserEmailEt;
    EditText mUserPasswdEt;
    Button mUserLoginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserEmailEt = (EditText) findViewById(R.id.user_email);
        mUserPasswdEt = (EditText) findViewById(R.id.user_password);
        mUserLoginBtn = (Button) findViewById(R.id.login_btn);

        mILoginPresenter = new LoginPresenter(this);

        mUserLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mILoginPresenter.onLogin(mUserEmailEt.getText().toString(),mUserPasswdEt.getText().toString() );
            }
        });
    }

    @Override
    public void onLoginSuccess(String msg) {
        Toasty.success(this,msg ).show();
    }

    @Override
    public void onLoginError(String msg) {
        Toasty.error(this, msg).show();
    }
}
