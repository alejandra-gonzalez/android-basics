package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int orderNumber = 0;

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

        EditText orderNameEditText = (EditText) findViewById(R.id.orderName);
        String orderName = nameHandling(orderNameEditText.getText().toString());

        int price = calculatePrice(topping1State, topping2State);
        String orderSummary = createOrderSummary(price, topping1State, topping2State, orderName);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order for " +orderName);
        intent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "You cannot order more than 100 cups of coffee.", Toast.LENGTH_SHORT).show();
        }
        else {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You must order at least 1 cup of coffee.", Toast.LENGTH_SHORT).show();
        }
        else {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    /**
     * Calculates the price of the order, assuming that each cup is $5.
     *
     * @param topping1 stores whether user wants topping 1 or not
     * @param topping2 stores whether user wants topping 2 or not
     * @return the price of the order
     */
    private int calculatePrice(boolean topping1, boolean topping2) {
        int price = 5;
        if (topping1) {
            price += 1;
        }
        if (topping2) {
            price += 2;
        }
        return quantity * price;
    }

    /**
     * Creates the order summary.
     *
     * @param price     is the total for the order
     * @param topping1  is a boolean that stores whether the users wants topping1
     * @param topping2  is a boolean that stores whether the users wants topping2
     * @param orderName is a String containing the name for the order
     * @return A message containing the quantity and price
     */
    private String createOrderSummary(int price, boolean topping1, boolean topping2,
                                      String orderName) {
        String orderSummary = orderName + "\nAdd whipped cream? ";
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

    /**
     * Optional method. This method gives an order number to the order summary if no name is
     * provided.
     *
     * @param name for the order
     * @return String with order number or order name
     */
    private String nameHandling(String name) {
        if (name.length() == 0 || name.trim().length() == 0) {
            orderNumber += 1;
            return "Order Number " + orderNumber;
        }
        return "Name: " + name;
    }
}
