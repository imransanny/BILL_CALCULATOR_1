package com.example.bill_calculator_119247;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class all_bill_manu_2 extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.all_bill_menu_2);

        TextView waterbill;
        ImageButton home_page_2;
        waterbill = findViewById(R.id.c_water_bill_id);
        home_page_2 = findViewById( R.id.home_page2);
        home_page_2.setOnClickListener( view -> home_p_2());

        waterbill.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), calculate_bill_3.class);
                startActivity(i);
            }
        } );




    }

    private void home_p_2() {
        Intent home_i = new Intent(getApplicationContext(), all_bill_manu_2.class);
        startActivity(home_i);

    }
}
