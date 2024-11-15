public class Tester
{
    public static void main( String args[] )
    {
        //the below line can be changed to test an ArrayListStack<Double>
        Stack<Double> stck = new ArrayListStack<Double>( );
        System.out.println( stck.size( ) ); //0
        stck.push(157.3);
        stck.push((double)22);
        stck.push((double)-18);
        double j = stck.pop( );
        System.out.println(j); // -18.0
        System.out.println( stck.peek( ) ); //22.0
        System.out.println( stck.pop( ) ); //22.0
        System.out.println( stck.size( ) ); //1
        stck.clear( );
        System.out.println( stck.size( ) ); //0
    }
}