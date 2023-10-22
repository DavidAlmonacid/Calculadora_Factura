package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText quantityInput;
    private EditText unitPriceInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityInput = findViewById(R.id.quantity);
        unitPriceInput = findViewById(R.id.unitPrice);

        Button calculateButton = findViewById(R.id.calculateBtn);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sendData();
                } catch (NumberFormatException e) {
                    quantityInput.setError("Ingrese un número");
                    unitPriceInput.setError("Ingrese un número");
                }
            }
        });
    }

    public void sendData() {
        int quantity = Integer.parseInt(quantityInput.getText().toString());
        int unitPrice = Integer.parseInt(unitPriceInput.getText().toString());

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("quantity", quantity);
        intent.putExtra("unitPrice", unitPrice);
        startActivity(intent);
    }
}
