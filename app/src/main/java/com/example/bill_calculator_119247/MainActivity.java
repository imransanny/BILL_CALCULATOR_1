package com.example.bill_calculator_119247;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.welcode_page_1 );

        TextView select_language,welcome;
        ImageView select_lang_drop_down;
        final int[] lang_selected = {0};

        final Context[] context = new Context[1];
        final Resources[] resources = new Resources[1];



        select_language = findViewById(R.id.select_language);
        welcome = findViewById( R.id.welcome_id_1);
        select_lang_drop_down = findViewById(R.id.select_language_drop_down);

        select_language.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] Language= {"English","Bangla","Hindi"};

                final AlertDialog.Builder builder = new AlertDialog.Builder( MainActivity.this);
                builder.setTitle("Select A Language")
                        .setSingleChoiceItems( Language, lang_selected[0], new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                select_language.setText(Language[i]);

                                if(Language[i].equals("English")){
                                    context[0] = LocaleHelper.setLocale(MainActivity.this,"en");
                                    resources[0] = context[0].getResources();
                                    lang_selected[0] = 0;
                                    welcome.setText( resources[0].getString(R.string.welcome));
                                    setTitle( resources[0].getString(R.string.app_name));



                                }if(Language[i].equals("Bangla")){

                                    context[0] = LocaleHelper.setLocale(MainActivity.this,"bn");
                                    resources[0] = context[0].getResources();
                                    lang_selected[0] = 1;
                                    welcome.setText( resources[0].getString(R.string.welcome));
                                    setTitle( resources[0].getString(R.string.app_name));

                                }if(Language[i].equals("Hindi")){
                                    context[0] = LocaleHelper.setLocale(MainActivity.this,"hi");
                                    resources[0] = context[0].getResources();
                                    lang_selected[0] = 2;
                                    welcome.setText( resources[0].getString(R.string.welcome));
                                    setTitle( resources[0].getString(R.string.app_name));

                                }

                            }
                        } )
                        .setPositiveButton( "OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Intent intent = new Intent(getApplicationContext(), all_bill_manu_2.class);
                                startActivity(intent);

                            }

                        } );
                builder.create().show();








            }
        } );

    }
}