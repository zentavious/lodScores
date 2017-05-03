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
  
  
}