package edu.orangecoastcollege.cs273.kfrederick5.occars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PurchaseActivity extends AppCompatActivity {

    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioButton threeYears;
    private RadioButton fourYears;
    private RadioButton fiveYears;
    private Button loanReport;
    private RadioGroup loanTerm;

    Car newCar = new Car();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        carPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        downPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        threeYears = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        fourYears = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        fiveYears = (RadioButton) findViewById(R.id.fiveYearsRadioButton);
        loanReport =  (Button) findViewById(R.id.loanReportButton);
        loanTerm = (RadioGroup) findViewById(R.id.loanTermRadioGroup);

        carPriceEditText.addTextChangedListener(priceTextChangedListener);

        downPaymentEditText.addTextChangedListener(downPaymentTextChangedListener);

        loanTerm.setOnCheckedChangeListener(loanTermChangedListener);

    }

    private TextWatcher priceTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher downPaymentTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private RadioGroup.OnCheckedChangeListener loanTermChangedListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

        }
    };
}
