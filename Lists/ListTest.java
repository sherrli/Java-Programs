/* Test file for functions in the List ADT.
 * main() runs its own test and also calls the other test methods.
 */


public class ListTest{

	public static void main(String[] args){

		// tests insertions of many Objects
		final int test_length = 1000;
		List<Integer> A = new List<Integer>();
		List<String> B = new List<String>();
		for(int i=1; i<test_length; i++){
			Integer t = new Integer(i);
			A.add(i, t);
		}
		for(int i=1; i<test_length/100; i++){
			B.add(i, "item"+(i+1));
		}
		System.out.println("Finished round one of testing");

		// test integrated and unit tests
		if( isEmptyTest() ){
			System.out.println("isEmptyTest() passed");
		}else{
			System.out.println("isEmptyTest() failed");
		}

		if( sizeTest() ){
			System.out.println("sizeTest() passed");
		}else{
			System.out.println("sizeTest() failed");
		}

		if( getTest() ){
			System.out.println("getTest() passed");
		}else{
			System.out.println("getTest() failed");
		}

		if( addTest() ){
			System.out.println("addTest() passed");
		}else{
			System.out.println("addTest() failed");
		}

		if( removeTest() ){
			System.out.println("removeTest() passed");
		}else{
			System.out.println("removeTest() failed");
		}

		if( removeAllTest() ){
			System.out.println("removeAllTest() passed");
		}else{
			System.out.println("removeAllTest() failed");
		}

		// toString and equals
		List<Integer> X = new List<Integer>();
		System.out.println(A.equals(B));
		List<Integer> Y = new List<Integer>();
		System.out.println(X.equals(A));
		System.out.println(X.equals(Y));

		X.add(1, new Integer(5));
		Y.add(1, new Integer(5));
		System.out.println(X.equals(Y));

		System.out.println(X);
	}

	public static boolean isEmptyTest(){
		boolean flag = true;
		List<List<String>> A = new List<List<String>>();	
		if( !A.isEmpty() ){ flag=false; }
		return flag;
	}

	public static boolean sizeTest(){
		boolean flag = true;
		List<List<Integer>> A = new List<List<Integer>>();
		if( A.size() != 0 ){ flag=false; }
		return flag;
	}

	public static boolean getTest(){
		boolean flag = true;
		List<String> F = new List<String>();
		System.out.println(F);
		// F.get(1) should throw exception since F is empty
		// if( F.get(1)!=null ){ flag=false; }
		F.add(1, "test");
		// compare two Strings
		if( !(F.get(1).equals("test")) ){ flag=false;}
		System.out.println(F.get(1));
		// if( F.get(1).equals("no") ){ flag=false; }
		// try invalid comparison
		// if( F.get(1) == 5 ){ flag=false; }
		return flag;
	}

	public static boolean addTest(){
		boolean flag = true;
		List<String> A = new List<String>();
		List<String> B = new List<String>();
		List<List<String>> C  = new List<List<String>>();
		A.add(1, "first");
		B.add(1, "second");
		C.add(1, A);
		C.add(2, B);
		if( A.isEmpty() || B.isEmpty() || C.isEmpty() ){ flag=false; }
		if( A.size()!=1 || B.size()!=1 || C.size()!=2 ){ flag=false; }
		return flag;
	}

	public static boolean removeTest(){
		boolean flag = true;
		List<Integer> D = new List<Integer>();
		// try removing from empty List
		try{
			D.remove(1);
			flag=false;
		}catch(ListIndexOutOfBoundsException e){
			System.out.println("Caught Exception in removeTest(): ");
			System.out.println(e);
		}
		D.add(1, new Integer(1));
		D.add(2, new Integer(2));
		Integer test = new Integer(2);
		D.remove(1);
		// check that indices and sizes are appropriately altered
		if( D.size()!=1 ){ flag=false; }
		if( D.get(1).intValue()!= test.intValue() ){ flag=false; }
		return flag;
	}

	public static boolean removeAllTest(){
		boolean flag = true;
		List<Integer> A = new List<Integer>();
		try{
			A.removeAll();
			// flag=false;
		}catch(ListIndexOutOfBoundsException e){
			System.out.println("Caught Exception in removeAllTest():");
			System.out.println(e);
		}
		A.add(1, new Integer(1));
		A.removeAll();
		if( A.size()!=0 ){ System.out.println(A.size()); flag=false; }
		A.add(1, new Integer(2));
		A.add(2, new Integer(3));
		A.removeAll();
		if( !A.isEmpty() ){ System.out.println(A.isEmpty()); flag=false; }
		return flag;
	}

}
