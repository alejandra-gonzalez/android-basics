package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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
    public void submitOrder(View view) {
        CheckBox topping1 = (CheckBox) findViewById(R.id.topping1_checkbox);
        boolean topping1State = topping1.isChecked();
        CheckBox topping2 = (CheckBox) findViewById(R.id.topping2_checkbox);
        boolean topping2State = topping2.isChecked();
        int price = calculatePrice();
        displayMessage(createOrderSummary(price, topping1State, topping2State));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
        }
        displayQuantity(quantity);
    }

    /**
     * Calculates the price of the order, assuming that each cup is $5.
     *
     * @return the price of the order
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Creates the order summary.
     *
     * @param price is the total for the order
     * @param topping1 is a boolean that stores whether the users wants topping1
     * @param topping2 is a boolean that stores whether the users wants topping2
     * @return A message containing the quantity and price
     */
    private String createOrderSummary(int price, boolean topping1, boolean topping2) {
        String orderSummary = "Name: Alex\nAdd whipped cream? ";
        orderSummary += yesAndNoForOrderSummary(topping1);
        orderSummary += "Add chocolate? ";
        orderSummary += yesAndNoForOrderSummary(topping2);
        orderSummary += "Quantity: " + quantity + "\nTotal: $" + price + "\nThank you!";
        return orderSummary;
    }

    /**
     * Optional method. This checks a boolean and adds Yes or No to the order summary.
     *
     * @param topping is the topping you want to check
     * @return Add topping or don't add topping
     */
    private String yesAndNoForOrderSummary(boolean topping) {
        if (topping) {
            return "Yes\n";
        }
        return "No\n";
    }
}
