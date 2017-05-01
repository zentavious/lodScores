package lodScores;

import java.io.*;
import java.util.*;

public class LODScore{
  private static int individual;
  private static int combat;
  
  public LODScore(int i, int c){
	  individual = i;
	  combat = c;
  }
  
  public double calculateLodScore(double r){
    double pNonCombat = (1-r)/2.0;
    double pCombat = r/2.0;
    int nonCombat = individual - combat;
    double pLink =  Math.pow(pCombat, combat) * Math.pow(pNonCombat, nonCombat);
    double pUnLink = Math.pow(0.25, individual);
    double lod = pLink/pUnLink;
    double result = Math.log10(lod);
    return result;
  }
  
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    double[] array = {0, 0.1, 0.03, 0.05, 0.36, 0.5, 0.2, 0.01, 0.8};
    LODScore i = new LODScore(100,36);
    for (double r : array){
      System.out.println("Lod score of " + r + " is: " + i.calculateLodScore(r));
      System.out.println();
    }
  }
}