import java.util.Arrays;
import java.util.Scanner;

public class ExNumber2 {
    public static final int SIZE =10;

    public static void main(String[] args) {
        int [] array = rebootArray();
        int sum = sumOfArray(array);
        double average = averageOfArrayNumbers(sum, SIZE);
        System.out.println(Arrays.toString(numbersLargerThanAverage(average , array)));

    }
    public static int [] rebootArray (){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[SIZE];
        for (int i = 0; i < array.length ; i++) {
            System.out.println("Enter a number: ");
            array[i] = scanner.nextInt();
        }
        return array;
    }
    public static int sumOfArray (int [] array){
        int sum=0;
        for (int i = 0; i < array.length; i++){
            sum = sum+ array[i];
        }
        return sum;
    }
    public static double averageOfArrayNumbers (int sum , int size){

        double average = sum / size;
        return average;
    }
    public static int[] numbersLargerThanAverage (double average, int [] array){
        int count =0;
        for ( int j = 0; j < array.length; j++){
            if (array[j] > average){
                count++;
            }
        }
        int[] newArray = new int[count];
        int index=0;
        for (int j = 0; j< array.length; j++){
            if (index == count) {
                break;
            }
            if (array[j] > average){
                newArray[index]= array[j];
                index++;
            }
        }
        return newArray;
        }
    }
