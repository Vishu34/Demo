package arraypeakelement;

public class Arryaquery {
    // peak the element from an array that should be not smaller than its neighbour

  public void peakElement() {

      int[] arr = {10, 20, 15, 2, 23, 90, 67};

      for (int i = 1; i < arr.length; i++) {
          if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
              System.out.println(arr[i]);
          }
      }

  }

//      [0,0,0,1,2,2,1] sort this array in form of [2,2,1,1,0,0,0]



      public void sortedArray(){
          int []  arr1 = {0,0,0,1,2,2,1};
          int [] newarr= new int[arr1.length];

          int count2=0; int count1=0; int count0=0;

          for(int i=0; i<arr1.length ; i++){
              if(arr1[i]==2){
                  count2++;
              }else if(arr1[i]==1){
                  count1++;
              }else if (arr1[i]==0){
                  count0++;
              }

          }
          System.out.println("vaue is " + count0);
          int index =0;

          for(int i=0; i<count2; i++){
              newarr[index++]=2;;
          }

          for(int i=0; i<count1; i++){
              newarr[index++]=1;

          }

          for(int i=0; i<count0; i++){
              newarr[index++]=0;

          }

         for(int num:newarr){
             System.out.print(num);
         }



      }
  }


