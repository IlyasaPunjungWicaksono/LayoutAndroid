package com.example.bip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    Button button;
    EditText requsername, reqpassword,reqconpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button = (Button) findViewById(R.id.button);
        requsername = (EditText) findViewById(R.id.requsername);
        reqpassword = (EditText) findViewById(R.id.reqpassword);
        reqconpassword = (EditText) findViewById(R.id.reqconpassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = requsername.getText().toString();
                String pass = reqpassword.getText().toString();
                String conpass = reqconpassword.getText().toString();
                if(TextUtils.isEmpty(uname)){
                    requsername.setError("Username tidak boleh kosong");
                    return;
                } else if(TextUtils.isEmpty(pass)){
                    reqpassword.setError("Password tidak boleh kosong");
                    return;
                }else if(TextUtils.isEmpty(conpass)){
                    reqconpassword.setError("Password tidak boleh kosong");
                    return;
                }
                Intent i = null;
                i = new
                        Intent( Register.this,Login.class);
                Bundle
                        b = new Bundle();
                b.putString("parse_uname", uname);
                b.putString("parse_pass", pass);
                b.putString("parse_conpass", conpass);
                ((Intent) i).putExtras (b);
                startActivity(i);
            }
        });
    }
}
