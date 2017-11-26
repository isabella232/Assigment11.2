package com.niketgoel.assigment112;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // declaring variables to process the xml view later
    AutoCompleteTextView autoCompleteTextView;
    TextView textView;
    ArrayList<String> productname;

    /**
     * onCreate method to add product item in ArrayList and to populate in a list.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);

        productname =new ArrayList<>();
        productname.add("Hp Inkjet Printer");
        productname.add("Google Pixel");
        productname.add("Apple Macbook Pro");
        productname.add("Hp Deskjet Printer");
        productname.add("One Plus 5");
        productname.add("Apple iPhone");

        Dbhandler dbhandler = new Dbhandler(this);

        for(int i = 0;i<productname.size();i++){
            dbhandler.Addproducts(productname.get(i));
        }



        ArrayList arrayList = dbhandler.Databasetoarray();

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocompletetextview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,arrayList);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);



    }
}
