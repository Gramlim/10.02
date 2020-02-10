package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText card;
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        card = findViewById(R.id.editText3);
        email = findViewById(R.id.editText4);


    }
    public void onClick (View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://intelligent-system.online/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Interface api = retrofit.create(Interface.class);
        api.basicAuth(new User(String.valueOf(username.getText()),
                String.valueOf(password.getText()),
                String.valueOf(card.getText()),
                String.valueOf(email.getText()))).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Succes",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"notSucces",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Fail",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
