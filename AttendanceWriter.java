import java.util.*;
import java.io.*;
public class AttendanceWriter
{
	static Scanner in=new Scanner(System.in);
	public int[] getAttendance(int rollNo,int sem, String subjectCode)
	{
		List<String> list=readAttendance(sem,subjectCode);
		String s="";
		for(String i:list)
		{
			int id=Integer.parseInt(i.substring(0,9));
			if (id==rollNo)
			{
				s=i;
				break;
			}
		}
		int x=0,y=0;
		for(int i=10;i<s.length();i+=2)
		{
			x+=s.charAt(i)-48;
			y+=1;
		}
		int a[]={x,y};
		System.out.println(((double)x/y*100));
		return a;
	}
	public List<String> readAttendance(int sem,String subjectCode)
	{
		FileReader csvr=null;
		BufferedReader csv=null;
		List<String> atte=new ArrayList<String>();
		try
		{
			csvr=new FileReader("iiitv/semester/"+sem+"/"+subjectCode+".csv");
			csv=new BufferedReader(csvr);
			csv.readLine();
			String x="";
			while((x=csv.readLine())!=null)
			{
				System.out.println(x);
				atte.add(x);
			}
			csv.close();
			csvr.close();
		}
		catch(FileNotFoundException e)
		{
		}
		catch(IOException e)
		{
		}
		return atte;
	}
}
