package com.example.bill_calculator_119247;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class calculate_bill_3 extends AppCompatActivity {


    String[]  item={"Dhaka","CTG","Comilla","Syhlet"};
    String[]  item_catagory = { "Abashik","Commerial","Business"};

    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView1;
    ArrayAdapter<String> adapterItem;
    ArrayAdapter<String>adapterItem1;


    EditText enter_old_meter_readding, enter_new_meter_readding;

    TextView calculate_bill_id ;
    ImageButton home_page_3;


    double total_bill, dhaka_abashik = 15.18, dhaka_commerial=42.00,total_meter_reading;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.calculate_bill_3);


        autoCompleteTextView = findViewById(R.id.choose_you_area_id_test);
        autoCompleteTextView1 = findViewById(R.id.catagori_id_test);
        home_page_3=  findViewById( R.id.home_page3);

        enter_old_meter_readding = findViewById(R.id.enter_your_meter_reading_id);
        enter_new_meter_readding = findViewById( R.id.enter_your_New_meter_reading_id);
        calculate_bill_id = findViewById(R.id.calculate_bill_id);
        calculate_bill_id.setOnClickListener(view -> calculte());
        home_page_3.setOnClickListener( view -> home_p_3());


        adapterItem = new ArrayAdapter<String>(this, R.layout.dropdown, item);
        adapterItem1 = new ArrayAdapter<String>(this, R.layout.dropdown,item_catagory);



        autoCompleteTextView.setAdapter(adapterItem);
        autoCompleteTextView1.setAdapter(adapterItem1);

        autoCompleteTextView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  item = adapterView.getItemAtPosition(i).toString();
                System.out.println(item);
                Toast.makeText(calculate_bill_3.this, "Item" + item, Toast.LENGTH_SHORT).show();
            }
        } );

        autoCompleteTextView1.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item_catagory = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(calculate_bill_3.this, "Item_cat" + item_catagory, Toast.LENGTH_LONG).show();
            }
        } );



    }

    private void home_p_3() {
            Intent home_i = new Intent(getApplicationContext(), all_bill_manu_2.class);
            startActivity(home_i);
    }

    private void calculte() {
        String enteredMeterReading = enter_old_meter_readding.getText().toString().trim();

        double enteredMeterReading1 = 0; // default value

        try {
            enteredMeterReading1 = Double.parseDouble(enteredMeterReading);
        } catch (NumberFormatException e) {
            // Handle the case where the string isn't a valid double.
            // For example, show an error message to the user.
            Toast.makeText(this, "Please enter a valid meter reading.", Toast.LENGTH_SHORT).show();
            return; // Exit the method early.
        }
        System.out.println(enteredMeterReading);

        String enteredMeterReading1_NEW = enter_new_meter_readding.getText().toString().trim();
        double enteredMeterReading11_NEW = 0; // default value

        try {
            enteredMeterReading11_NEW = Double.parseDouble(enteredMeterReading1_NEW);
        } catch (NumberFormatException e) {
            // Handle the case where the string isn't a valid double.
            // For example, show an error message to the user.
            Toast.makeText(this, "Please enter a valid meter reading.", Toast.LENGTH_SHORT).show();
            return; // Exit the method early.
        }
        System.out.println(enteredMeterReading11_NEW);

        total_meter_reading = (enteredMeterReading11_NEW - enteredMeterReading1);




        String itemCategory = autoCompleteTextView.getText().toString();
        if (Arrays.asList(item).contains(itemCategory)) {
            System.out.println("Selected Category: itemCategory " + itemCategory);
        } else {
            System.out.println("something is wrong");
        }
        String selectedCategory = autoCompleteTextView1.getText().toString();

        if (Arrays.asList(item_catagory).contains(selectedCategory)) {
            System.out.println("Selected Category: selectedCategory " + selectedCategory);
        } else {
            System.out.println("something is wrong");
        }

        if(itemCategory.equals("Dhaka")){
            //System.out.println("YSS");

            if(selectedCategory.equals("Abashik")){
                total_bill =  dhaka_abashik *  (enteredMeterReading11_NEW - enteredMeterReading1);
                System.out.println(total_bill);

            }else if (selectedCategory.equals("Commerial")){
                total_bill =  dhaka_commerial *  (enteredMeterReading11_NEW - enteredMeterReading1);
                System.out.println(total_bill);
            }else if (selectedCategory.equals("Business")){
                total_bill =  dhaka_commerial *  (enteredMeterReading11_NEW - enteredMeterReading1);
                System.out.println(total_bill);
            }
        }

        Intent i = new Intent(getApplicationContext(), display_water_bill_4.class);

        i.putExtra("total_bill_page3", String.valueOf(total_bill));
        i.putExtra("total_unit_page3",String.valueOf(total_meter_reading));
        startActivity(i);
    }

}
