package com.example.calojy.ui2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

public class login extends AppCompatActivity {

    private EditText formEmail,formPass;
    private String email,pass;
    myDBClass mydb;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        formEmail=(EditText) findViewById(R.id.elog);
        formPass=(EditText) findViewById(R.id.plog);

        findViewById(R.id.logbtn).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    btnlogin(v);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.reg).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent regIntent = new Intent(login.this, info0.class);
                startActivity(regIntent);
            }
        });
        findViewById(R.id.fg).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent regIntent = new Intent(login.this, forgot.class);
                startActivity(regIntent);
            }
        });

    }//end on create


    public void btnlogin(View v)throws Exception{
        email=formEmail.getText().toString();
        pass=formPass.getText().toString();
        if(!passengerList.checkEmailPass(email,pass)){
            DialogBox("Invalid Email or Password");
        }else{
            //DialogBox("Login Successful :)");
            Intent dashh=new Intent(login.this,dash.class);
            startActivity(dashh);
        }
    }


    private void DialogBox(String mes){
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("");
        alertDialog.setMessage(mes);
        alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }







}//end class
