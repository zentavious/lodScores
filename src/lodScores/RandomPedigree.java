package lodScores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomPedigree {
	
	public static void GenRandomPedigree(int numOff,String file,String p1,String p2){
		ArrayList<String> offspring = new ArrayList<String>();
		PrintWriter p = null;
		try {
			p = new PrintWriter(file,"UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.println(p1);
		p.println(p2);
		for(int i = 0;i < numOff;i++){
			String a = p1.charAt((int)(Math.random()*2)) + "" + p2.charAt((int)(Math.random()*2));
			String b = p1.charAt((int)(Math.random()*2)+2) + "" + p2.charAt((int)(Math.random()*2)+2);
			if(a.charAt(0) > a.charAt(1)){
				a = a.charAt(1) + "" + a.charAt(0);
			}
			if(b.charAt(0) > b.charAt(1)){
				b = b.charAt(1) + "" + b.charAt(0);
			}
			p.println(a+b);
		}
		p.close();
		
	}
	
	public static int[] readPedigree(String file) throws FileNotFoundException{
		Scanner scan = new Scanner(new File(file));
		String p1 = pheno(scan.nextLine());
		String p2 = pheno(scan.nextLine());
		int recom = 0;
		int children = 0;
		
		while(scan.hasNextLine()){
			children++;
			String child = pheno(scan.nextLine());
			if(!p1.equals(child) && !p2.equals(child)){
				recom++;
			}
		}
		int[] ret = {recom,children};
		return ret;
	}
	
	private static String pheno(String geno){
		return geno.charAt(0) + "" + geno.charAt(2);
	}
}
