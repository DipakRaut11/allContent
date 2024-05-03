package com.example.dynamicappeg;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        // Initialize AndroidNetworking
        AndroidNetworking.initialize(getApplicationContext());

        String url = "https://jsonplaceholder.typicode.com/users"; // GET
        ArrayList<String > arrName = new ArrayList<>();

        AndroidNetworking.initialize(this);
        AndroidNetworking.get(url).build().getAsJSONArray(new JSONArrayRequestListener() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("Res", response.toString());
                try {

                    for (int i = 0;i<response.length();i++) {
                        JSONObject objResult = response.getJSONObject(i);
                        String name = objResult.getString("name");
                        String username = objResult.getString("username");

                        arrName.add(name+", "+username);


                        ArrayAdapter<String > arrAdapter = new ArrayAdapter<String >(MainActivity.this, android.R.layout.simple_list_item_1,arrName);
                        listView.setAdapter(arrAdapter);
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onError(ANError anError) {
                anError.printStackTrace();
                Log.e("Error",anError.toString());
            }
        });
    }
}
