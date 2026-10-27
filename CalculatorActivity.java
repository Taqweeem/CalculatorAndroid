package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {

    private ResultFragment resultFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        resultFragment=(ResultFragment) getSupportFragmentManager().findFragmentById(R.id.resultFragment);

    }
    public void UpdateResult(String value) {
        if (resultFragment != null) {
            resultFragment.setResult(value);
        }
    }
}