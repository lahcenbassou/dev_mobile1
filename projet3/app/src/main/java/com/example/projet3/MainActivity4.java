package com.example.projet3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Récupération de la ville sélectionnée depuis l'Intent
        String selectedCity = getIntent().getStringExtra("selected_city");
        MyDatabaseHelper3 myDB = new MyDatabaseHelper3(MainActivity4.this);
        // Appel à la méthode pour compter les annonces dans la ville sélectionnée
        int numberOfAds = myDB.countAdsInCity(selectedCity);

        // Affichage du nombre d'annonces dans un TextView
        TextView adsCountTextView = findViewById(R.id.textView18);
        adsCountTextView.setText("nombre d'annoce dans " + selectedCity + ": " + numberOfAds);
    }

    // Méthode pour compter les annonces dans une ville spécifique


}