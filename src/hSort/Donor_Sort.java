package hSort;

/*
http://acm.epoka.edu.al:8888/en/problem-pid-c643
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Donor_Sort {



    // @param a an array of Comparable items.
    public static void heapsort( Donor [ ] a )
    {
        // buildHeap
        for( int i = (a.length-1) / 2; i >= 0; i-- )
        {
            //System.out.println("i="+i+",a.length="+a.length +" "+a[i].toString());
            adjust( a, i, a.length );
        }

        // Sort the array
        for( int i = a.length - 1; i > 0; i-- )
        {
            swapRef( a, 0, i );   /* Move Max to the end */
            adjust( a, 0, i );
        }
    }

    // @param i the index of an item in the heap.
    // @return the index of the left child.
    private static int leftChild( int i )
    {
        return 2 * i + 1;
    }

    // @param a an array of Comparable items.
    // @index i the position from which to percolate down.
    // @int n the logical size of the binary heap.
    private static void adjust( Donor [ ] a, int i, int n )
    {
        // i is the element to be percolated down (root position)
        // n is the size of the array
        int j = leftChild( i ); // child position
        Donor tmp = a[ i ];     // Take a copy of the root
        while( j < n )
        {
            if( j != n-1 && a[j].amount > a[j+1].amount)
            {
                j++;// if the right child is bigger
            }

            if( tmp.amount > a[ j ].amount ) {
                a[ i ] = a[ j ];
            }
            else break;
            i = j;
            j = leftChild( i );  // move one level down
        }
        // insert the root to the last parent position
        a[ i ] = tmp;
    }


    /* @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object. */
    public static void swapRef( Object [ ] a,  int ix1, int ix2 ) {
        Object tmp = a[ ix1 ];
        a[ ix1 ] = a[ ix2 ];
        a[ ix2 ] = tmp;
    }

    public static void main(final String[] args) throws FileNotFoundException
    {

        Scanner input = new Scanner(new FileReader("src/hSort/input2.txt"));
        int n=input.nextInt();
        int m=input.nextInt();


        Donor[] array;

        array = new Donor[n];

        for(int i=0; i<n; i++){
            String name=input.next();
            String surname=input.next();
            float amount=input.nextFloat();


            array[i]= new Donor(name,surname,amount);
        }

        System.out.println("Before sorting:");
        for(int i=0;i<n;i++)
            System.out.print(array[i].toString());

        heapsort(array);

        System.out.println("\nAfter sorting:");
        for(int i=0;i<n;i++)
            System.out.print(array[i].toString());

        System.out.println("\nResults:");
        for(int i=0 ; i<m;i++)
            System.out.print(array[i].toString());

        System.out.println();
    }

}

class Donor{
    String name;
    String surname;
    float amount;

    Donor(String n, String s, float a){
        name=n;
        surname=s;
        amount=a;
    }
    public String toString(){
        return name + " " + surname + " " + amount+ "\n";
    }
}
