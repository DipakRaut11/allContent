package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btnmsg, btnmail, btnshare, btndial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btndial = findViewById(R.id.btnDial);
        btnmail = findViewById(R.id.btmMail);
        btnmsg = findViewById(R.id.btnmsg);
        btnshare = findViewById(R.id.btnShare);

        btndial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent dialIntent = new Intent();
                dialIntent.setAction(Intent.ACTION_DIAL);*/
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel: 9823199861"));
                startActivity(dialIntent);
            }
        });
        btnmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.setType("message/rfc882");
                mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"abc@gmail.com", "xyz@gmail.com"});
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, "MEssage");
                mailIntent.putExtra(Intent.EXTRA_TEXT, "Please tell me how are you");
                startActivity(Intent.createChooser(mailIntent, "Email via mr. Dipak"));

            }
        });
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,"Visit this, https://chat.openai.com/");
                startActivity(Intent.createChooser(shareIntent, "SHarew by me"));

            }
        });
        btnmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msgIntent = new Intent();
                msgIntent.setAction(Intent.ACTION_SENDTO);
                msgIntent.setData(Uri.parse("smsto: "+Uri.encode("9823199861")));
                msgIntent.putExtra("sms_body", "Please help me");
                startActivity(msgIntent);
            }
        });
    }
}