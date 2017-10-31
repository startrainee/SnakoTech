package com.snakotech.snakotech.activity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.snakotech.snakotech.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
