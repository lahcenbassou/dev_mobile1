package com.example.projet3;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {



    EditText motpass,Email;
    AutoCompleteTextView vill;
    RadioButton radioButtonn,radioButto;



    String[] items =  {"agadir","casablanca","rabat","tanger","marrakeche"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        motpass = (EditText) findViewById(R.id.editTextText12);
        Email = (EditText)  findViewById(R.id.editTextText3);
        vill = (AutoCompleteTextView) findViewById(R.id.auto_complete_txt);
        radioButtonn= (RadioButton) findViewById(R.id.radioButton2);
        radioButto= (RadioButton) findViewById(R.id.radioButton);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
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



    public void cree_compte(View view) {
        String Motpass = motpass.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String ville = vill.getText().toString().trim();
        String type;
        if (radioButtonn.isChecked()) {
            type = radioButtonn.getText().toString();
        } else {
            type = radioButto.getText().toString();
        }

        MyDatabaseHelper2 myDB2 = new MyDatabaseHelper2(MainActivity2.this);
         myDB2.add(email,ville,Motpass);

    }
}