import java.io.*;
import java.util.*;
public class Driver
{
	public static void main(String args[])throws IOException,ClassNotFoundException
	{
		/*
		Admin ob=new Admin();
		int batch=ob.addStudents();
		ob.assignRollNo(2018);
		ob.displayStudents(2018);
		*/
		TeacherModule ob=new TeacherModule();
		//ob.addSubject();
		ob.updateAttendance("HS201");
		for(int i=1;i<=11;i++)
		{
			ob.viewAttendance("HS201",201851000+i);
		}
	}
}