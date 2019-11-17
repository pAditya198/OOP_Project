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
			Process PR=Runtime.getRuntime().exec("attrib " +  "iiitv\\Semester\\"+sem+"\\"+subjectCode+"Attendance.csv" + " -R");
			PR.waitFor();
			String s="cmd /c start /wait excel iiitv\\Semester\\"+sem+"\\"+subjectCode+"Attendance.csv";
			Process p=Runtime.getRuntime().exec(s);
			p.waitFor();
			System.out.println("Making read only");
			PR=Runtime.getRuntime().exec("attrib " +  "iiitv\\Semester\\"+sem+"\\"+subjectCode+"Attendance.csv" + " +R");
			PR.waitFor();
		}
		catch(IOException e)
		{}
		catch(InterruptedException e)
		{}
		findDefaulters(sem, subjectCode);
	}
	public void openAttendance(int sem,String subjectCode)
	{
		try
		{
			String s="cmd /c start /wait excel /r iiitv\\Semester\\"+sem+"\\"+subjectCode+"Attendance.csv";
			System.out.println(s);
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
	public void findDefaulters(int sem,String subjectCode)
	{
		System.out.println("Finding Defaulters");
		List<String> x=readAttendance(sem, subjectCode);
		String head=x.get(0);
		int total=0;
		for(int i=10;i<head.length();i+=2)
			total++;
		if(total < 5)
			return;
		List <String> def=new ArrayList<String>();
		for(String m:x)
		{
			int count=0;
			for(int j=10;j<m.length();j+=2)
			{
				if(m.charAt(j)-48==1)
					count++;
			}
			double z = ((double)count/total)*100;
			if(z < 75)
				def.add(m);
		}
		try
		{
			FileWriter f=new FileWriter("MailingScript\\mycontacts.txt",true);
			for(String s:def)
			{
				String rollno=s.substring(0,9);
				String fin=rollno + " "+ rollno+"@iiitvadodara.ac.in "+subjectCode+"\n";
				f.write(fin);
				f.close();
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.out.println("IOException");
			e.printStackTrace();
		}
	}
}
