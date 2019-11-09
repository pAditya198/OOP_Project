import java.io.*;
import java.util.*;
public class Driver
{
	public static void main(String args[])throws IOException,ClassNotFoundException
	{
		
		AdminModule ob=new AdminModule();
		//int batch=ob.addStudents();
		//ob.assignRollNo(2018);
		ob.displayStudents(2018);
		/*Student ob=new Student(2018);
		Student ob1=ob.getStudent(201851002);
		System.out.println(ob1.getRollNo());
		/*TeacherModule ob=new TeacherModule();
		//ob.addSubject();
		//ob.updateAttendance("HS201");
		for(int i=1;i<6;i++)
		{
			ob.viewAttendance("HS201",201851000+i);
		}
		/*Professor ob=new Professor();
		ob.addDetails();
		String arr[]={"CS261","EC201","HS201"};
		ob.assignCourses(arr);
		ob.writeDetails();
		ob.getUID();
		*/
		//Professor ob=new Professor();
		//ob.readDetails(1454);
	}
}