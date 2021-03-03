package test;

public class testing {

	public static void main(String[] args) {
		int [] a = {9,2,3,2,1,4,5,3,1,2} ;
		int flag =0;
		for (int i =0; i < 9; i++)
		{
			for (int j = i+1; j<9; j++)
			{
				if(a[i]==a[j])
				{
					System.out.println(a[i]+"is at the :"+j+" location");
					flag=1;
					break;
				}	
			}
		if (flag==1) {
			break;
		}
		}
	}
}

