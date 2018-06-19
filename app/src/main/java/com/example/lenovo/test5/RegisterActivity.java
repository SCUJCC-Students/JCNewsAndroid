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

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.input_email1)TextInputLayout input_email1;
    @BindView(R.id.input_password1)TextInputLayout input_password1;
    @BindView(R.id.input_reEnterPassword1)TextInputLayout input_reEnterPassword1;
    @BindView(R.id.input_email) EditText emailText;
    @BindView(R.id.input_password) EditText passwordText;
    @BindView(R.id.input_reEnterPassword) EditText reEnterpasswordText;
    @BindView(R.id.btn_signup) Button signupButton;
    @BindView(R.id.link_login)
    TextView loginLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        ButterKnife.bind(this);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void signup() {

        if (!validate()) {
            onSignupFailed();
            return;
        }



        signupButton.setEnabled(false);
        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this,
                R.style.Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("创建成功");
        progressDialog.show();


        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String reEnterPassword = reEnterpasswordText.getText().toString();

      /*
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.save();
        */


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 500);
    }


    public void onSignupSuccess() {
        signupButton.setEnabled(true);
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void onSignupFailed() {
        //Toast.makeText(getBaseContext(), "登录失败", Toast.LENGTH_LONG).show();
        signupButton.setEnabled(true);
    }


    public void showError(TextInputLayout textInputLayout, String error) {
        textInputLayout.setError(error);
        textInputLayout.getEditText().setFocusable(true);
        textInputLayout.getEditText().setFocusableInTouchMode(true);
        textInputLayout.getEditText().requestFocus();
    }

    public boolean validate() {
        boolean valid = true;


        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String reEnterPassword = reEnterpasswordText.getText().toString();


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showError(input_email1,"请输入有效的邮箱");
            //emailText.setError("请输入有效的邮箱");
            valid = false;
        } else {
            emailText.setError(null);
        }



        if (password.isEmpty() || password.length() < 6 || password.length() > 15) {
            showError(input_password1,"密码长度在6-15位之间");
            //passwordText.setError("密码长度在6-15位之间");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 6 || reEnterPassword.length() > 15 || !(reEnterPassword.equals(password))) {
            showError(input_reEnterPassword1,"两次输入密码不一致");
            //reEnterpasswordText.setError("验证密码错误");
            valid = false;
        } else {
            reEnterpasswordText.setError(null);
        }

        return valid;
    }
}
