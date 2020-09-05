package com.example.androidloginandlandingpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.channels.UnresolvedAddressException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button LoginBtn;
    EditText password;
    EditText Username;
    ArrayList<User> Accounts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginBtn = findViewById(R.id.LoginBtn);
        password = findViewById(R.id.password);
        Username = findViewById(R.id.Username);
        Accounts.add(new User("user1", "1234"));
        Accounts.add(new User("user2", "12345"));

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Username.getText().toString();
                String Password = password.getText().toString();
                if(verifyUsers(name, Password) == true){
                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    intent.putExtra("displayUsername",name);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Info", Toast.LENGTH_LONG).show();
//                    EditText.setHighlightColor(ContextCompat.getColor(getApplicationContext(), R.color.password));
                }
            }
        });
    }

    public boolean verifyUsers(String username, String password){
        for(User person : Accounts){
            if(person.getUsername().equals(username) && person.getPassword().equals(password)){
               return true;
            }
        }
        return false;
    }
}
