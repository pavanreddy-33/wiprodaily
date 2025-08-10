package wiproPracticeDay1;

public class PairSum {

	public static void main(String[] args) {
		int[] arr= {2, 7, 11, 15};
	    int target=13;
	    int[] output= {0,0};
	    
//		System.out.print("Heere");
		for(int i=0;i<arr.length-1;i++)
		{
			if((arr[i]+arr[i+1]==target))
			{
				
				
				output[0]=i;
				output[1]=i+1;
				
			}
			
		}
	
		System.out.println(output[0]+" "+output[1]);
        

	}

}
