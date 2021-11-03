/*
Program Name:       Bicycle Stand
Date:               June 20th 2018
Author:             Trishal Varma

Program Purpose:   Developing a program that calculates the rental charge for a bicycle rental
based on the number of days the bicycle is rented and the bicycle type


*/
package bicyclerentalstorepackage;

public class BicycleRentalStoreMainClass
{

    enum BICYCLE_TYPE_ENUM
    {
        STANDARD, RACER, MOUNTAIN, BMX, TANDEM
    }

    class DAILY_BICYCLE_RENTAL_RATES_CLASS
    {
        public static final double RENTAL_DAILY_FEE_STANDARD = 1.00;
        public static final double RENTAL_DAILY_FEE_RACER = 1.50;
        public static final double RENTAL_DAILY_FEE_MOUNTAIN = 1.79;
        public static final double RENTAL_DAILY_FEE_BMX = 1.89;
        public static final double RENTAL_DAILY_FEE_TANDEM = 4.20;
    }

    public static void main(String args[])
    {
        BicycleRentalClass bicycles[] = new BicycleRentalClass[5];

        bicycles[0] = new BicycleRentalStandardClass(1, BICYCLE_TYPE_ENUM.STANDARD);
        bicycles[1] = new BicycleRentalRacerClass(2, BICYCLE_TYPE_ENUM.RACER);
        bicycles[2] = new BicycleRentalMountainClass(3, BICYCLE_TYPE_ENUM.MOUNTAIN);
        bicycles[3] = new BicycleRentalBmxClass(4, BICYCLE_TYPE_ENUM.BMX);
        bicycles[4] = new BicycleRentalTandemClass (5, BICYCLE_TYPE_ENUM.TANDEM);

        for(BicycleRentalClass b : bicycles)
        {
            System.out.println("Bicyle Id: " + b.getBicycleId());
            System.out.println("Bicyle Type: " + b.getBicycleType());
            System.out.println("Rental Fee: " + b.getBicycleRentalFee());
            System.out.println("Rental fee for 4 days: " + b.calculateRentalFees(4));

            System.out.println();
        }
    }
}
