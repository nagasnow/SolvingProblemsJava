package app;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        int[] PivotArray = {1,7,3,6,5,6};
        System.out.println(PivotIndex(PivotArray));
        int[] PivotArray2 = {1, 2, 3};
        System.out.println(PivotIndex(PivotArray2));
        int[][] spiralMatrix = {{1,2,3},{4,5,6},{7,8,9}};
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
        
        if(someMatrix.length == 0) {
            return new int[0];
        }
        
        if(someMatrix.length == 1) {
            return someMatrix[0];
        }
        
        if(someMatrix[0].length == 1) {
            int[] resultMatrix = new int[someMatrix.length];
            for(int i = 0; i < someMatrix.length; i++) {
                resultMatrix[i] = someMatrix[i][0];
            }
            return resultMatrix;
        }
        
        int[] orderValues = new int[someMatrix.length*someMatrix[0].length];
        int orderPosition = 0;
        orderValues[orderPosition] = someMatrix[x][y];
        orderPosition++;
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

    public List<Integer> spiralOrder(int[][] someMatrix) {
        List<Integer> results = new ArrayList<>();
        
        if(someMatrix.length == 0) {
            return results;
        }
        
        if(someMatrix.length == 1) {
            for(int i = 0; i < someMatrix[0].length; i++) {
                results.add(someMatrix[0][i]);
            }
            return results;
        }
        
        if(someMatrix[0].length == 1) {
            for(int i = 0; i < someMatrix.length; i++) {
                results.add(someMatrix[i][0]);
            }
            return results;
        }
        
        int x = 0;
        int y = 0;
        boolean reachedEdge = false;
        int direction = 0; //0 right, 1 down, 2 left, 3 up
        int countElements = 0;
        int totalElements = someMatrix.length*someMatrix[0].length;
        boolean[][] trackedCoordinates = new boolean[someMatrix.length][someMatrix[0].length];
        results.add(someMatrix[x][y]);
        trackedCoordinates[x][y] = true;
        countElements++;
        
        while(countElements < totalElements) {
            if(!reachedEdge) {
                switch (direction) {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x++;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                        x--;
                        break;
                }
            } else if(reachedEdge) {
                switch (direction) {
                    case 0:
                        x++;
                        direction = 1;
                        break;
                    case 1:
                        y--;
                        direction = 2;
                        break;
                    case 2:
                        x--;
                        direction = 3;
                        break;
                    case 3:
                        y++;
                        direction = 0;
                        break;
                }
            }
            results.add(someMatrix[x][y]);
            trackedCoordinates[x][y] = true;
            countElements++;
            
            if(x == someMatrix.length-1 && direction == 1) {
                reachedEdge = true;
            } else if(x == 0 && direction == 3) {
                reachedEdge = true;
            } else if(y == someMatrix[0].length-1 && direction == 0) {
                reachedEdge = true;
            } else if(y == 0 && direction == 2) {
                reachedEdge = true;
            } else {
                switch (direction) {
                case 0:
                    if(trackedCoordinates[x][y+1]) {
                        reachedEdge = true;
                    } else {
                        reachedEdge = false;
                    }
                    break;
                case 1:
                    if(trackedCoordinates[x+1][y]) {
                        reachedEdge = true;
                    } else {
                        reachedEdge = false;
                    }
                    break;
                case 2:
                    if(trackedCoordinates[x][y-1]) {
                        reachedEdge = true;
                    } else {
                        reachedEdge = false;
                    }
                    break;
                case 3:
                    if(trackedCoordinates[x-1][y]) {
                        reachedEdge = true;
                    } else {
                        reachedEdge = false;
                    }
                    break;
                }
            }
        }
        return results;
    }

    public List<List<Integer>> pascalTriangle(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        if(numRows==0) {
            return results;
        }
        
        if(numRows==1) {
            temp.add(1);
            results.add(temp);
            return results;
        }
        
        if(numRows==2) {
            temp.add(1);
            results.add(temp);
            temp = new ArrayList<>();
            temp.add(1);
            temp.add(1);
            results.add(temp);
            return results;
        }
        
        temp.add(1);
        results.add(temp);
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        results.add(temp);
        temp = new ArrayList<>();
        int counter = 2;
        while(counter < numRows) {
            temp.add(1);
            for(int i = 1; i < results.get(counter-1).size(); i++) {
                temp.add(results.get(counter-1).get(i) + results.get(counter-1).get(i-1));
            }
            temp.add(1);
            results.add(temp);
            temp = new ArrayList<>();
            counter++;
        }
        return results;
    }

    public String addBinary(String a, String b) {
        char[] stringa = a.toCharArray();
        char[] stringb = b.toCharArray();
        if(stringa.length > stringb.length || stringa.length == stringb.length) {
            return calculation(stringa,stringb);
        } else if(stringb.length > stringa.length) {
            return calculation(stringb,stringa);
        }
        return "";
    }
    
    public String calculation(char[] stringa, char[] stringb) {
        StringBuilder result = new StringBuilder();
        int smallerStringPosition;
        boolean carry1 = false;
        smallerStringPosition = stringb.length-1;
            for(int i = stringa.length-1; i>=0; i--) {
                if(!carry1) {
                    if(smallerStringPosition < 0) {
                        result.insert(0,stringa[i]);
                    } else if(stringa[i] == stringb[smallerStringPosition] && stringa[i] == '0') {
                        //0
                        result.insert(0,"0");
                        carry1 = false;
                    } else if(stringa[i] == stringb[smallerStringPosition] && stringa[i] == '1') {
                        //0
                        result.insert(0,"0");
                        carry1 = true;
                    } else if(stringa[i] != stringb[smallerStringPosition]) {
                        //1
                        result.insert(0,"1");
                        carry1 = false;
                    }
                } else if(carry1) {
                    if(smallerStringPosition < 0) {
                        if(stringa[i] == '0') {
                            result.insert(0,"1");
                            carry1 = false;
                        } else if (stringa[i] == '1') {
                            result.insert(0,"0");
                            carry1 = true;
                        }
                    } else if(stringa[i] == stringb[smallerStringPosition] && stringa[i] == '0') {
                        //0
                        result.insert(0,"1");
                        carry1 = false;
                    } else if(stringa[i] == stringb[smallerStringPosition] && stringa[i] == '1') {
                        //0
                        result.insert(0,"1");
                        carry1 = true;
                    } else if(stringa[i] != stringb[smallerStringPosition]) {
                        //1
                        result.insert(0,"0");
                        carry1 = true;
                    }
                }
                smallerStringPosition--;
            }
            if(carry1) {
                result.insert(0,"1");
            }
        return result.toString();
    }

    public int strStr(String haystack, String needle) {
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        int needleCount = 0;
        int index = 0;
        boolean found = false;
        
        if(needleChar.length == 0) {
            return index;
        }
        
        if(haystackChar.length < needleChar.length)  {
            return -1;
        }
        
        for(int i = 0; i <= haystackChar.length - needleChar.length; i++) {
            if(haystackChar[i] == needleChar[needleCount]) {
                index = i;
                while(needleCount <= needleChar.length-1) {
                    if(haystackChar[i+needleCount] == needleChar[needleCount]) {
                        if(needleCount == needleChar.length-1) {
                            found = true;
                            needleCount++;
                        } else {
                            needleCount++;
                        }

                    } else {
                        needleCount = 0;
                        break;
                    }
                }
                if(found) {
                    return index;
                }
            }
            index = -1;
        }
        return index;
    }
}
