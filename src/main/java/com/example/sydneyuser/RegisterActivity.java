package com.example.sydneyuser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sydneyuser.Request.RegisterRequest;
import com.example.sydneyuser.Response.RegisterResponse;
import com.example.sydneyuser.utils.ConsoleUtills;
import com.example.sydneyuser.utils.ToastUtils;
import com.example.sydneyuser.utils.ValidationUtills;
import java.io.IOException;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.emailadress)
    EditText emailaddress;

    @BindView(R.id.fname)
    EditText fname;

    @BindView(R.id.lname)
    EditText lname;

    @BindView(R.id.editpassword)
    EditText pass1;

    @BindView(R.id.tvsignin)
    TextView signin;

    @BindView(R.id.editpassword1)
    EditText pass2;

    @BindView(R.id.create)
    Button create;

    ProgressDialog progressDialog;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


    }

    public void registerUser(RegisterRequest registerRequest) {
        ConsoleUtills.print(" == " + registerRequest.getUsername() + "  ==> " + registerRequest.getPassword()+" == " + registerRequest.getEmail());

        Call<RegisterResponse> registerResponseCall = ApiClient.getService().registerUser(registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {

                    String msg = "Registration Successfull";
                    ToastUtils.showSuccessToast(getApplicationContext(), msg);
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));


                    finish();
                } else {
                   //String msg = "We cannot process your request at the moment try again later";


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
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String msg = t.getLocalizedMessage();
                ToastUtils.showInfoToast(getApplicationContext(), msg);
            }
        });
    }

    @OnClick(R.id.create)
    public void signupClicked() {

        progressDialog = ProgressDialog.show(this, "","Please Wait as we register you...", true);

        if (ValidationUtills.validate(new EditText[]{pass1, pass2})) {

            //confirm password
            String pass = pass1.getText().toString().trim();
            String cpass = pass2.getText().toString().trim();

            if (pass.equals(cpass)) {


                RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setEmail(emailaddress.getText().toString().trim());
                registerRequest.setPassword(pass1.getText().toString().trim());
                registerRequest.setUsername(username.getText().toString().trim());
                registerRequest.setFirst_name(fname.getText().toString().trim());
                registerRequest.setLast_name(lname.getText().toString().trim());
                registerUser(registerRequest);



            } else {
                String msg = "Password does not match";
                ToastUtils.showErrorToast(getApplicationContext(), msg);
            }


        }

        //progressDialog.dismiss();
    }

    @OnClick(R.id.tvsignin)
    public void signinClicked() {

        startActivity(new Intent(this, LoginActivity.class));

    }
}