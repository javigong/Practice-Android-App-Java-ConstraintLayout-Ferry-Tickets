package com.example.ferrytickets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    double costPerTicketToCatalina = 34;
    double getCostPerTicketToLongBeach = 40;
    int numberOfTickets;
    double totalCost;
    String tripChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText tickets = findViewById(R.id.edTickets);
        Spinner destination = findViewById(R.id.spinnerDes);
        TextView result = findViewById(R.id.result);
        Button cost = findViewById(R.id.cost);

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    numberOfTickets = Integer.parseInt(tickets.getText().toString());
                } catch (NumberFormatException e) {
                    result.setText("Please enter the number of tickets you need!");
                    return;
                }

                NumberFormat currency = NumberFormat.getCurrencyInstance();

                tripChoice = destination.getSelectedItem().toString();
                if (destination.getSelectedItemPosition() == 0)
                    totalCost = costPerTicketToCatalina * numberOfTickets;
                else
                    totalCost = getCostPerTicketToLongBeach * numberOfTickets;

                result.setText("One Way Trip " + tripChoice + " for " + numberOfTickets + " passengers: " + currency.format(totalCost));
            }
        });

    }
}