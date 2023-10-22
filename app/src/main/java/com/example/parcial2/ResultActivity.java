package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    private final CalculateTotals totals = new CalculateTotals();
    private final DecimalFormat df = new DecimalFormat("$ #,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView netTotalText = findViewById(R.id.netTotal);
        TextView totalWithIVAText = findViewById(R.id.totalWithIVA);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        int quantity = extras.getInt("quantity");
        int unitPrice = extras.getInt("unitPrice");

        int netTotal = totals.calculateNetTotal(quantity, unitPrice);
        netTotalText.setText(df.format(netTotal));

        double totalWithIVA = totals.calculateTotalWithIVA(netTotal, 19);
        totalWithIVAText.setText(df.format(totalWithIVA));

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
