package edu.orangecoastcollege.cs273.kfrederick5.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.NumberFormat;


public class PurchaseActivity extends Activity {

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioButton fourYears;
    private RadioButton fiveYears;

    Car newCar;

    private String monthlyPaymentText;
    private String loanSummaryText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        carPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        downPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        fourYears = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        fiveYears = (RadioButton) findViewById(R.id.fiveYearsRadioButton);

        newCar = new Car();
    }

    public void activateLoanReport(View view)
    {
        double price, downPayment;

        try{
            price = Double.parseDouble(carPriceEditText.getText().toString());
            downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        }
        catch (NumberFormatException e)
        {
            price = 0.0;
            downPayment = 0.0;
        }
        int loanTerm;

        if(fiveYears.isChecked())
            loanTerm = 5;
        else if(fourYears.isChecked())
            loanTerm = 4;
        else
            loanTerm = 3;

        newCar.setPrice(price);
        newCar.setDownPayment(downPayment);
        newCar.setLoanTerm(loanTerm);

        constructLoanSummaryText();

        // Create the Intent to share data with LoanSummaryActivity
        Intent loanSummaryIntent = new Intent(this, LoanSummaryActivity.class);
        loanSummaryIntent.putExtra("MonthlyPayment", monthlyPaymentText);
        loanSummaryIntent.putExtra("LoanSummary",loanSummaryText);

        //Start new activity
        startActivity(loanSummaryIntent);

    }

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
