package com.example.calojy.ui2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;
public class info2 extends AppCompatActivity {
    EditText formAcc;
    Spinner sp;
    String acc;
    String bank;
    info1 n=new info1();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        formAcc=(EditText) findViewById(R.id.accNo);
        sp=(Spinner)findViewById(R.id.spinner);

        findViewById(R.id.fin).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                acc=formAcc.getText().toString();
                bank=((ItemData)sp.getSelectedItem()).getText();
                if(acc.length()!=10 || bank.equals("Choose Bank")){
                    DialogBox("Please fill information correctly");
                 }else {
                    DialogBox("Registration successful");
                    Intent dashIntent = new Intent(info2.this, dash.class);
                    startActivity(dashIntent);
                    passengerList.addInList(info1.mail,info1.p1,info1.phone);
                }

            }
        });
        findViewById(R.id.back2).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent loginIntent = new Intent(info2.this, info1.class);
                startActivity(loginIntent);
            }
        });





        ArrayList<ItemData> list=new ArrayList<>();
        list.add(new ItemData("Choose Bank",R.drawable.iconbank0));
        list.add(new ItemData("Krugsi",R.drawable.iconbank1));
        list.add(new ItemData("TMB",R.drawable.iconbank2));
        list.add(new ItemData("Krugtep",R.drawable.iconbank3));
        list.add(new ItemData("Kasikorn",R.drawable.iconbank4));
        list.add(new ItemData("Krugthai",R.drawable.iconbank5));
        list.add(new ItemData("Thaipanit",R.drawable.iconbank6));

        SimpleImageArrayAdapter adapter=new SimpleImageArrayAdapter(this,
                R.layout.spinner_layout,R.id.txt,list);
        sp.setAdapter(adapter);

    }//end onCreate
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
}
