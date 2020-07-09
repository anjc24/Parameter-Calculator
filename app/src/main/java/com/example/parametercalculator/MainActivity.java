package com.example.parametercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] Shape= { "Square", "Circle" };

    public void clickFunction(View view){

        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        String SpinnerText = spinner.getSelectedItem().toString();

        EditText areaE = findViewById(R.id.areaEnter);
        Double aread = Double.parseDouble(areaE.getText().toString());

        // getting result and category text fields
        TextView sideText = (TextView)findViewById(R.id.sideText);
        TextView side = (TextView)findViewById(R.id.side);
        TextView areaText = (TextView)findViewById(R.id.areaText);
        TextView area= (TextView)findViewById(R.id.area);

        // converting into universal metrics
        if(SpinnerText == "Square"){
            sideText.setText("Radius of Circle :");
            areaText.setText("Area of Circle :");
            double radiusc = Math.sqrt(aread)/2;
            side.setText(String.format("%.2f" ,radiusc));
            double areac = radiusc*radiusc*3.14;
            area.setText(String.format("%.2f" ,areac));
        }
        else if(SpinnerText == "Circle"){
            sideText.setText("Side of Square :");
            areaText.setText("Area of Square :");
            double sides = Math.sqrt(aread/3.14)*2;
            side.setText(String.format("%.2f" ,sides));
            double areas = sides*sides;
            area.setText(String.format("%.2f" ,areas));
        }



//        Log.i("height", String.valueOf(height));
//        Log.i("weight", String.valueOf(weight));

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> wadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Shape);
        wadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(wadapter);

    }
}