package com.example.wk10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    //Cursor cursor = sql
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        EditText idInput = findViewById(R.id.enterID);
        Button del = findViewById(R.id.btnDelete);
        Button returnTo2 = findViewById(R.id.btnReturn);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id;
                boolean isDeleted;
                id = Integer.parseInt(idInput.getText().toString());
                isDeleted = databaseHelper.deleteData(id);
                if(isDeleted){
                    Toast.makeText(MainActivity3.this, "Data deleted",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity3.this,"Data not deleted", Toast.LENGTH_LONG).show();
                }
            }
        });

        returnTo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this, MainActivity2.class));
            }
        });
    }

}
