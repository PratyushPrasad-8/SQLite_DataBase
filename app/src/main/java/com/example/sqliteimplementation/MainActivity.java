package com.example.sqliteimplementation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textBox;
    EditText addTextBox;
    ImageButton addBtn,delBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBox=findViewById(R.id.textBox);
        addTextBox=findViewById(R.id.addTextBox);
        addBtn=findViewById(R.id.addBtn);
        delBtn=findViewById(R.id.delBtn);

        DataBaseHelper db=new DataBaseHelper(this);

        textBox.setText(db.read());

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.update(addTextBox.getText().toString(),1);
                db.read();
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.update("",1);
                db.read();
            }
        });
    }
}