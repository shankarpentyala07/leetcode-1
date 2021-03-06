import java.io.*;
import java.util.*;

/*

 */

class Solution {
  
  private static int lps(String str) {
     boolean[][] dp = new boolean[str.length()][str.length()];
      
     int maxLength = 1;
    
     for(int startIndx = 0; startIndx < str.length(); startIndx++) 
         dp[startIndx][startIndx] = true;
     
      
      for(int startIndx = str.length()-1; startIndx >= 0; startIndx--) {
        for(int endIndx = startIndx + 1; endIndx < str.length(); endIndx++) {
          if(str.charAt(startIndx) == str.charAt(endIndx)) {
            if(endIndx - startIndx == 1 || dp[startIndx+1][endIndx-1]) {
                dp[startIndx][endIndx] = true;
                maxLength = Math.max(maxLength, endIndx - startIndx + 1); 
            }  
          }
        } 
      }      
       return maxLength;
  }  
  
  public static void main(String[] args) {
     System.out.println(lps("abdbca"));
     System.out.println(lps("cdpdd"));
     System.out.println(lps("pqr"));
  }
  
}
