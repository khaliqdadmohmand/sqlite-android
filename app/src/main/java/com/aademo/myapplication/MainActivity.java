package com.aademo.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name, phone, email;
    Button  submit;
    ListView listView;

    DBHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        listView = findViewById(R.id.list_view);
        submit = findViewById(R.id.submit);

        myDb = new DBHelper(MainActivity.this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameStr = name.getText().toString();
                String phoneStr = phone.getText().toString();
                String emailStr = email.getText().toString();
                if(myDb.insertData(nameStr, phoneStr,emailStr)){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Success")
                            .setMessage("Data inserted successfully")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();

                                   ArrayList<DataModel> list =  myDb.getData();
                                   ListAdapter adapter = new ListAdapter(list,MainActivity.this);
                                   listView.setAdapter(adapter);
                                }
                            });
                    dialog.show();
                }

            }
        });



    }
}
