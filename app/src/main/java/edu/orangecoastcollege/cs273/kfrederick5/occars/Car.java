package edu.orangecoastcollege.cs273.kfrederick5.occars;

/**
 * Created by kfrederick5 on 9/13/2016.
 *
 * Used to create car objects that hold the price of
 * a car and the loan prices and terms.
 */


public class Car {

    /**
     * Created variables to hold values for the down
     * payment, the loan term, the price, and the tax rate
     * for the car object.
     */
    private double mDownPayment;
    private int mLoanTerm;
    private double mPrice;
    public static final double TAX_RATE = .08;
    private double mInterestAmount;
    private double mTaxAmount;
    private double mBorrowed;


    public double getBorrowed() {
        return mBorrowed;
    }

    public double getInterestAmount() {
        return mInterestAmount;
    }

    public double getTaxAmount() {
        return mTaxAmount;
    }

    /**
     * returns the value of the down payment amount
     * @return double mDownPayment
     */
    public double getDownPayment() {
        return mDownPayment;
    }

    /**
     * Sets a value for the down payment given to
     * the car object.
     * @param downPayment double value given
     */
    public void setDownPayment(double downPayment) {
        mDownPayment = downPayment;
    }

    /**
     * returns the value of the loan term
     * @return
     */
    public int getLoanTerm() {
        return mLoanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        mLoanTerm = loanTerm;
        calculateTaxAmount();
        calculateBorrowedAmount();
        calculateInterestAmount();
        calculateMonthlyPayment();
        calculateTotalCost();
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double calculateBorrowedAmount(){
        mBorrowed = (mPrice + mTaxAmount) - mDownPayment;
        return mBorrowed;
    }

    public double calculateInterestAmount(){
        mInterestAmount = ((mLoanTerm == 3)? .0462: (mLoanTerm == 4)? .0416:
                .0419) * mBorrowed;
        return mInterestAmount;
    }

    public double calculateMonthlyPayment(){
        return (mBorrowed + mInterestAmount) / (mLoanTerm * 12.0);
    }

    public double calculateTaxAmount(){
        mTaxAmount = TAX_RATE*mPrice;
        return mTaxAmount;
    }

    public double calculateTotalCost(){
        return (mPrice - mDownPayment) + mTaxAmount;
    }


}
