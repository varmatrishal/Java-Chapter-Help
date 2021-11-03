// -----------------------------------------------------------------
//                       PersonTest.java
// -----------------------------------------------------------------

public class PersonTest {

    public static void main(String[] args) {

    	//  Create Person objects
    	Person p1 = new Person ( "Stan", "Jones", 21, "123-45-6789" );
    	Person p2 = new Person ( "Stan", "Jones", 21, "222-45-6789" );
    	Person p3 = new Person ( "Sue",  "Baker", 22, "333-45-6789" );
    	Person p4 = new Person ( "Stan", "Smith", 21, "444-45-6789" );
    	Person p5;

    	System.out.println ( "p1 = " + p1 );
    	System.out.println ( "p2 = " + p2 );
    	System.out.println ( "p3 = " + p3 );
    	System.out.println ( "p4 = " + p4 + "\n\n" );

    	// ---------------------- Test the 'copy' constructor ---------------------
    	System.out.println ( "Testing the 'copy' constructor ------------------------------- " );
    	p5 = new Person ( p1 );
    	System.out.println ( "p5 = " + p5 );

    	System.out.println ( "Objects p5 and p1 should be equal" );			// Should be equal
    	if ( p1.equals ( p5 ) )
    		System.out.println ( "Objects p5 and p1 are equal\n" );
    	else
    		System.out.println ( "Objects p5 and p1 are not equal\n" );

    	System.out.println ( "Objects p5 and p2 should be equal" );			// Should be equal
    	if ( p2.equals ( p5 ) )
    		System.out.println ( "Objects p5 and p2 are equal\n" );
    	else
    		System.out.println ( "Objects p5 and p2 are not equal\n" );

    	System.out.println ( "Objects p5 and p3 should NOT be equal" );		// Should NOT be equal
    	if ( p3.equals ( p5 ) )
    		System.out.println ( "Objects p5 and p3 are equal\n" );
    	else
    		System.out.println ( "Objects p5 and p3 are NOT equal\n" );

    	// ---------------------- Test the 'clone' method ---------------------
    	System.out.println ( "Testing the 'clone' method ------------------------------- " );
    	p5 = p2.clone ( );
    	System.out.println ( "p5 = " + p5 );

    	System.out.println ( "Objects p5 and p2 should be equal" );			// Should be equal
    	if ( p2.equals ( p5 ) )
    		System.out.println ( "Objects p5 and p2 are equal\n" );
    	else
    		System.out.println ( "ERROR -- Objects p5 and p2 are not equal\n" );

    	System.out.println ( "Objects p5 and p1 should be equal" );			// Should be equal
    	if ( p1.equals ( p5 ) )
    		System.out.println ( "Objects p5 and p1 are equal\n" );
    	else
    		System.out.println ( "ERROR -- Objects p5 and p1 are not equal\n" );

    	System.out.println ( "Objects p5 and p3 should NOT be equal" );		// Should NOT be equal
    	if ( p3.equals ( p5 ) )
    		System.out.println ( "ERROR -- Objects p5 and p3 are equal\n" );
    	else
    		System.out.println ( "Objects p5 and p3 are NOT equal\n" );

    	// ---------------------- Test the 'compareTo' method ---------------------
    	System.out.println ( "Testing the 'compareTo' method ------------------------------- " );
		System.out.println ( "p1 and p2 = " + p1.compareTo ( p2 ));
		System.out.println ( "p3 and p1 = " + p3.compareTo ( p1 ));
		System.out.println ( "p4 and p1 = " + p4.compareTo ( p1 ));

    	// ---------------------- Test the 'hashCode' method ---------------------
    	System.out.println ( "Testing the 'hashCode' method ------------------------------- " );
    	System.out.println ( "------------- Testing Compatibility with 'equals' method ---------" );
		p5 = new Person ( p1 );

    	System.out.println ( "p1 and p5 hashCodes should be equal and objects should be equal" );
		if ( (p1.equals ( p5 )) && ( p1.hashCode() == p5.hashCode()) )
			System.out.println ( "hashCodes are equal and objects are equal\n" );
		else
			System.out.println ( "ERROR - hashCodes aren't equal or objects aren't equal\n" );

//		p5 = new Person ( p3 );
    	System.out.println ( "p3 and p5 hashCodes should NOT equal and objects should NOT be equal" );
		if ( !(p3.equals ( p5 )) && !( p3.hashCode() == p5.hashCode()) )
			System.out.println ( "hashCodes are unequal and objects are unequal\n" );
		else
			System.out.println ( "ERROR - hashCodes are equal or objects are equal\n" );

    	System.out.println ( "------------- Testing Compatibility with 'compareTo' method ---------" );
		p5 = new Person ( p1 );

    	System.out.println ( "p1 and p5 hashCodes should be equal and objects should be equal" );
		if ( (p1.compareTo ( p5 )==0 ) && ( p1.hashCode() == p5.hashCode()) )
			System.out.println ( "hashCodes are equal and objects are equal\n" );
		else
			System.out.println ( "ERROR - hashCodes aren't equal or objects aren't equal\n" );

		System.out.println ( "p3 and p1 hashCodes should NOT equal and objects should NOT be equal" );
		if ( ( p3.compareTo ( p1 ) < 0 ) && ( p3.hashCode() != p1.hashCode()) )
			System.out.println ( "hashCodes are unequal and p1 is less than p3\n" );
		else
			System.out.println ( "ERROR - hashCodes are equal or objects are equal\n" );
    }
}
