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
	public void writeAttendance(int sem,String subjectCode)
	{
		try
		{
			Process PR=Runtime.getRuntime().exec("attrib " + "" +  "iiitv\\Semester\\"+sem+"\\"+subjectCode+"Attendance.csv" + "" + " -R");
			PR.waitFor();
			//String s="cmd /c start /wait cmd.exe /K \" start excel iiitv\\Semester\\"+sem+"\\"+subjectCode+".csv && exit\"";
			String s="cmd /c start /wait excel iiitv\\Semester\\"+sem+"\\"+subjectCode+".csv";
			Process p=Runtime.getRuntime().exec(s);
			p.waitFor();
			System.out.println("Making read only");
			PR=Runtime.getRuntime().exec("attrib " + "" +  "iiitv\\Semester\\"+sem+"\\"+subjectCode+"Attendance.csv" + "" + " +R");
			PR.waitFor();
		}
		catch(IOException e)
		{}
		catch(InterruptedException e)
		{}
	}
	public void openAttendance(int sem,String subjectCode)
	{
		try
		{
			String s="cmd /c start /wait excel iiitv\\Semester\\"+sem+"\\"+subjectCode+"Attendance.csv";
			Process p=Runtime.getRuntime().exec(s);
			p.waitFor();
		}
		catch(IOException e)
		{}
		catch(InterruptedException e)
		{}
	}
	public List<String> readAttendance(int sem,String subjectCode)
	{
		FileReader csvr=null;
		BufferedReader csv=null;
		List<String> atte=new ArrayList<String>();
		try
		{
			csvr=new FileReader("iiitv/semester/"+sem+"/"+subjectCode+"Attendance.csv");
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
