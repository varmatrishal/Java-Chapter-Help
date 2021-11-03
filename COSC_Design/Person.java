// ------------------------------------------------------
//                  Person.java
// ------------------------------------------------------
/**
 *	@version 4.0.1
 *  @author Stu Dent
 */


public class Person implements Comparable
{
	private StringBuffer firstName;
	private StringBuffer lastName;
	private int age;
	private StringBuffer ssn;
	private boolean disposeNotCalled;

	private static int population;
	
	public static final int LESS_THAN = -1;
	public static final int EQUAL = 0;
	public static final int GREATER_THAN = 1;

	//  Methods

	public void setFirstName ( String fn ) { firstName = new StringBuffer ( fn ); }
	public StringBuffer getFirstName ( ) { return new StringBuffer ( firstName.toString()); }
	public void setLastName ( String ln ) { lastName = new StringBuffer ( ln ); }
	public StringBuffer getLastName ( ) { return new StringBuffer ( lastName.toString()); }
	public void setAge ( int age ) { this.age = age; }
	public int 	getAge ( ) { return age; }
	public void setSsn ( String s ) { ssn = new StringBuffer ( s ); }
	public StringBuffer getSsn ( ) { return new StringBuffer ( ssn.toString()); }
	public static int getPopulation ( ) { return population; }

	/**
	 *
	 */
	public Person ( ) {
		this ( " ", " ", 0, " " );
		System.out.println ( "Person - default constructor" );
	}

	/**
	 *	@param fn Person's first name
	 *  @param ln Person's last name
	 *  @param age Person's age
	 *  @param s Person's social security number
	 */
	public Person ( String fn, String ln, int age, String s ) {
		firstName = new StringBuffer ( fn );
		lastName  = new StringBuffer ( ln );
		this.age = age;
		ssn = new StringBuffer ( s );
		population++;
		disposeNotCalled = true;
//		System.out.println ( "Person - overloaded constructor" );
	}


	/**
	 *	@param original - The Person object to be copied
	 *  @throws NullPointerException
	 */
	public Person ( Person original ) throws NullPointerException
	{
		if ( original == null ) throw new NullPointerException();

		firstName = new StringBuffer ( original.firstName.toString() );
		lastName  = new StringBuffer ( original.lastName.toString() );
		this.age = original.age;
		ssn = new StringBuffer ( "999-99-9999" );
		population++;
		disposeNotCalled = true;
//		System.out.println ( "Person - copy constructor" );
	}


    protected Person clone()  // throws CloneNotSupportedException
    {
    	// throw new CloneNotSupportedException();
    	return new Person ( this );
    }

	static {
		population = 0;
	}

	public String toString( ) {
		String x = " " + firstName + " " + lastName + " " + age + " " + ssn + " " + population;
		return x;
	}

	public boolean equals( Object obj )
	{
		if ( this == obj ) return true;

		if ( ( obj != null ) && ( getClass( ) == obj.getClass( ) ) )
		{
			Person d = ( Person ) obj;

			if ( ( firstName.toString().equals ( d.firstName.toString() ) ) &&
			     ( lastName. toString().equals ( d.lastName. toString() ) ) &&
			     ( age == d.age ) )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	/**
	 *		Compares this object with the specified object for order.
	 *		Returns a negative integer, zero, or a positive integer as
	 *		this object is less than, equal to, or greater than the specified object.
	 *		Don't compare Social Security Numbers for consistency with 'equals' method
	 *
	 *		@param obj - the object to be compared
	 *		@throws - NullPointerException - if null argument provided
	 *		@throws - ClassCastException - if objects are not of the same type
	 */
	public int compareTo ( Object obj )
	{
		int firstNames = 0, lastNames = 0, ages = 0;  //  Comparison Results

		if ( this == obj ) return 0;							// The same object is equal
		if ( obj == null ) throw new NullPointerException ( );	// Null argument
		if ( getClass( ) != obj.getClass( ) ) throw new ClassCastException ();

		Person d = ( Person ) obj;

		//  --------------- Get instance variable relationships ---------------------
		firstNames = ( firstName.toString().compareTo ( d.firstName.toString()) );
		lastNames  = ( lastName. toString().compareTo ( d.lastName. toString()) );
		if ( firstNames > 0 ) firstNames =  1;
		if ( firstNames < 0 ) firstNames = -1;
		if ( lastNames  > 0 ) lastNames  =  1;
		if ( lastNames  < 0 ) lastNames  = -1;
		if ( age  < d.age ) ages = -1;			// Less than
		if ( age == d.age ) ages =  0;			// Equal
		if ( age  > d.age ) ages =  1;			// Greater than
		System.out.println ( "fn = " + firstNames + ", ln = " + lastNames + ", ages = " + ages );

		if ( ( firstNames == lastNames ) && ( firstNames == ages )) 
			return firstNames;

		switch ( lastNames ) {
			case LESS_THAN: 
				return LESS_THAN; 
			case EQUAL:
				switch ( firstNames ) {
					case LESS_THAN:
						return LESS_THAN;
					case EQUAL:
						if ( age == d.age )  return EQUAL;
						if ( age <  d.age )  return LESS_THAN;
						if ( age >  d.age )  return GREATER_THAN;
						break;
					case GREATER_THAN:
						return GREATER_THAN;
				}
			case GREATER_THAN:
				return GREATER_THAN;
			default:
//				System.out.println ( "Shouldn't get here!" );
				return 0;
		}
	}

	public int hashCode ( )
	{
		// Using Joshua Bloch's recipe for hashCode

		int result = 17;

		result = 37 * result + firstName.toString().hashCode(); // StringBuffer has no hashCode method
		result = 37 * result + lastName.toString().hashCode();
		result = 37 * result + age;
//		result = 37 * result + ssn.toString().hashCode();		// Be consistent with the equals method
		result = 37 * result + ( disposeNotCalled ? 0 : 1 );
		return result;
	}

	public void finalize ( ) {
		if ( disposeNotCalled ) {
			population--;
		}
		System.out.println ( "Person - finalize method" );
	}

	public void dispose ( ) {
		population--;
		disposeNotCalled = false;
		System.out.println ( "Person - dispose method" );
	}
}

