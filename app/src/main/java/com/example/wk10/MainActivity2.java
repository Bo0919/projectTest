package com.example.wk10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        EditText name = findViewById(R.id.name);
        EditText snum = findViewById(R.id.number);
        EditText cell = findViewById(R.id.cellNum);
        EditText cid = findViewById(R.id.courseID);
        TextView result = findViewById(R.id.dataView);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnView = findViewById(R.id.btnView);
        Button btnFor3rd = findViewById(R.id.btnDelete);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            boolean isInserted;
            @Override
            public void onClick(View view) {
                isInserted = databaseHelper.addData(
                        name.getText().toString(),
                        snum.getText().toString(),
                        cell.getText().toString(),
                        cid.getText().toString());
                if(isInserted){
                    Toast.makeText(MainActivity2.this,"Data added",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity2.this, "Data not added", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = databaseHelper.viewData();
                StringBuilder str = new StringBuilder();
                if(cursor.getCount() > 0){
                    while(cursor.moveToNext()){
                        str.append("id: " +cursor.getString(0));
                        str.append("name: " +cursor.getString(1));
                        str.append("sNum: " +cursor.getString(2));
                        str.append("cell: " +cursor.getString(3));
                        str.append("cid: " +cursor.getString(4));
                        str.append("\n");
                    }
                    result.setText(str);
                }else{
                    Toast.makeText(MainActivity2.this, "no Data to read",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnFor3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });
    }
}