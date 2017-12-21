import java.lang.Math;
import java.util.Scanner;

 class cosinesimilarity {
    public static void main (String [] args)throws Exception
 {
	Scanner s = new Scanner(System.in);
	int n=s.nextInt();
        double[] a = new double[n];
        double[] b = new double[n];
	System.out.println("enter the values of a:");
	for(int i=0;i<a.length;i++)
	{
		a[i]=s.nextDouble();
	}
	System.out.println("enter the values of b:");
	for(int i=0;i<b.length;i++)
	{
		b[i]=s.nextDouble();
	}
	
        

        double sum = 0;
        for (int i = 0; i < a.length; i++)
	 {
            sum += a[i] * b[i];    
        }
	float sum1=0;
	float sum2=0;
	float sum3;
        System.out.println(sum);
	for(int i=0;i<a.length;i++)
	{
		sum1+=a[i]*a[i];
		sum2+=b[i]*b[i];
		
	}
	double d;
	d=Math.sqrt(sum1)+Math.sqrt(sum2);
	double c;
	c=sum/d;
System.out.println("the cosinesimilarity value:"+c);
	
    }
}