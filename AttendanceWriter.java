import java.util.*;
import java.io.*;
public class AttendanceWriter
{
	static Scanner in=new Scanner(System.in);
	public void writeAttendance(String Date)throws IOException
	{	
		String header="";
		FileReader csvr=null;
		BufferedReader csv=null;
		try
		{
			csvr=new FileReader("Attendance.csv");
			csv=new BufferedReader(csvr);
			header=csv.readLine();
		}
		catch(FileNotFoundException e)
		{
			header="ID";
		}
		header+=","+Date+"\n";
		String x="";
		List<String> atte=new ArrayList<String>();
		while((x=csv.readLine())!=null)
		{
			String id=x.substring(0,9);
			System.out.println("Enter 1 if "+id+" has attended, else 0");
			int att=in.nextInt();
			x+=","+att+"\n";
			atte.add(x);
		}
		csv.close();
		csvr.close();
		FileWriter cs=new FileWriter("Attendance.csv");
		cs.append(header);
		for(String i:atte)
		{
			System.out.println(i);
			cs.append(i);
		}
		cs.flush();
		cs.close();
	}
	public static void main(String args[])throws IOException
	{
		AttendanceWriter ob=new AttendanceWriter();
		ob.writeAttendance("10-11-2019");
	}
}	