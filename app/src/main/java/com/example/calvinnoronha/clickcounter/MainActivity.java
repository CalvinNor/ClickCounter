package com.example.calvinnoronha.clickcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View abcdView = findViewById(R.id.buttonClicker);
        abcdView.setOnClickListener(this);

    }

    public void onClick(View arg0) {

        //define a new Intent for the second Activity
        final TextView textViewToChange = (TextView) findViewById(R.id.countText);
        int count = Integer.parseInt(textViewToChange.getText().toString());
        count += 1;
        String newCount = Integer.toString(count);
        textViewToChange.setText(newCount);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            final TextView textViewToChange = (TextView) findViewById(R.id.countText);
            Toast.makeText(getApplicationContext(), "Counter is Reset", Toast.LENGTH_SHORT).show();
            textViewToChange.setText("0");
            return true;
        }
        else
        {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

    }
}