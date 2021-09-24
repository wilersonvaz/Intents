package com.example.intents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextPrm;
    Button btnIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrm = (EditText) findViewById(R.id.editTextParametro);
        btnIT = (Button) findViewById(R.id.btnIntent);

        btnIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = editTextPrm.toString();
                if (!url.startsWith("http:" +"//") && !url.startsWith("https://")) url = "http://" + url;
                Log.v("URL", url);
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.main:
                Intent main=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(main);
                return true;
            case R.id.intent:
                Intent intent=new Intent(getApplicationContext(),Intent.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}