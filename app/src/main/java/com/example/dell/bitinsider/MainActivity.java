package com.example.dell.bitinsider;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    static String id;
    static String pass;
    EditText loginEditTextMain;
    EditText passwordEditTextMain;
    TextView contactUsTextView;
    Button loginButtonMain;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public void login(View view) {

    }

    public void contactUs(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEditTextMain = (EditText) findViewById(R.id.loginEditTextMain);
        passwordEditTextMain = (EditText) findViewById(R.id.passwordEditTextMain);
        contactUsTextView = (TextView) findViewById(R.id.contactUsTextView);
        loginButtonMain = (Button) findViewById(R.id.loginButtonMain);
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference();

        loginButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = loginEditTextMain.getText().toString();
                pass = passwordEditTextMain.getText().toString();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        User user = dataSnapshot.child("FirstYear").getValue(User.class);

                        if (user != null) {
                            if (id.equals(user.getRollnumber())&&pass.equals(user.getPassword())){///yha pr changes krne pd skte hai
                                //Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(MainActivity.this, HomePage.class);
                                startActivity(i);
                                finish();
                            }
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                //check id and pass
                //redirect to home if password is right
            }
        });
        contactUsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Contact.class);
                startActivity(i);
                finish();
            }
        });
//        User user = new User();
//        user.setName("tarun");
//        user.setRollnumber("1603013112");
//        user.setPassword("123456");


      // databaseReference.child("Students").setValue(user);


    }


}
