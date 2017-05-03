package lodScores;

import java.io.FileNotFoundException;

public class Driver {
	public static void main(String[] args){
		RandomPedigree.GenRandomPedigree(500, "test", "AaBb", "aaBb");
		int[] arr = null;
		try {
			arr = RandomPedigree.readPedigree("test");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Number of offsprings: " + arr[1]);
		System.out.println("Number of recombinant phenotype: "+ +arr[0]);
		LODScore t = new LODScore(arr[1],arr[0]);
		double ratio = arr[0]*1.0/(arr[1]*1.0);
		System.out.println("Recombinate estimate of " + ratio + " is: " + t.calculateLodScore(ratio));
		
		RandomPedigree.GenRandomPedigree(50, "test2", "AaBb", "aaBb");
		try {
			arr = RandomPedigree.readPedigree("test2");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Number of offsprings: " + arr[1]);
		System.out.println("Number of recombinant phenotype: "+ +arr[0]);
		LODScore t1 = new LODScore(arr[1],arr[0]);
		ratio = arr[0]*1.0/(arr[1]*1.0);
		System.out.println("Recombinate estimate of " + ratio + " is: " + t1.calculateLodScore(ratio));
	}
}
