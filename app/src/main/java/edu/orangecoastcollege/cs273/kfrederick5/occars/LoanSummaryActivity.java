package edu.orangecoastcollege.cs273.kfrederick5.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kfrederick5 on 9/13/2016.
 */


/**
 * This activity processes and shows the loan information based on the users input
 * in the purchase activity doc.
 */
public class LoanSummaryActivity extends Activity {

    /**
     * Created to objects to hold two text values passed by the purchase activity.
     */
    private TextView monthlyPaymentTextView;
    private TextView loanReportTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        /**
         * Hooked the text views on the activity_loan_summary page with the text variables.
         */
        monthlyPaymentTextView = (TextView) findViewById(R.id.monthlyPaymentTextView);
        loanReportTextView = (TextView) findViewById(R.id.loanReportTextView);

        /**
         * Calls the intent from purchase activity.
         */
        Intent intentFromPurchaseActivity = getIntent();

        /**
         * Assigns the text variables with values.
         */
        String monthlyPaymentText = intentFromPurchaseActivity.getStringExtra("MonthlyPayment");
        String loanPaymentText = intentFromPurchaseActivity.getStringExtra("LoanSummary");

        /**
         * Sets the text views with the variable values.
         */
        monthlyPaymentTextView.setText(monthlyPaymentText);
        loanReportTextView.setText(loanPaymentText);



    }

    /**
     * onClick action to return the user to the previous activity.
     * @param view calls for the view button this action is linked to.
     */
    public void returnToDataEntry(View view)
    {
        this.finish();
    }
}