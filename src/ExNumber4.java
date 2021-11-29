import java.util.Scanner;

public class ExNumber4 {
    public static void main(String[] args) {
        int [] array = arrayFromUser();
        int count = duplicatesNumbers(array);
        int[] arrayWithoutDuplicates =arrayWithoutDuplicates(array,count);
        printArray(arrayWithoutDuplicates);
    }

    public static int [] arrayFromUser (){
        Scanner scanner = new Scanner(System.in);
        int sizeArray;
        int value;
        do {
            System.out.println("Enter a size : ");
            sizeArray=scanner.nextInt();
        }while (sizeArray<0);
        int[] array = new int[sizeArray];
        for (int i =0 ; i< array.length; i++){
            System.out.println("Enter a value : ");
            value= scanner.nextInt();
            array[i]=value;
        }
        return array;
    }

    public static int duplicatesNumbers (int [] fullArray){
        int count =0;
        for (int i=0; i<fullArray.length; i++){
            for (int j = i+1 ; j<fullArray.length; j++){
                if (fullArray[i]==fullArray[j]){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int[] arrayWithoutDuplicates(int[] fullArray, int count){
        int [] arrayWithoutDuplicates = new int[fullArray.length-count];
        int index =0;
        for (int i =0; i<fullArray.length; i++){
            if (index==arrayWithoutDuplicates.length){
                break;
            }
            for (int j = 0; j<arrayWithoutDuplicates.length; j++){
                if (fullArray[i]==arrayWithoutDuplicates[j] && j<=index){
                    break;
                }
                else if (fullArray[i]!=arrayWithoutDuplicates[j]&& j==index){
                    arrayWithoutDuplicates[index]=fullArray[i];
                    index++;
                    break;
                }
            }
        }

    return arrayWithoutDuplicates;
    }

    public static void printArray (int [] array){
        for (int i=0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
