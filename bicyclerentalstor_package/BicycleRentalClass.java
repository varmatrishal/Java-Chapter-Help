/*
Program Name:       Bicycle Stand
Date:               June 20th 2018
Author:             Trishal Varma

Program Purpose:   Developing a program that calculates the rental charge for a bicycle rental
based on the number of days the bicycle is rented and the bicycle type


*/


package bicyclerentalstorepackage;

import bicyclerentalstorepackage.BicycleRentalStoreMainClass.BICYCLE_TYPE_ENUM;
import bicyclerentalstorepackage.BicycleRentalStoreMainClass.DAILY_BICYCLE_RENTAL_RATES_CLASS;

public abstract class BicycleRentalClass
{
    private int bicycleId;
    private BICYCLE_TYPE_ENUM bicycleType;
    private double bicycleRentalFee;

    public BicycleRentalClass(int bicycleId, BICYCLE_TYPE_ENUM bicycleType, double bicycleRentalFee)
    {
        this.bicycleId = bicycleId;
        this.bicycleType = bicycleType;
        this.bicycleRentalFee = bicycleRentalFee;
    }

    public int getBicycleId()
    {
        return bicycleId;
    }

    public void setBicycleId(int bicycleId)
    {
        this.bicycleId = bicycleId;
    }

    public BICYCLE_TYPE_ENUM getBicycleType()
    {
        return bicycleType;
    }

    public void setBicycleType(BICYCLE_TYPE_ENUM bicycleType)
    {
        this.bicycleType = bicycleType;
    }

    public double getBicycleRentalFee()
    {
        return bicycleRentalFee;
    }

    public void setBicycleRentalFee(double bicycleRentalFee)
    {
        this.bicycleRentalFee = bicycleRentalFee;
    }

    public abstract double calculateRentalFees(int daysToRent);

    public boolean equals(BicycleRentalClass other)
    {
        return bicycleId == other.getBicycleId();
    }
}


class BicycleRentalStandardClass extends BicycleRentalClass
{

    public BicycleRentalStandardClass(int bicycleId, BICYCLE_TYPE_ENUM bicycleType)
    {
        super(bicycleId, bicycleType, DAILY_BICYCLE_RENTAL_RATES_CLASS.RENTAL_DAILY_FEE_STANDARD);
    }

    @Override
    public double calculateRentalFees(int daysToRent)
    {
        return daysToRent * getBicycleRentalFee();
    }
}


class BicycleRentalRacerClass extends BicycleRentalClass
{

    public BicycleRentalRacerClass(int bicycleId, BICYCLE_TYPE_ENUM bicycleType)
    {
        super(bicycleId, bicycleType, DAILY_BICYCLE_RENTAL_RATES_CLASS.RENTAL_DAILY_FEE_RACER);
    }

    @Override
    public double calculateRentalFees(int daysToRent)
    {
        return daysToRent * getBicycleRentalFee();
    }
}
class BicycleRentalMountainClass extends BicycleRentalClass
{

    public BicycleRentalMountainClass(int bicycleId, BICYCLE_TYPE_ENUM bicycleType)
    {
        super(bicycleId, bicycleType, DAILY_BICYCLE_RENTAL_RATES_CLASS.RENTAL_DAILY_FEE_MOUNTAIN);
    }

    @Override
    public double calculateRentalFees(int daysToRent)
    {
        return daysToRent * getBicycleRentalFee();
    }
}
class BicycleRentalBmxClass extends BicycleRentalClass
{

    public BicycleRentalBmxClass(int bicycleId, BICYCLE_TYPE_ENUM bicycleType)
    {
        super(bicycleId, bicycleType, DAILY_BICYCLE_RENTAL_RATES_CLASS.RENTAL_DAILY_FEE_BMX);
    }

    @Override
    public double calculateRentalFees(int daysToRent)
    {
        return daysToRent * getBicycleRentalFee();
    }
}
class BicycleRentalTandemClass extends BicycleRentalClass
{

    public BicycleRentalTandemClass(int bicycleId, BICYCLE_TYPE_ENUM bicycleType)
    {
        super(bicycleId, bicycleType, DAILY_BICYCLE_RENTAL_RATES_CLASS.RENTAL_DAILY_FEE_TANDEM);
    }

    @Override
    public double calculateRentalFees(int daysToRent)
    {
        return daysToRent * getBicycleRentalFee();
    }
}