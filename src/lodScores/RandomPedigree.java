package lodScores;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

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
}
