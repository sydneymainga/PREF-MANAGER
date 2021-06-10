package com.example.sydneyuser;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sydneyuser.Request.LoginRequest;

import com.example.sydneyuser.Response.LoginResponse;

import com.example.sydneyuser.utils.ConsoleUtills;
import com.example.sydneyuser.utils.PrefManager;
import com.example.sydneyuser.utils.ToastUtils;
import com.example.sydneyuser.utils.ValidationUtills;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.email)
    EditText mail;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.textView4)
    TextView signup;


    @BindView(R.id.login)
    Button login;

    ProgressDialog progressDialog;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    public void onViewClicked() {

        progressDialog = ProgressDialog.show(this, "", "Please Wait as we authenticate you...", true);

        String Email = mail.getText().toString().trim();
        String pass = password.getText().toString().trim();
        //validates input fields
        if (ValidationUtills.isValidEmail(Email) && ValidationUtills.validate(new EditText[]{password})) {

            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setUsername(mail.getText().toString().trim());
            loginRequest.setPassword(password.getText().toString().trim());

            loginUser(loginRequest);


            // ConsoleUtills.print(createRequest().toString());
        }
    }

    public void loginUser(LoginRequest loginRequest) {
        ConsoleUtills.print(" == " + loginRequest.getUsername() + "  ==> " + loginRequest.getPassword());

        Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    //get the response after login
                    LoginResponse loginResponse = response.body();
                    //assert loginResponse != null;
                    String email = loginResponse.getEmail();
                    String username = loginResponse.getUsername();
                    String msg = "Login Successfull";
                    ToastUtils.showSuccessToast(getApplicationContext(), msg);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));

                    prefManager.storeUser(email,username);


                    ConsoleUtills.print("=====================" + prefManager.getGetUsername().toString());
                    ConsoleUtills.print("=====================" + prefManager.getGetUseremail().toString());

                    finish();
                } else {

                    String msg = null;
                    try {
                        msg = response.errorBody().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    ToastUtils.showErrorToast(getApplicationContext(), msg);


                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String msg = t.getLocalizedMessage();
                ToastUtils.showInfoToast(getApplicationContext(), msg);
            }
        });
    }

    @OnClick(R.id.textView4)
    public void signupClicked() {

        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

    }


}