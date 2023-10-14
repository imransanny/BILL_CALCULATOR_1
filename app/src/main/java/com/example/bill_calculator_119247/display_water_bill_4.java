package com.example.bill_calculator_119247;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class display_water_bill_4  extends AppCompatActivity {

    TextView total_bill, total_unit ;
    ImageButton home_page_4;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.display_water_bill_4);

        total_bill = findViewById(R.id.total_bill_id_page4);
        total_unit = findViewById(R.id.total_unit_id_page4);
        home_page_4 = findViewById(R.id.home_page4);
        home_page_4.setOnClickListener( view -> home_p_4());

        Intent i = getIntent();
        String total_bill_recive = i.getStringExtra("total_bill_page3");
        String total_unit_recive = i.getStringExtra("total_unit_page3");



        System.out.println(total_bill_recive);
        System.out.println(total_unit_recive);

        total_bill.setText(total_bill_recive);
        total_unit.setText(total_unit_recive);

    }

    private void home_p_4() {

            Intent home_i = new Intent(getApplicationContext(), all_bill_manu_2.class);
            startActivity(home_i);


    }


}
