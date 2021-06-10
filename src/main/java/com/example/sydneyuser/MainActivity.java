package com.example.sydneyuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.sydneyuser.Request.RegisterRequest;
import com.example.sydneyuser.Response.LoginResponse;
import com.example.sydneyuser.Response.RegisterResponse;
import com.example.sydneyuser.fragments.HomeFragment;
import com.example.sydneyuser.fragments.InfoFragment;
import com.example.sydneyuser.fragments.ProfileFragment;
import com.example.sydneyuser.utils.ConsoleUtills;
import com.example.sydneyuser.utils.ToastUtils;
import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

import java.io.IOException;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BubbleNavigationLinearView bubbleNavigationLinearView;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bubbleNavigationLinearView=findViewById(R.id.bottom_navigation_view_linear);

        //https://www.youtube.com/watch?v=qLiRQsHCX7A


        //set fragment to be inflated whenever user opens the dashboard
        loadhomeFragments();

        //nav change listener when something is clicked
        bubbleNavigationLinearView.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {

                switch (position){
                    case 0:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container,new HomeFragment());
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container,new InfoFragment());
                        fragmentTransaction.commit();
                        break;
                    case 2:
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container,new ProfileFragment());
                        fragmentTransaction.commit();
                        break;
                }

            }
        });
    }

    /* replace fragments */
    public void loadhomeFragments() {


        new Handler().post(() -> {
            //update the main content by replacing fragments

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            /* add animation on transit */
            fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out);
            /* replace */
            fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,new HomeFragment());
            fragmentTransaction.commit();
        });

    }
}