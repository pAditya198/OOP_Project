import java.io.*;
import java.util.*;
public class Driver
{
	public static void main(String args[])throws IOException,ClassNotFoundException
	{
		Admin ob=new Admin();
		int batch=ob.addStudents();
		ob.assignRollNo(2018);
		ob.displayStudents(2018);
		//Student ob=new Student(2018);
		//ob.readDetails(201851001);
	}
}