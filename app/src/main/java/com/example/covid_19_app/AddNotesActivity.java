package com.example.covid_19_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNotesActivity extends AppCompatActivity {

    EditText title, description, date1;
    Button addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        date1 = findViewById(R.id.date1);
        addNote = findViewById(R.id.addNote);

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString()) && !TextUtils.isEmpty(date1.getText().toString())) {
                    com.example.covid_19_app.DatabaseClass db = new com.example.covid_19_app.DatabaseClass(com.example.covid_19_app.AddNotesActivity.this);
                    db.addNotes(title.getText().toString(), description.getText().toString(), date1.getText().toString());

                    Intent intent = new Intent(com.example.covid_19_app.AddNotesActivity.this,Jurnal.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(com.example.covid_19_app.AddNotesActivity.this, "Toate campurile sunt obligatorii", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}