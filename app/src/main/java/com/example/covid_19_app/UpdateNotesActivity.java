package com.example.covid_19_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateNotesActivity extends AppCompatActivity {

    EditText title,description,date1;
    Button updateNotes;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);

        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
        date1=findViewById(R.id.date1);
        updateNotes=findViewById(R.id.updateNote);

        Intent i =getIntent();
        title.setText(i.getStringExtra("title"));
        description.setText(i.getStringExtra("description"));
        date1.setText(i.getStringExtra("date1"));
        id=i.getStringExtra("id");

        updateNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString()) && !TextUtils.isEmpty(date1.getText().toString()))
                {

                    DatabaseClass db = new DatabaseClass(com.example.covid_19_app.UpdateNotesActivity.this);
                    db.updateNotes(title.getText().toString(), description.getText().toString(), date1.getText().toString(), id);

                    Intent i=new Intent(com.example.covid_19_app.UpdateNotesActivity.this,Jurnal.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();


                }
                else
                {
                    Toast.makeText(com.example.covid_19_app.UpdateNotesActivity.this, "Toate campurile sunt obligatorii", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}