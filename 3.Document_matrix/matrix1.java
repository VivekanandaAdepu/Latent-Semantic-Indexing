import java.util.*;
import java.io.*;
 
public class Matrix1 
{
     
public static void main(String args[]) throws IOException
{
Scanner keyboard = new Scanner(System.in);
System.out.print("Enter a Directory name: ");
String dirname = keyboard.nextLine();

File dir = new File(dirname);

String[] fileList = dir.list();
String[] a=new String[10000];
int i=0,n;

for(String name:fileList)
{
a[i]=name;
System.out.println(" "+a[i]);
i++;
}
n=i;
System.out.println("No.of Files:"+i);

String[] strLine=new String[10000];

for(int k=0;k<n;k++)
{
BufferedReader br=new BufferedReader( new FileReader("Input Docs/"+a[k]));
strLine[k] = br.readLine();
System.out.println("Doc "+(k+1)+":"+strLine[k]);
}

Scanner keyboard1 = new Scanner(System.in);
System.out.print("Enter KeyWord file name: ");
String filename = keyboard1.nextLine();
File file1 = new File(filename);
Scanner inputFile = new Scanner(file1);

String[] arr = new String[10000];
String[] arr1 = new String[10000];
int j=0,m,k;
i=0;

while (inputFile.hasNext())
{
String line = inputFile.nextLine(); 
line = line.trim();  
for (String retval: line.split(" "))
{

arr1[i]=retval;
arr1[i]=arr1[i].toLowerCase();
//System.out.println(arr[i]);
i++;
}
}
System.out.println("Array Size:"+i);
m=i;

int l;
int[] f=new int[1000];
int[] f1=new int[1000];
i=0;

for(k=0;k<n;k++)
{
String line = strLine[k]; 
line = line.trim();  
f[k]=i;
for (String retval: line.split(" "))
{

arr[i]=retval;
arr[i]=arr[i].toLowerCase();
i++;
}
f1[k]=i;
}

l=0;
int[] b=new int[1000];

for(j=0;j<m;j++)
{
for(k=0;k<n;k++)
{
for(i=f[k];i<f1[k];i++)
{
if(arr1[j].equals(arr[i]))
{
b[l]++;
}
}
l++;
}
}

try 
{
File file = new File("Matrix.txt");
if (!file.exists()) 
{
file.createNewFile();
}
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);

//bw.write("\t"+"Keyword"+"\t");
//for(int x=0;x<n;x++)
//bw.write("\t"+"Doc"+(x+1));
//System.out.println();
l=0;
for(j=0;j<m;j++)
{
//bw.write("\t"+arr1[j]+"\t");
bw.write("\t"+b[l]+"\t"+b[l+1]+"\t"+b[l+2]);
bw.write("\n");
l=l+3;
}
bw.close();
}
catch (IOException e) 
{
e.printStackTrace();
}

}
}