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


    /**
     * Returns the amount borrowed for the car
     * @return a Double of the amount borrowed
     */
    public double getBorrowed() {
        return mBorrowed;
    }

    /**
     * Returns the the total interest over the time of the loan
     * @return a Double of the interest on the loan
     */
    public double getInterestAmount() {
        return mInterestAmount;
    }

    /**
     * Returns the amount of tax applied to the sale
     * @return a Double of the tax amount
     */
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
     * @return an int of the years for the loan
     */
    public int getLoanTerm() {
        return mLoanTerm;
    }

    /**
     * Sets the int amount for the years on the loan and calls the calculation methods
     * and performs all the calculations for use in the programs processing phase.
     * @param loanTerm int value given by the radio button values
     */
    public void setLoanTerm(int loanTerm) {
        mLoanTerm = loanTerm;
        calculateTaxAmount();
        calculateBorrowedAmount();
        calculateInterestAmount();
        calculateMonthlyPayment();
        calculateTotalCost();
    }

    /**
     * Returns the price of the car.
     * @return a Double of the price of the car.
     */
    public double getPrice() {
        return mPrice;
    }

    /**
     * Sets the price of the car given by the user
     * @param price a Double that holds the price
     */
    public void setPrice(double price) {
        mPrice = price;
    }

    /**
     * Calculates the amount of money borrowed for the loan
     * @return Double of the borrowed amount
     */
    public double calculateBorrowedAmount(){
        mBorrowed = (mPrice + mTaxAmount) - mDownPayment;
        return mBorrowed;
    }

    /**
     * Calculates the total interest of the loan.
     * @return Double of the loan amount
     */
    public double calculateInterestAmount(){
        mInterestAmount = ((mLoanTerm == 3)? .0462: (mLoanTerm == 4)? .0416:
                .0419) * mBorrowed;
        return mInterestAmount;
    }

    /**
     * Calculates the monthly payments for the car.
     * @return Double for the car payment.
     */
    public double calculateMonthlyPayment(){
        return (mBorrowed + mInterestAmount) / (mLoanTerm * 12.0);
    }

    /**
     * Calculates the tax amount of the total price
     * @return Double for the tax amount
     */
    public double calculateTaxAmount(){
        mTaxAmount = TAX_RATE*mPrice;
        return mTaxAmount;
    }

    /**
     * Calculates the total cost for the car and loan
     * @return Double for the total cost
     */
    public double calculateTotalCost(){
        return (mPrice - mDownPayment) + mTaxAmount;
    }


}
