// -----------------------------------------------------------
//                EfficientAlgorithms.java
// -----------------------------------------------------------

public class EfficientAlgorithms {

    public static void main(String[] args) {
        long n = 100000;

        // --------------- Algorithm A --------------------

        long startTime1 = System.currentTimeMillis(), endTime1, duration1;
        long sum = 0;
        for ( long i = 1 ; i <= n ; i++ )
        {
        	sum = sum + i;
        }
        endTime1 = System.currentTimeMillis();
        duration1 = endTime1 - startTime1;
        System.out.println ( "Start = " + startTime1 + ", End = " + endTime1 );
        System.out.println ( "Sum = " + sum + ", total time = " + duration1 );


        // --------------- Algorithm B --------------------

        long startTime2 = System.currentTimeMillis(), endTime2, duration2;
        sum = 0;
        for ( long i = 1 ; i <= n ; i++ )
        {
        	for ( long j = 1 ; j <= i ; j++ )
        		sum++;
        }
        endTime2 = System.currentTimeMillis();
        duration2 = endTime2 - startTime2;
        System.out.println ( "\n\nStart = " + startTime2 + ", End = " + endTime2 );
        System.out.println ( "Sum = " + sum + ", total time = " + duration2 );


        // --------------- Algorithm C --------------------

        long startTime3 = System.currentTimeMillis(), endTime3, duration3;

        sum = n * ( n + 1 ) / 2;

        endTime3 = System.currentTimeMillis();
        duration3 = endTime3 - startTime3;
        System.out.println ( "\n\nStart = " + startTime3 + ", End = " + endTime3 );
        System.out.println ( "Sum = " + sum + ", total time = " + duration3 );


    }
}
