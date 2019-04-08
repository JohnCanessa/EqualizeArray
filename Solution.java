import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * 
 */
public class Solution {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {

    	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
 
    	// **** load hash map (compute max value) [1] ****
    	int maxVal = 0;
    	for (int i = 0; i < arr.length; i++) {
    		if (hm.containsKey(arr[i])) {
     			int val = hm.get(arr[i]) + 1;
    			hm.put(arr[i], val);
    			if (val > maxVal)
    				maxVal = val;
    		} else {
    			hm.put(arr[i], 1);
    			if (1 > maxVal)
    				maxVal = 1;
     		}
    	}
    	
    	// ???? ????
    	System.out.println("hm: " + hm.toString());
     	System.out.println("maxVal: " + maxVal);
     	
     	// **** get max value from hash map [2] ****
     	Map.Entry<Integer, Integer> maxEntry = hm.entrySet().stream().max(Map.Entry.comparingByValue()).get();
     	maxVal = maxEntry.getValue();
     	
     	// ???? ????
     	System.out.println("maxVal: " + maxVal);
     	
     	// **** iterate and get the entry with the maximum value [3] ****
     	Iterator it = hm.entrySet().iterator();
     	maxVal = 0;
     	while (it.hasNext()) {
     		Entry<Integer, Integer> e = (Map.Entry<Integer, Integer>)it.next();
     		if (e.getValue() > maxVal)
     			maxVal = e.getValue();
     	}
     	
    	// ???? ????
     	System.out.println("maxVal: " + maxVal);
 
    	// **** return the minimum number of deletions ****
    	return arr.length - maxVal;
    }

    // **** ****
    private static final Scanner scanner = new Scanner(System.in);

    // **** test scaffolding ****
    public static void main(String[] args) throws IOException {
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        // **** close buffered writer ****
        bufferedWriter.close();

        // **** close scanner ****
        scanner.close();
    }

}
