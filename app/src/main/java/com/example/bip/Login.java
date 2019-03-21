package com.example.bip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button button;
    EditText username, password;
    TextView textdaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.button);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        textdaftar = (TextView) findViewById(R.id.textdaftar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                if(TextUtils.isEmpty(uname)){
                    username.setError("Username tidak boleh kosong");
                    return;
                } else if(TextUtils.isEmpty(pass)){
                    password.setError("Password tidak boleh kosong");
                    return;
                }
                Intent i = null;
                i = new
                        Intent( Login.this,MainMenu.class);
                Bundle
                        b = new Bundle();
                b.putString("parse_uname", uname);
                b.putString("parse_pass", pass);
                ((Intent) i).putExtras (b);
                startActivity(i);
            }
        });

        textdaftar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = null;
                i = new
                        Intent(Login.this,Register.class);
                Bundle
                        b = new Bundle();
                ((Intent) i).putExtras (b);
                startActivity(i);
            }
        });
    }
}
