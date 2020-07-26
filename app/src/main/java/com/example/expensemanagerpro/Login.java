package com.example.expensemanagerpro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    TextView callSignUp,slogan,logoName,ForgetPassword;
    ImageView logoImage;
    TextInputLayout userName,passWord;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);



        //Hooks
        logoImage= findViewById(R.id.logo_image);
        logoName= findViewById(R.id.logo_name);
        slogan= findViewById(R.id.slogan);
        userName= findViewById(R.id.username);
        passWord= findViewById(R.id.password);
        loginButton=findViewById(R.id.login_btn);
        ForgetPassword= findViewById(R.id.forget_password);
        callSignUp= findViewById(R.id.signup);




        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,SignUp.class);
                Pair[] pairs =new Pair[7];
                pairs[0] = new Pair<View,String>(logoImage,"logo_tran");
                pairs[1] = new Pair<View,String>(logoName,"slogan_tran");
                pairs[2] = new Pair<View,String>(slogan,"nextSlogan_tran");
                pairs[3] = new Pair<View,String>(userName,"username_tran");
                pairs[4] = new Pair<View,String>(passWord,"password_tran");
                pairs[5] = new Pair<View,String>(loginButton,"go_button_tran");
                pairs[6] = new Pair<View,String>(callSignUp,"signup_login_button_tran");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                    startActivity(intent, options.toBundle());

                }


            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Dashboard.class);
                startActivity(intent);
            }
        });

        ForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, com.example.expensemanagerpro.ForgetPassword.class);
                startActivity(intent);
            }
        });
    }
}