package com.example.calojy.ui2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;


public class info1 extends AppCompatActivity {

    private EditText formMail,formPass1,formPass2,formPhone;
    public static String mail,p1,p2,phone;
    //myDBClass mydb;
    //SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);

        formMail = (EditText) findViewById(R.id.mail);
        formPass1= (EditText) findViewById(R.id.pass1);
        formPass2= (EditText) findViewById(R.id.pass2);
        formPhone = (EditText) findViewById(R.id.phone);

        findViewById(R.id.cont1).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mail=formMail.getText().toString();
                p1=formPass1.getText().toString();
                p2=formPass2.getText().toString();
                phone=formPhone.getText().toString();

                if(mail.length()<=0||p1.length()<=0||phone.length()!=10){
                    DialogBox("Please Fill All Information Correctly");
                }
                else if(!p2.equals(p1)){
                    formPass1.setText("");
                    formPass2.setText("");
                    DialogBox("Password Not Match!");
                }
                else{
                    if(mybtnContClicked(v)) {
                        Intent info2Intent = new Intent(info1.this, info2.class);
                        startActivity(info2Intent);
                    }
                    /*if(btnContClicked(mail,p1,phone)){
                       Intent info2Intent = new Intent(info1.this, info2.class);
                       startActivity(info2Intent);
                   }*/
                }
            }
        });

        findViewById(R.id.back1).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent loginIntent = new Intent(info1.this, info0.class);
                startActivity(loginIntent);
            }
        });

        //SQLiteDatabase db = new myDBClass(this).getWritableDatabase();

        //mydb=new myDBClass(this);
        //db=mydb.getWritableDatabase();
        //db=mydb.getReadableDatabase();

    }//end onCreate

    public boolean mybtnContClicked(View v){
        mail=formMail.getText().toString();
        phone=formPhone.getText().toString();

        if(passengerList.checkInList(mail,phone)){
            DialogBox("Email or Phone Number is already used");
            return false;
        }
        return true;
    }

/*
    public boolean btnContClicked(String mail,String p1,String phone){
        long result=InsertData(mail,p1,phone);
        if(result>0) {
            return true;
        }else{
            DialogBox("Email or Phone Number is already used");
            return false;
        }
    }

    public long InsertData(String mail,String pass1,String phone){
        try{
            ContentValues val=new ContentValues();
            val.put(myDBClass.COL_Email,mail);
            val.put(myDBClass.COL_Pass,pass1);
            val.put(myDBClass.COL_Phone,phone);
            long rows=db.insert(myDBClass.TABLE_NAME,null,val);
            return rows;
        }catch (Exception e){
            return -1;
        }
    }
    */
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
