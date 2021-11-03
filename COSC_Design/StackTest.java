// -----------------------------------------------
//                    StackTest.java
// -----------------------------------------------

public class StackTest
{
	public static void main ( String [ ] args )
	{
		Person p1 = new Person ( 21, "Sally", "Jones",  "111-45-6789" );
		Person p2 = new Person ( 22, "Sarah", "Baker",  "222-45-6789" );
		Person p3 = new Person ( 23, "Hank ", "Smith",  "333-44-5555" );
		Person p4 = new Person ( 24, "Henry", "Jones",  "444-44-5555" );
		Person p5 = new Person ( 25, "Steve", "Baker",  "555-44-5555" );

		Stack s = new Stack ( );
		s.push ( p1 );
		s.push ( p2 );
		s.push ( p3 );
		s.push ( p4 );
		s.push ( p5 );

		System.out.println (   );
		System.out.println ( s );
		System.out.println (   );


		Stack t = new Stack ( s );

/**/
		if ( s.equals ( t ) )
			System.out.println ( "Stacks are equal" );
		else
			System.out.println ( "Stacks are not equal" );

		System.out.println ( "s.size = " + s.getSize() +
		               ", and t.size = " + t.getSize() );

		int stackSize = s.getSize();
		for ( int i = 0 ; i < stackSize ; i++ )
		{
			System.out.println ( "s = " + s.pop() + ", and t = " + t.pop() );
		}

		System.out.println ( "s.hashCode = " + s.hashCode() );
		System.out.println ( "t.hashCode = " + t.hashCode() );

		stackSize = s.getSize();
		for ( int i = 0 ; i < stackSize  ; i++ )
		{
			Person px = (Person)s.pop();
			System.out.println ( px );
		}
/**/

/*		Person px = (Person)s.pop ();
		px.setFirstName ( "BillyBob" );

		Person py = (Person)t.pop ();

		System.out.println ( "px = " + px + ", and py = " + py );
*/

		Stack x = (Stack) t.clone();
		if ( x.equals ( t ) )
			System.out.println ( "Stacks are equal" );
		else
			System.out.println ( "Stacks are not equal" );

		System.out.println ( "s.size = " + s.getSize() +
		               ", and t.size = " + t.getSize() );

		System.out.println (  );
		System.out.println (  );
		System.out.println (  );
	}
}
