import java.util.Arrays;

public class Main {

    public static void main(String[] arg)
    {
        System.out.println((Arrays.deepToString(rotateMatrixCounterclockwise(new int[][]{{1, 2, 3}, {4, 5, 6}}))));
    }

    // #1
    public static String getMaxUnicSubstr(String inputString)
    {
        String usedChars = "";

        int start = 0;
        int maxStart = 0;
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < inputString.length(); i++)
        {
            String currentChar = "" + inputString.charAt(i);

            if (usedChars.contains(currentChar))
            {
                start = i;
                usedChars = "";
            }

            usedChars = usedChars + currentChar;

            currentLength = i - start + 1;

            if (currentLength > maxLength)
            {
                maxLength = currentLength;
                maxStart = start;
            }
        }

        return inputString.substring(maxStart, maxStart + maxLength);
    }

    // #2
    public static int[] getMergeWithSort(int[] array1, int[] array2)
    {
        int[] arrayToReturn = new int[array1.length + array2.length];

        int currentIndex = 0;
        for(int element : array1)
        {
            arrayToReturn[currentIndex] = element;
            currentIndex += 1;
        }

        for(int element : array2)
        {
            arrayToReturn[currentIndex] = element;
            currentIndex += 1;
        }

        Arrays.sort(arrayToReturn);
        return arrayToReturn;
    }

    // #3
    public static int maxSubarraySum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    // #4
    public static int[][] rotateMatrixClockwise(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] newMatrix = new int[cols][rows];

        for(int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                newMatrix[j][rows - 1 - i] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    // #5
    public static int[] getPair(int[] numbers, int target)
    {
        for(int i = 0; i < numbers.length - 1; i++)
        {
            for(int j = i + 1; j < numbers.length; j++)
            {
                if(numbers[i] + numbers[j] == target)
                {
                    return new int[]{numbers[i], numbers[j]};
                }
            }
        }
        return null;
    }

    // #6
    public static int getSumOfMatrix(int[][] matrix)
    {
        int sum = 0;

        for(int[] row : matrix)
        {
            for(int element: row)
            {
                sum += element;
            }
        }

        return sum;
    }

    // #7
    public static int[] getMaxElementInEachRowOfMatrix(int[][] matrix)
    {
        int[] arrayToReturn = new int[matrix.length];
        int index = 0;

        for(int[] row : matrix)
        {
            int maxElement = row[0];

            for(int element : row)
            {
                if(element > maxElement)
                {
                    maxElement = element;
                }
            }
            arrayToReturn[index] = maxElement;
            index++;
        }

        return arrayToReturn;
    }

    public static int[][] rotateMatrixCounterclockwise(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] newMatrix = new int[cols][rows];

        for(int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                newMatrix[cols - 1 - j][i] = matrix[i][j];
            }
        }

        return newMatrix;
    }
}