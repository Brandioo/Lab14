package hSort;

/*
input.txt:

10

26 5 77 1 61 11 59 15 48 19

*/
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class Heap_Sort {




    // @param a an array of Comparable items.
    public static void heapsort( Node [ ] a )
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
    private static void adjust( Node [ ] a, int i, int n )
    {
        // i is the element to be percolated down (root position)
        // n is the size of the array
        int j = leftChild( i ); // child position
        Node tmp = a[ i ];     // Take a copy of the root
        while( j < n )
        {
            if( j != n-1 && a[j].num > a[j+1].num)
            {
                j++;// if the right child is bigger
            }

            if( tmp.num > a[ j ].num ) {
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

        Scanner input = new Scanner(new FileReader("src/hSort/input.txt"));
        int n=input.nextInt();

        Node[] array;

        array = new Node[n];

        for(int i=0; i<n; i++){
            int num=input.nextInt();

            array[i]= new Node(num);
        }

        System.out.println("Before sorting:");
        for(int i=0;i<n;i++)
            System.out.print(array[i].toString());

        heapsort(array);

        System.out.println("\nAfter sorting:");
        for(int i=0;i<n;i++)
            System.out.print(array[i].toString());

        System.out.println();
    }

}

class Node{
    int num;
    Node(int n){
        num=n;
    }
    public String toString(){
        return num + " ";
    }
}
