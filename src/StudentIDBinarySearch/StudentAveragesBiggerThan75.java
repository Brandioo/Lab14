//Brand BINF-A
package StudentIDBinarySearch;


import java.util.Scanner;

public class StudentAveragesBiggerThan75 {
    static class Student {
        int id;
        int sch;

        public Student(int id, int sch) {
            this.id = id;
            this.sch = sch;
        }

        public Student() {
        }

        public String toString() {
            return id + " " + sch + "\n";
        }
    }

    // @param a an array of Comparable items.
    public static void heapsort(Student[] a) {
        // buildHeap
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            //System.out.println("i="+i+",a.length="+a.length +" "+a[i].toString());
            adjust(a, i, a.length);
        }

        // Sort the array
        for (int i = a.length - 1; i > 0; i--) {
            swapRef(a, 0, i);   /* Move Max to the end */
            adjust(a, 0, i);
        }
    }

    // @param i the index of an item in the heap.
    // @return the index of the left child.
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    // @param a an array of Comparable items.
    // @index i the position from which to percolate down.
    // @int n the logical size of the binary heap.
    private static void adjust(Student[] a, int i, int n) {
        // i is the element to be percolated down (root position)
        // n is the size of the array
        int j = leftChild(i); // child position
        Student tmp = a[i];     // Take a copy of the root
        while (j < n) {
            if (j != n - 1 && a[j].id > a[j + 1].id) {
                j++;// if the right child is bigger
            }

            if (tmp.id > a[j].id) {
                a[i] = a[j];
            } else break;
            i = j;
            j = leftChild(i);  // move one level down
        }
        // insert the root to the last parent position
        a[i] = tmp;
    }


    /* @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object. */
    public static void swapRef(Object[] a, int ix1, int ix2) {
        Object tmp = a[ix1];
        a[ix1] = a[ix2];
        a[ix2] = tmp;
    }

    static int bSearch(Student arr[], int id) {
        int r = arr.length - 1, l = 0, c;
        while (l <= r) {
            c = (l + r) / 2;
            if (arr[c].id < id) {
                l = c + 1;
            } else if (arr[c].id > id) {
                r = c - 1;
            } else {
                return arr[c].sch;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        Student[] arr = new Student[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Student();
            arr[i].id = input.nextInt();
            arr[i].sch = input.nextInt();
        }
        heapsort(arr);


        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int id;
            int sch;
            id = input.nextInt();
            sch = bSearch(arr, id);
            if (sch >= 75) {
                cnt++;
            }
        }


        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
