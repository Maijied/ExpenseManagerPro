package com.example.expensemanagerpro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private  static  int Splash_Screen = 3000;

    //Animation Variable
    Animation topAnim,bottomAnim;

    //Basic Componenets
    ImageView logoImage;
    TextView slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animation
         topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
         bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

         //Hooks
        logoImage=findViewById(R.id.logoImage);
        slogan=findViewById(R.id.sloganText);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);
//                startActivity(intent);
//                finish();
                Pair [] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(logoImage, "logo_tran");
                pairs[1] = new Pair<View,String>(slogan, "slogan_tran");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }
            }
        },Splash_Screen);




        logoImage.setAnimation(topAnim);
        slogan.setAnimation(bottomAnim);


    }
}