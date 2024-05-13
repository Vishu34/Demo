public class Main {

    public static void main(String[] args) {


    // peak the element from an array that should be not smaller than its neighbour

    int [] arr= {10,20,15,2,23,90,67} ;

    for(int i=1;i<arr.length;i++){
        if (arr[i] > arr[i-1] && arr[i] > arr[i + 1]) {
            System.out.println(arr[i]);
        }
    }


}
}