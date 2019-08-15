package app;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        int[] PivotArray = {1,7,3,6,5,6};
        System.out.println(PivotIndex(PivotArray));
        int[] PivotArray2 = {1, 2, 3};
        System.out.println(PivotIndex(PivotArray2));
    }

    public static int PivotIndex(int[] someIndex) {
        //faster way
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

    public static int largestNumberTwice(int[] someArray) {
        int largestNumber = 0;
        int secondLargestNumber = -1;
        int largestNumberPosition = -1;
        for(int i = 0; i < someArray.length; i++) {
            if(someArray[i] > largestNumber) {
                secondLargestNumber = largestNumber;
                largestNumber = someArray[i];
                largestNumberPosition = i;
            }
            if(someArray[i] < largestNumber && someArray[i] > secondLargestNumber) {
                secondLargestNumber = someArray[i];
            }
        }
        if(largestNumber >= secondLargestNumber*2) {
            return largestNumberPosition;
        }
        return -1;
    }

    public static int[] PlusOne(int[] someArray) {
        for(int i = someArray.length-1; i >= 0; i--) {
            if(someArray[i] < 9) {
                someArray[i] = someArray[i] + 1;
                return someArray;
            } else {
                someArray[i] = 0;
            }
        }
        int[] arrayMoreDigits = new int[someArray.length + 1];
        arrayMoreDigits[0] = 1;
        return arrayMoreDigits;
    }

    public static int[] findDiagonalOrder(int[][] someMatrix) {
        int x = 0;
        int y = 0;
        boolean upDirection = true;
        boolean edge = true;
        int[] orderValues = new int[someMatrix.length*someMatrix[0].length];
        int orderPosition = 0;
        if(orderValues.length != 0) {
            orderValues[orderPosition] = someMatrix[x][y];
            orderPosition++;
        }
        while(orderPosition < orderValues.length) {
            if(x == someMatrix.length-1 && edge == true) {
                y++;
                upDirection = true;
                edge = false;
            } else if(y == someMatrix[0].length-1 && edge == true) {
                x++;
                upDirection = false;
                edge = false;
            } else if(x == 0 && edge == true) {
                y++;
                upDirection = false;
                edge = false;
            } else if(y == 0 && edge == true) {
                x++;
                upDirection = true;
                edge = false;
            } else if(upDirection) {
                x--;
                y++;
                if(x==0 || y==0 || x == someMatrix.length-1 || y == someMatrix[0].length-1) {
                    edge = true;
                }
            } else if(!upDirection) {
                x++;
                y--;
                if(x==0 || y==0 || x == someMatrix.length-1 || y == someMatrix[0].length-1) {
                    edge = true;
                }
            }
            orderValues[orderPosition] = someMatrix[x][y];
            orderPosition++;
        }
        return orderValues;
    }
}
