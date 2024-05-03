package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast = findViewById(R.id.toast);
      /*  toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),R.string.app_name,Toast.LENGTH_LONG).show();
            }
        });
*/


        //customization of Toast

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast1 = new Toast(getApplicationContext());
                //comverting address or layout into view
                View view = getLayoutInflater().inflate(R.layout.customize_layout, (ViewGroup) findViewById(R.id.aa));
                toast1.setView(view);

            /*
            toast.setText();
            This is only used in default layout
            */

                TextView text = view.findViewById(R.id.text);
                text.setText("Message sent successfully");
                toast1.setDuration(Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);

                toast1.show();


            }
        });
    }
}