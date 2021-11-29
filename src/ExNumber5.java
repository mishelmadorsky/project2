public class ExNumber5 {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,1,5,4,3,2};
        int index = topIndex(array);
        System.out.println(index);
    }

    public static int topIndex (int [] array){
        int index =0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > array[i+1] && i!=0 ){
                index = i;
                break;
            }
            else if (array[i] >= array[i+1] && i==0){
                index=-1;
                break;
            }
        }
        if (index!=-1){
            for (int i =index+1 ; i <array.length-1; i++){
                if (array[i]> array[i+1]){
                    index=index;
                }
                else {
                    index=-1;
                    break;
                }
            }
        }
        return index;
    }
}
