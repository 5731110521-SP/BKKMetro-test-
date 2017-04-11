package com.example.calojy.ui2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class forgot extends AppCompatActivity {
    private EditText formEmailFor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        formEmailFor=(EditText) findViewById(R.id.mailfor);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBox("Email Sent...");

            }
        });
        findViewById(R.id.back3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent log = new Intent(forgot.this,login.class);
                startActivity(log);
            }
        });

    }//end conCreate

    private void DialogBox(String mes){
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Done");
        alertDialog.setMessage(mes);
        alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent log = new Intent(forgot.this,login.class);
                startActivity(log);
            }
        });
        alertDialog.show();
    }
}
