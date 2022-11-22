package com.example.finalmimofun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
{
    private Button logout;

    private TextView related_id;
    private TextView hot_id;
    private View related_id_view;
    private View hot_id_view;
    private ImageView scarse_id;
    private ImageView live_id;

    private ImageView home1;
    private ImageView game1;
    private ImageView chat1;
    private ImageView profile1;

    private ImageSlider slider;


    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);



        related_id= findViewById(R.id.related_id);
        hot_id= findViewById(R.id.hot_id);
        related_id_view= findViewById(R.id.related_id_view);
        hot_id_view= findViewById(R.id.hot_id_view);
        scarse_id= findViewById(R.id.scarse_id);
        live_id= findViewById(R.id.live_id);

        home1 = findViewById(R.id.home1);
        game1 = findViewById(R.id.game1);
        chat1 = findViewById(R.id.chat1);
        profile1 = findViewById(R.id.profile1);


        slider = findViewById(R.id.slider);

        //Image slider start

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.slide1,ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide2,ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide3,ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide4,ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slide5,ScaleTypes.FIT));

        slider.setImageList(slideModels,ScaleTypes.FIT);

        //slider End


        logout = findViewById(R.id.logout);


        auth = FirebaseAuth.getInstance();

        related_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                related_id.setTextSize(22);
                related_id_view.setVisibility(View.VISIBLE);
                hot_id.setTextSize(20);
                hot_id_view.setVisibility(View.INVISIBLE);
                startActivity(new Intent(HomeActivity.this,RelateActivity.class));
                overridePendingTransition(R.anim.slide_in_left,R.anim.slid_out_right);
            }
        });

        hot_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hot_id.setTextSize(22);
                hot_id_view.setVisibility(View.VISIBLE);
                related_id.setTextSize(20);
                related_id_view.setVisibility(View.INVISIBLE);

            }
        });

        scarse_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ScarceActivity.class));
            }
        });

        live_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LiveActivity.class));
            }
        });

        home1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,HomeActivity.class));
            }
        });

        game1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(HomeActivity.this,GameActivity.class));
           }
       });

        chat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ChatActivity.class));
            }
        });

        profile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ProfileActivity.class));
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                auth.signOut();
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}