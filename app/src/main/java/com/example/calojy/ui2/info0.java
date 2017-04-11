package com.example.calojy.ui2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class info0 extends AppCompatActivity {
    private EditText formName,formID;
    private String name,id;
    //private String name,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info0);

        formName = (EditText) findViewById(R.id.name);
        formID= (EditText) findViewById(R.id.id);

               findViewById(R.id.cont0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                name=formName.getText().toString();
                id=formID.getText().toString();
                if(name.length()<=0 || id.length()!=13){
                    if(name.length()<=0){formName.setText("");}
                    if(id.length()!=13){formID.setText("");}
                    DialogBox("Please Fill Information correctly");
                }
               else {
                    Intent info1Intent = new Intent(info0.this, info1.class);
                    startActivity(info1Intent);
                }

            }
        });

        findViewById(R.id.back0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent loginIntent = new Intent(info0.this, login.class);
                startActivity(loginIntent);
                            }
        });
    }//end onCreate
    private void DialogBox(String mes){
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(mes);
        alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }
}
