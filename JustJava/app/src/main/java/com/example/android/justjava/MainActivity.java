package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view){
        int price = calculatePrice();
        String priceMessage = "Total: $" + price + "\nThank you!";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    /**
    * This method displays the given text on the screen.
    */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view){
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view){
        if (quantity > 0){
            quantity = quantity - 1;
        }
        displayQuantity(quantity);
    }

    /**
     * Calculates the price of the order, assuming that each cup is $5.
     * @return the price of the order
     */
    private int calculatePrice() {
        return quantity * 5;
    }
}
