package com.example.calvinnoronha.clickcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String ARG_COUNT = "current_count";

    private TextView mCountText;
    private long mCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountText = findViewById(R.id.main_increment_button);
        mCountText.setOnClickListener(this);

        mCounter = savedInstanceState == null ? 0 : getSavedCount(savedInstanceState);
        setCount();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reset:
                mCounter = 0;
                setCount();
                break;

            case R.id.action_about:
                startActivity(new Intent(this, AboutActivity.class));
                break;
        }
        return true;
    }

    @Override
    public void onClick(@NonNull View v) {
        if (v.getId() != R.id.main_increment_button) return;
        mCounter += 1;
        setCount();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putLong(ARG_COUNT, mCounter);
        super.onSaveInstanceState(outState);
    }

    private long getSavedCount(@NonNull Bundle savedInstanceState) {
        return savedInstanceState.getLong(ARG_COUNT);
    }

    private void setCount() {
        String currentCount = mCounter == 0 ? getString(R.string.main_increment_text) : String.valueOf(mCounter);
        mCountText.setText(currentCount);
    }
}
