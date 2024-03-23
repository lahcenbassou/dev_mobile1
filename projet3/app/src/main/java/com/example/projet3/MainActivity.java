package com.example.projet3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

EditText email,password;
TextView error;
Button connecter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
            email = findViewById(R.id.editTextText);
            password = findViewById(R.id.editTextText2);
            connecter = findViewById(R.id.button);
            error= findViewById(R.id.errorMessage);
            connecter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String userEmail = email.getText().toString();
                    String userPassword = password.getText().toString();
                    MyDatabaseHelper2 dbHelper = new MyDatabaseHelper2(MainActivity.this);
                    boolean userExists = dbHelper.checkUser(userEmail, userPassword);
                    if (userExists) {
                        Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                        error.setText("Email ou mot de passe incorrect");
                        error.setVisibility(View.VISIBLE);
                    }
                }
            });

        }

    public void inscrir(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);

}}