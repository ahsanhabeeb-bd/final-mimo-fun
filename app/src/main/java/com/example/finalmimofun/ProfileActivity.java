package com.example.finalmimofun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity
{
    private ImageView main_image;
    private CircleImageView photo_round;
    private ImageView bach;

    private TextView name1;
    private TextView age1;
    private TextView sendin_lavel;
    private TextView receving_lavel;
    private TextView uid1;

    private FirebaseAuth auth;
    private FirebaseUser user;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        main_image = (ImageView) findViewById(R.id.main_image);
        photo_round = (CircleImageView) findViewById(R.id.photo_round);
        bach = (ImageView) findViewById(R.id.bach);
        name1 = (TextView) findViewById(R.id.name1);
        age1 = (TextView) findViewById(R.id.age1);
        sendin_lavel = (TextView) findViewById(R.id.sendin_lavel);
        receving_lavel = (TextView) findViewById(R.id.receving_lavel);
        uid1 = (TextView) findViewById(R.id.uid1);

        auth= FirebaseAuth.getInstance();
        user =auth.getCurrentUser();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child(user.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = String.valueOf(snapshot.child("name").getValue());
                String age1n = String.valueOf(snapshot.child("age").getValue());
                String sendin_laveln = String.valueOf(snapshot.child("gift_send_level").getValue());
                String receving_laveln = String.valueOf(snapshot.child("gift_received_level").getValue());
                String uid1n = String.valueOf(snapshot.child("id_number").getValue());
                String uid2n = String.valueOf(snapshot.child("picture").getValue());

                name1.setText(name);
                age1.setText(age1n);
                sendin_lavel.setText(sendin_laveln);
                receving_lavel.setText(receving_laveln);
                uid1.setText(uid1n);

                Uri uri =user.getPhotoUrl();
                Picasso.get().load(uid2n).into(main_image);
                Picasso.get().load(uid2n).into(photo_round);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}