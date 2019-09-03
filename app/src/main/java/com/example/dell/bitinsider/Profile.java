package com.example.dell.bitinsider;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    TextView nameTextViewProfile, branchTextViewProfile, contactTextViewProfile;
    EditText aboutEditTextProfile;
    Button editButtonProfile, saveButtonProfile;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameTextViewProfile = (TextView)findViewById(R.id.nameTextViewProfile);
        branchTextViewProfile = (TextView)findViewById(R.id.branchTextViewProfile);
        contactTextViewProfile = (TextView)findViewById(R.id.contactTextViewProfile);
        aboutEditTextProfile = (EditText)findViewById(R.id.aboutEditTextProfile);
        editButtonProfile = (Button)findViewById(R.id.editButtonProfile);
        saveButtonProfile = (Button)findViewById(R.id.saveButtonProfile);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.child("FirstYear").child(MainActivity.id).getValue(User.class);

                nameTextViewProfile.setText("Name :"+user.getName().toString());
                branchTextViewProfile.setText("Branch :"+user.getBranch().toString());
                aboutEditTextProfile.setText("About :"+user.getAbout().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        editButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editButtonProfile.setVisibility(View.INVISIBLE);
                saveButtonProfile.setVisibility(View.VISIBLE);
                aboutEditTextProfile.setEnabled(true);
            }
        });
        saveButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveButtonProfile.setVisibility(View.INVISIBLE);
                editButtonProfile.setVisibility(View.VISIBLE);
                aboutEditTextProfile.setEnabled(false);

                String bio = aboutEditTextProfile.getText().toString();

                //Now save this to firebase
            }
        });

        contactTextViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToContact = new Intent(Profile.this, Contact.class);
                startActivity(goToContact);
                finish();
            }
        });

    }
}
