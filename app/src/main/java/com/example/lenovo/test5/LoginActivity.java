package com.example.lenovo.test5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.input_email)
    EditText emailText;
    @BindView(R.id.input_password) EditText passwordText;
    @BindView(R.id.btn_login)
    Button loginButton;
    @BindView(R.id.link_signup)
    TextView signupLink;
    @BindView(R.id.input_password1)TextInputLayout input_password1;
    @BindView(R.id.input_email1)TextInputLayout input_email1;
    public List<User> userList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        ButterKnife.bind(this);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

    }
    public void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }

        loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("正在登录...");
        progressDialog.show();

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

       /* userList= DataSupport.findAll(User.class);
        Iterator<User> iterator =userList.iterator();
        for (User u:userList){
        if(u.getEmail().equals(email)||u.getPassword().equals(password)) {

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            onLoginSuccess();
                            progressDialog.dismiss();
                        }
                    }, 1000);
        }
           else {
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                             onLoginFailed();
                            progressDialog.dismiss();
                        }
                    }, 1000);

        }

        }
        }
        */
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        onLoginSuccess();
                        progressDialog.dismiss();
                    }

                }, 800);
    }





    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        // Toast.makeText(getBaseContext(), "登录失败", Toast.LENGTH_LONG).show();
        loginButton.setEnabled(true);
    }

    public void showError(TextInputLayout textInputLayout,String error){
        textInputLayout.setError(error);
        textInputLayout.getEditText().setFocusable(true);
        textInputLayout.getEditText().setFocusableInTouchMode(true);
        textInputLayout.getEditText().requestFocus();


    }

    public boolean validate() {
        boolean valid = true;
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showError(input_email1,"请输入有效的邮箱");
            //emailText.setError("请输入有效的邮箱地址");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 6 || password.length() > 15) {
            showError(input_password1,"密码长度为6-15位");
            //passwordText.setError("密码长度为6-15位");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }
}
