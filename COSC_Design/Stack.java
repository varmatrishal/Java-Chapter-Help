// ----------------------------------------------------------------------
//                             Stack.java
// ----------------------------------------------------------------------

/**
    The <code> Stack </code> class represents a company person.

    @author Stu Dent
    @version 1.1

    @see StackTest
*/
public class Stack
{
	private Object elements [ ];	//  An array of stack elements
	private int size = 0;			//  Initial size

	/**
		The default, no argument, Stack constructor method
				The stack's initial size will be defaulted to one.
		@param none
	*/
	public Stack ( )
	{
		this ( 1 );  			// Default size = 1.
		System.out.println ( "Stack - default constructor" );
	}


	/**
		The one argument, overloaded, Stack constructor method

	    @param initialCapacity - Stack's size ( int )
	*/
	public Stack ( int initialCapacity )
	{
		elements = new Object [ initialCapacity ];
		System.out.println ( "Stack - 1-Arg constructor" );
	}

	/**
		The 'copy' constructor for the Stack class.  Returns a 'near'
		duplicate of the 'current' Stack object.

	    @param - Reference variable of the Stack class
	    @throws 	NullPointerException - cannot create 'copy' from 'null' object.
	*/
	public Stack ( Stack original ) throws NullPointerException
	{
		if ( original == null )
		{
			System.out.println ( "Stack - copy constructor, null reference" );
			throw new NullPointerException ( );
		}
		else
		{
			elements = new Object [ 2 * original.elements.length + 1 ];
			System.arraycopy ( original.elements, 0, elements, 0, original.size );
			size = original.size;
		}
		System.out.println ( "Stack - copy constructor" );
	}

	/**
	    @param none
	*/
	public Object clone ( )
	{
		return new Stack ( this );
	}

	/**
		The accessor method for the Stack object's age instance variable.

	    @param none
	    @return Returns the Stack's age
	*/
	public int  getSize ( ) { return size; }

	public void push ( Object e )
	{
		ensureCapacity ( );
		elements [ size++ ] = e;
	}

	public Object pop ( )
	{
		if ( size == 0 )
		{
			//throw new EmptyStackException ( );
			System.out.println ( "EmptyStackException" );
		}

		Object result = elements [ --size ];
		elements [ size ] = null;				// Eliminate obsolete reference
		return result;
	}

	private void ensureCapacity ( )
	{
		if ( elements.length == size )
		{
			Object oldElements [ ] = elements;
			elements = new Object [ 2 * oldElements.length + 1 ];
			System.arraycopy ( oldElements, 0, elements, 0, size );
		}
	}

	/**
		The toString method generates a string equivalent of the object's instance
		and class data for use in a String context.

	    @param none
	    @return Returns a string image of the object's instance and class data
	    		"firstName lastName age ssn population"
	*/
	public String toString()
	{
		String s;
		s =  size + " ";
		for ( int i = 0 ; i < size ; i++ )
		{
			s += elements [ i ].toString() + "\n";
		}
		return s;
	}

	/**
		The 'equals' method provides a mechanism for comparing two objects of the Stack class.

	    @param 		A reference variable of the 'Object' class with a reference to a Stack object
	*/
	public boolean equals ( Object obj )
	{
		if ( this == obj ) return true;

		if ( ( obj != null ) && ( getClass( ) == obj.getClass( ) ) )
		{
			Stack d = ( Stack ) obj;

			if ( size != d.size) return false;

			for ( int i = 0 ; i < size ; i++ )
			{
				if ( ! elements [ i ].equals ( d.elements [ i ] ) )	return false;
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
		The 'hashCode' method is based on the implementation found in
		Joshua Block's "Effective Jave - Programming Language Guide"

		@param - none
		@return  Returns the hash code (int) of this object.
	*/
	public int hashCode ( )
	{
		int result = 17;								// Arbitrary and prime

		result = 37 * result + size;			  		//  '37' chosen because it's prime
		for ( int i = 0 ; i < size ; i++ )
		{
			result = 37 * result + elements[i].hashCode();
		}
		return result;
	}

	/**
		The 'finalize' method provides an 'automatic' mechanism for bracketing
		operations as the object is being reclaimed during 'Garbage Collection'.

	    @param none
	*/
	public void finalize ( )
	{
		System.out.println ( "Stack - finalize method" );
	}

	/**
		Provides a mechanism for an 'implicit' bracketing operations as the
		object is being reclaimed during 'Garbage Collection'.

	    @param none
	*/
	public void dispose ( )
	{
		System.out.println ( "Stack - dispose method" );
	}

} // End of Stack Class