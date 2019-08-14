package app;

import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");

        //static array
        /*int[] someArray = new int[5];
        System.out.println("Size of someArray " + someArray.length);
        for(int i=0;i<someArray.length;i++) 
        {
            someArray[i] = i;
        }
        for(int i=0;i<someArray.length;i++) 
        {
            System.out.print(someArray[i] + " ");
        }
        System.out.println(); */

        //dynamic array
        /*List<Integer> someVector = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            someVector.add(i);
        }
        someVector.remove(2);
        for(int i=0;i<someVector.size();i++) {
            System.out.print(someVector.get(i) + " ");
        }*/

        //running PivotIndex
        int[] PivotArray = {1,7,3,6,5,6};
        System.out.println(PivotIndex(PivotArray));
        int[] PivotArray2 = {1, 2, 3};
        System.out.println(PivotIndex(PivotArray2));
    }

    public static int PivotIndex(int[] someIndex) {
        int sum = 0;
        int rightsum;
        int leftsum;
        for(int i = 0; i < someIndex.length; i++) {
            sum = sum + someIndex[i];
        }
        rightsum = sum;
        leftsum = 0;
        for(int i = 0; i < someIndex.length; i++) {
            rightsum = rightsum - someIndex[i];
            leftsum = sum - someIndex[i] - rightsum;
            if(rightsum == leftsum) {
                return i;
            }
        }
        return -1;
        /*slow way
        int leftValue = 0;
        int rightValue = 0;
        for(int i = 1; i < someIndex.length; i++) {
            for(int j = 0; j < i; j++) {
                leftValue = leftValue + someIndex[j];
            }
            for(int k = i+1; k<someIndex.length; k++) {
                rightValue = rightValue + someIndex[k];
            }
            if(leftValue == rightValue) {
                return i;
            }
            leftValue = 0;
            rightValue = 0;
        }
        return -1; */
    }
}
