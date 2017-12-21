import java.util.*;
import java.io.*;
 
public class FileMerge 
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

String[] Stop = {"a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", "alone", "along", "already", 	"also", "although", "always", "am", "among", "amongst", "amoungst", "amount", "an", "and", "another", "any", "anyhow", "anyone", "anything", "anyway", "anywhere", "are", "around", "as", "at", "back", "be", "became", "because", "become", "becomes", "becoming", "been", "before", 	"beforehand", "behind", "being", "below", "beside", "besides", "between", "beyond", "bill", "both", "bottom", "but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt", "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", 	"eleven", "else", "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", "front", "full", "further", "get", "give", "go", "had", "has", "hasnt", "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", "is", "it", "its","did","know","itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", "may", "me", "meanwhile", "might", "mill", "mine", "more", 	"moreover", "most", "mostly", "move", "much", "must", "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", "or", "other", 	"others", "otherwise", "our", "ours", "ourselves", "out", "over", "own", "part", "per", "perhaps", "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she", "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", 	"their", "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "top", "toward", "towards", 	"twelve", "twenty", "two", "un", "under", "until", "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever", "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", 	"who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet", "you", "your", "yours", "yourself", "yourselves", "z", "zero","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","w","x","y","z",":",",","'"};

String[] arr = new String[10000];
int j=0,m,k,l,x=0;
l=Stop.length;

for(k=0;k<n;k++)
{
String line = strLine[k]; 
line = line.trim();  
File file = new File(a[k]);

if (!file.exists()) 
{
file.createNewFile();
}

FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);
i=0;

for (String retval: line.split(" "))
{

arr[i]=retval;
arr[i]=arr[i].toLowerCase();
System.out.println(arr[i]);

for(j=0;j<l;j++)
{
if(arr[i].equals(Stop[j]))
{
arr[i]="";
}
}
for(j=0;j<l;j++)
{
if(arr[i].equals(":"))
{
arr[i]="";
}
}

if(arr[i]!="")
{
bw.write(arr[i]);
bw.write(" ");
}
i++;
}
bw.close();

}


}
}