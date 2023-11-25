package Rough;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintDuplicateNumbers {


    @Test
    public void printDuplicate(){
        int arr[]={1,3,2,4,3,5,4,6,7,6,5,5,6};
        int len=arr.length;
        int arr1[]=new int[len];
List<Integer> list=new ArrayList<>();
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(arr[i]==arr[j]){

                   /* if(list.contains(arr[i])){
                        list.add(arr[i]);
                    }*/
                }else if(arr[i]!=arr[j]){
                    list.add(arr[i]);
                }
            }
        }
        System.out.println(list);

    }
}
