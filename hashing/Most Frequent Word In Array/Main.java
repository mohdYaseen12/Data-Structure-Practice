import java.io.*;
import java.util.*;

class Solution {
    public void mostFrequent(String []arr, int n) {
        // write your code here
		Map<String, Integer> hm = new HashMap<>();
		String res = "";
		int maxCount = 0;
		for(int i=0;i<n;i++){
			if(hm.containsKey(arr[i])){
				hm.put(arr[i], hm.get(arr[i])+1);
			}
			else{
				hm.put(arr[i],1);
			}
		}
		// String mfc = arr[0];
		for(String str : hm.keySet()){
			maxCount = Math.max(maxCount,hm.get(str));
			// mfc = str;
		}
		Map<String, Integer> hm2 = new HashMap<>();
		for(int i=0; i<n;i++){
			if(hm.get(arr[i]) == maxCount){
				if(!hm2.containsKey(arr[i]) ){
					res = arr[i];
					hm2.put(arr[i], 1);
				}
				
			}
		}
		System.out.print(res);
		
		
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String []arr = new String[n];
        for(int i=0;i<n;++i){
                arr[i] = sc.next();
        }
        Solution Obj = new Solution();
        Obj.mostFrequent(arr,n);  
        System.out.println('\n');
    }
}
