package com.example.signupdbugstation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewTattoo, textViewStudio, textViewLVL, textViewNXT, textViewSignUp, textViewFacebook, textViewGooglePLus;
    EditText editTextUsername, editTextPassword, editTextFullname;
    Button buttonGO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Action bar hiding code
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        //full screen activity
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        textViewTattoo = findViewById(R.id.tvtattoo);
        textViewStudio = findViewById(R.id.tvstudio);
        textViewLVL = findViewById(R.id.tvlvl);
        textViewNXT = findViewById(R.id.tvnxt);
        textViewSignUp = findViewById(R.id.tvSignUp);
        textViewFacebook = findViewById(R.id.tvFacebook);
        textViewGooglePLus = findViewById(R.id.tvFacebook);


        editTextUsername = findViewById(R.id.etUsernamID);
        editTextPassword = findViewById(R.id.etPass);
        editTextFullname = findViewById(R.id.etFullname);


        //Custom font Add->
        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/poppins_italic.ttf");
        textViewTattoo.setTypeface(customFont);
        textViewLVL.setTypeface(customFont);
        textViewNXT.setTypeface(customFont);
        textViewSignUp.setTypeface(customFont);

//set listener
        buttonGO.setOnClickListener(this);

        textViewFacebook.setOnClickListener(this);
        textViewGooglePLus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String fullname = editTextFullname.getText().toString();
        String username = editTextUsername.getText().toString();
        String urlFb = "https://web.facebook.com/";
        String urlGplus = "https://googleplus.com/";
        String pass = editTextPassword.getText().toString();
        if (v.getId() == R.id.btnID) {
            //store to local database or POST to API
        } else if (v.getId() == R.id.tvFacebook) {
            //go to facebook link
            openWebURL(urlFb);
        } else if (v.getId() == R.id.tvGooglePlus) {
            //go to google plus link
            openWebURL(urlGplus);
        }
    }

    public void openWebURL(String inURL) {
        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(inURL));
        startActivity(browse);
    }
}