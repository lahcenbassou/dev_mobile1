package com.example.projet3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    EditText titre;
    AutoCompleteTextView categorie,vill;

    String[] items3 =  {"agadir","casablanca","rabat","tanger","marrakeche"};
    AutoCompleteTextView autoCompleteTxt3;
    ArrayAdapter<String> adapterItems3;


    String[] items2 =  {"info","finance","aero","meca"};
    AutoCompleteTextView autoCompleteTxt2;
    ArrayAdapter<String> adapterItems2;

    String[] items =  {"Temps plein","Temps partiel","Contrat à durée déterminée","Stage"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        titre = (EditText) findViewById(R.id.editTextText3);
        vill = (AutoCompleteTextView) findViewById(R.id.auto_complete_txt_ville);
        categorie = (AutoCompleteTextView) findViewById(R.id.auto_complete_txt);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        autoCompleteTxt3 = findViewById(R.id.auto_complete_txt_ville);

        adapterItems3 = new ArrayAdapter<String>(this,R.layout.list_item,items3);
        autoCompleteTxt3.setAdapter(adapterItems3);

        autoCompleteTxt3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });







        autoCompleteTxt2 = findViewById(R.id.auto_complete_txt_s);

        adapterItems2 = new ArrayAdapter<String>(this,R.layout.list_item,items2);
        autoCompleteTxt2.setAdapter(adapterItems2);

        autoCompleteTxt2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });










        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void cree_annonce(View view) {
        String titree = titre.getText().toString().trim();
        String categoriee = categorie.getText().toString().trim();
        String villee = vill.getText().toString().trim();


        MyDatabaseHelper3 myDB3 = new MyDatabaseHelper3(MainActivity3.this);
        myDB3.add2(titree,categoriee,villee);

        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        intent.putExtra("selected_city", villee); // Transfert de la ville sélectionnée
        startActivity(intent);
    }



}