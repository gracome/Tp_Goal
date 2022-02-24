package com.farid.goaltp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ListingDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_details);

        TextView outputnom = findViewById(R.id.nom);
        TextView outputcibles = findViewById(R.id.cibles);
        TextView outputexercice = findViewById(R.id.exercice);
        TextView outputserie = findViewById(R.id.serie);
        TextView outputdetails = findViewById(R.id.details);

        //ImageView image = findViewById(R.id.imageView);

        String json = null;
        InputStream jsonFile = null;

        Intent intent = getIntent();
        int position = (int) intent.getExtras().get("position");

        try {
            jsonFile = getAssets().open("le_fitness.json");
            int size = jsonFile.available();
            byte[] buffer = new byte[size];
            jsonFile.read(buffer);
            jsonFile.close();
            json = new String(buffer, "UTF-8");
            JSONObject object = new JSONObject(json);

            outputnom.setVisibility(View.VISIBLE);
            outputcibles.setVisibility(View.VISIBLE);
            outputexercice.setVisibility(View.VISIBLE);
            outputserie.setVisibility(View.VISIBLE);
            outputdetails.setVisibility(View.VISIBLE);

            JSONArray childArray = object.getJSONArray("fit");
            for (int i = 0; i < childArray.length(); i++) {
                if (position == i){
                    outputnom.setText(childArray.getJSONObject(i).getString("nom"));
                    outputcibles.setText(childArray.getJSONObject(i).getString("cibles"));
                    outputexercice.setText(childArray.getJSONObject(i).getString("exercice"));
                    outputserie.setText(childArray.getJSONObject(i).getString("serie"));
                    outputdetails.setText(childArray.getJSONObject(i).getString("details"));
                    //Picasso.get().load(childArray.getJSONObject(i).getString("img")).into(image);
                }
                //Toast.makeText(this, ""+childArray.getJSONObject(i).getString("nom"), Toast.LENGTH_SHORT).show();
            }
            //outputnom.setText(json);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}