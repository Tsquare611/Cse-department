package com.example.csedeparment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private Button welcomebutton, facultybutton, aboutbutton, contactbutton;
    FirebaseAuth mAuth;
private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mAuth = FirebaseAuth.getInstance();

        facultybutton = (Button) findViewById(R.id.facultybuttonId);
        aboutbutton = (Button) findViewById(R.id.aboutbuttonId);
        contactbutton = (Button) findViewById(R.id.contactbuttonId);



facultybutton.setOnClickListener(this);
aboutbutton.setOnClickListener(this);
contactbutton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.facultybuttonId){
            intent =new Intent(SecondActivity.this,FacultyActivity.class);
            intent.putExtra("name","bangladesh");
            startActivity(intent);
        }
        if (v.getId()==R.id.aboutbuttonId){
            intent =new Intent(SecondActivity.this,AboutActivity.class);
            intent.putExtra("name","india");
            startActivity(intent);
        }
        if (v.getId()==R.id.contactbuttonId){
            intent =new Intent(SecondActivity.this,ContactActivity.class);
            intent.putExtra("name","pakistan");
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        if (item.getItemId() == R.id.shareId) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject = "Cse Department app";
            String body = "This app is very useful.\n com/example/mysharemenu1/MainActivity.java:37";

            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);

            startActivity(Intent.createChooser(intent, "Share with"));
        }

        if(item.getItemId()==R.id.signOutMenuId)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}


