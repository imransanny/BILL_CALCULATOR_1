package com.example.bill_calculator_119247;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class all_bill_manu_2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.all_bill_menu_2);

        TextView waterbill;
        waterbill = findViewById(R.id.c_water_bill_id);
        waterbill.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), calculate_bill_3.class);
                startActivity(i);
            }
        } );



    }
}
