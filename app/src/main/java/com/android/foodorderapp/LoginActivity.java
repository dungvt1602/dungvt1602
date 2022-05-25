package com.android.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText txtUserName;
    private EditText txtPasswd;
    TextView btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btnLogin = (TextView) findViewById(R.id.buttonLogin);
        txtUserName = (EditText) findViewById(R.id.textUserName);
        txtPasswd = (EditText) findViewById(R.id.textPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtUserName.getText().toString().trim().equals("hau") && txtPasswd.getText().toString().trim().equals("123")){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
                else {
                    txtPasswd.setText("");
                    txtUserName.setText("");
                    Toast.makeText(LoginActivity.this, "Đang nhập thất bại, vui lòng đăng nhập lại", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}