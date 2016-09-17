package edu.orangecoastcollege.cs273.kfrederick5.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.NumberFormat;

/**
 * Works with the user view that asks for user inputs and assigns those values to
 * variables that then calculate a loan summary for the car purchaser at the click of a button
 */
public class PurchaseActivity extends Activity {

    /**
     * Creates a currency format for double values that need such an assignment.
     */
    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    /**
     * Created variables to be hooked with their view counter parts.
     */
    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioButton fourYears;
    private RadioButton fiveYears;

    /**
     * Created a new car object.
     */
    Car newCar;

    /**
     * Created two string values used to pass loan information
     */
    private String monthlyPaymentText;
    private String loanSummaryText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        /**
         * Hooked the variables with the views in the View related doc.
         */
        carPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        downPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        fourYears = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        fiveYears = (RadioButton) findViewById(R.id.fiveYearsRadioButton);

        /**
         * Gave the car object default values.
         */
        newCar = new Car();
    }

    /**
     * Created an onClick action that will generate the loan report and perform calculations
     * when the corresponding button is pressed by the user.
     * @param view the button in the user View
     */
    public void activateLoanReport(View view)
    {
        /**
         * Created two variables to hold values while processing information.
         */
        double price, downPayment;

        /**
         * A try catch method that watches for user entered values that don't work with
         * the type required.
         */
        try{
            price = Double.parseDouble(carPriceEditText.getText().toString());
            downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        }
        catch (NumberFormatException e)
        {
            price = 0.0;
            downPayment = 0.0;
        }

        /**
         * Another variable to hold the years of the loan.
         */
        int loanTerm;

        /**
         * A series of if statements determining the years of the loan.
         */
        if(fiveYears.isChecked())
            loanTerm = 5;
        else if(fourYears.isChecked())
            loanTerm = 4;
        else
            loanTerm = 3;

        /**
         * Set the values of the car object.
         */
        newCar.setPrice(price);
        newCar.setDownPayment(downPayment);
        newCar.setLoanTerm(loanTerm);

        /**
         * A method used to pull together the text views.
         */
        constructLoanSummaryText();

        // Create the Intent to share data with LoanSummaryActivity
        Intent loanSummaryIntent = new Intent(this, LoanSummaryActivity.class);
        loanSummaryIntent.putExtra("MonthlyPayment", monthlyPaymentText);
        loanSummaryIntent.putExtra("LoanSummary",loanSummaryText);

        //Start new activity
        startActivity(loanSummaryIntent);

    }

    /**
     * A method that uses the car object to build the loan summary report fot the
     * buyer.
     */
    private void constructLoanSummaryText()
    {
        monthlyPaymentText = getString(R.string.report_line1) +
                currency.format(newCar.calculateMonthlyPayment());
        loanSummaryText = getString(R.string.report_line2) + currency.format(newCar.getPrice()) +
                getString(R.string.report_line3) + currency.format(newCar.getDownPayment()) +
                getString(R.string.report_line5) + currency.format(newCar.getTaxAmount()) +
                getString(R.string.report_line6) + currency.format(newCar.calculateTotalCost()) +
                getString(R.string.report_line7) + currency.format(newCar.getBorrowed()) +
                getString(R.string.report_line8) + currency.format(newCar.getInterestAmount()) +
                getString(R.string.report_line4) + " " + newCar.getLoanTerm() + " "
                + getString(R.string.years) +
                getString(R.string.report_line9) + getString(R.string.report_line10) +
                getString(R.string.report_line11) + getString(R.string.report_line12);

    }
}
