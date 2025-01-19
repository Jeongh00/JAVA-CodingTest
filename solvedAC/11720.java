package solvedAC;

import java.util.*;
import java.io.*;

public class 11720 {
    
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		String[] str = br.readLine().split("");
		
		for(int i = 0; i < n; i++) {
			sum += Integer.parseInt(str[i]);
		}
		
		
		System.out.println(sum);
		
	}
}
