package edu.orangecoastcollege.cs273.kfrederick5.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kfrederick5 on 9/13/2016.
 */



public class LoanSummaryActivity extends Activity {

    private TextView monthlyPaymentTextView;
    private TextView loanReportTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        monthlyPaymentTextView = (TextView) findViewById(R.id.monthlyPaymentTextView);
        loanReportTextView = (TextView) findViewById(R.id.loanReportTextView);

        Intent intentFromPurchaseActivity = getIntent();
        String monthlyPaymentText = intentFromPurchaseActivity.getStringExtra("MonthlyPayment");
        String loanPaymentText = intentFromPurchaseActivity.getStringExtra("LoanSummary");
        monthlyPaymentTextView.setText(monthlyPaymentText);
        loanReportTextView.setText(loanPaymentText);



    }

    public void returnToDataEntry(View view)
    {
        this.finish();
    }
}