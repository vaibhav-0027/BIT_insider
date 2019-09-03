package com.example.dell.bitinsider;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BITinsider extends Application {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

}
