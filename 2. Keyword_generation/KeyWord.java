import java.util.*;
import java.io.*;
 
public class KeyWord 
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

String[] arr = new String[10000];
int j=0,m,k;
i=0;

for(k=0;k<n;k++)
{
String line = strLine[k]; 
line = line.trim();  
for (String retval: line.split(" "))
{

arr[i]=retval;
arr[i]=arr[i].toLowerCase();
//System.out.println(arr[i]);
i++;
}
}
m=i;

for(i=0;i<m;i++)
{
for(j=i+1;j<m;j++)
{
if(arr[i].equals(arr[j]))
{
arr[j]="";
}
}
}

try 
{
File file = new File("Words.txt");
if (!file.exists()) 
{
file.createNewFile();
}
FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);
	
for(i=0;i<m;i++)
{
if(!(arr[i].equals("")))
{
if(!(arr[i].equals(".")))
{
bw.write(arr[i]);
bw.write(" ");
}
}
}
bw.close();
} 
catch (IOException e) 
{
e.printStackTrace();
}


}
}