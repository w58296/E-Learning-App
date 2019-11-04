package com.example.e_learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        final EditText account = (EditText) findViewById(R.id.account);
        final EditText password = (EditText) findViewById(R.id.password);

        Drawable[] d_account = account.getCompoundDrawables();
        Drawable[] d_password = password.getCompoundDrawables();

        d_account[0].setBounds(0,0,50,50);
        d_password[0].setBounds(0,0,50,50);

        account.setCompoundDrawables(d_account[0],d_account[1],d_account[2],d_account[3]);
        password.setCompoundDrawables(d_password[0],d_password[1],d_password[2],d_password[3]);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(account.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Intent secondPage = new Intent(getApplicationContext(),DetailInformation.class);
                    startActivity(secondPage);
                }else {
                    Toast.makeText(MainActivity.this,"输入的账号或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
