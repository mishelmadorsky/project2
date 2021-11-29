public class ExNumber6 {

    public static void main(String[] args) {
        int[] array1 = {20, 30, 40, 55,55};
        int[] array2 = {20, 30, 40, 55, 60, 77};
        boolean strangersArrays =strangers(array1,array2);
        System.out.println("Strangers ?" + strangersArrays);
        printArray(intersection(array1,array2));

    }
    public static int[] intersection(int[] array1, int[] array2) {
        int auxiliaryArray[] = new int[array1.length];
        int countIndex = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i]==auxiliaryArray[j]){
                    break;
                }
                if (array1[i] == array2[j]) {
                    auxiliaryArray[countIndex] = array1[i];
                    countIndex++;
                    break;
                }
            }
        }
        int intersectionArray[] = new int[countIndex];
        for (int i = 0; i < countIndex; i++) {
            intersectionArray[i] = auxiliaryArray[i];
        }
        return intersectionArray;
    }
    public static boolean strangers(int[] array1, int[] array2) {
        int[] intersection = intersection(array1, array2);
        if (intersection.length == 0) {
            return true;
        } else {
            return false;
        }

    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}