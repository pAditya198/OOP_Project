import java.util.*;
import java.io.*;
public class Student implements Serializable
{
	private int rollNo;
	private int batch;
	private boolean status; //new student or not
	private double CPI;
	private double SPI;
	private String Name;
	private String Addr;
	private String BloodGr;
	private String Programme;
	private String contactNo;
	private String password;
	private String Semester;
	private String courses[];
	private String gender;
	private String DoB;
	private int courseNo;
	Student(int batch)
	{
		rollNo=-1;
		this.batch=batch;
		CPI=0;
		SPI=0;
		Name="";
		Addr="";
		contactNo="";
		status=true;
		password="";
	}
	public void addDetails(String nm, String addr,String DB,String cont, String G,String prog, String BG,String pass,String sem)
	{
		Name=nm;
		Addr=addr;
		contactNo=cont;
		gender=G;
		DoB=DB;
		Programme=prog;
		BloodGr=BG;
		password=pass;
		Semester=sem
	}
	public void addCourses(String course[])
	{
		courses=course;
		courseNo=course.length;
		writeDetails();
	}
	public void writeDetails()
	{
		try
		{
			new File("iiitv\\student\\"+batch+"\\"+rollNo).mkdirs();
			FileOutputStream fout = new FileOutputStream("iiitv\\student\\"+batch+"\\"+rollNo+"\\details.iiitv");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this);
			fout=new FileOutputStream("iiitv\\student\\"+batch+"\\"+rollNo+"\\courseNo.iiitv");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(courseNo);
			oos.close();
			fout.close();
			fout=new FileOutputStream("iiitv\\student\\"+batch+"\\"+rollNo+"\\course.iiitv");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(courses);
			oos.close();
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public Student getStudent(int rollNo)
	{
		try
		{
			FileInputStream fin = new FileInputStream("iiitv\\student\\"+batch+"\\"+rollNo+"\\details.iiitv");
			ObjectInputStream ois = new ObjectInputStream(fin);
			Student obj=(Student)ois.readObject();
			return obj;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			return null;
		}
	}
	public void readDetails(int roll)
	{
		try
		{
			FileInputStream fin = new FileInputStream("iiitv\\student\\"+batch+"\\"+rollNo+"\\details.iiitv");
			ObjectInputStream ois = new ObjectInputStream(fin);
			Student obj=(Student)ois.readObject();
			display(obj);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	private void display(Student obj)
	{
		System.out.println("Name : "+obj.Name);
		System.out.println("Address : "+obj.Addr);
		System.out.println("Contact Number : "+obj.contactNo);
		System.out.println("Roll Number : "+obj.rollNo);
		System.out.println("CPI : "+obj.CPI);
		System.out.println("Number of courses : "+obj.getCourseNo());
		obj.displayCourse();
	}
	private void displayCourse()
	{
		System.out.println("The courses taken by the professor are: ");
		int x=1;
		for(String i:courses)
			System.out.println((x++)+": "+i);
	}
	public int getBatch()
	{
		return batch;
	}
	public boolean getStatus()
	{
		return status;
	}
	int getCourseNo()
	{
		return courseNo;
	}
	public boolean changeStatus()
	{
		if(status)
			status=!status;
		return status;
	}
	public int getRollNo()
	{
		return this.rollNo;
	}
	public void writeRollNo(int rollNo)
	{
		this.rollNo=rollNo;
	}
	public String getName()
	{
		return Name;
	}
	public String getAddr()
	{
		return Addr;
	}
	String[] getCourses()
	{
		return courses;
	}
	public String getContactNo()
	{
		return contactNo;
	}
	public String getBloodGr()
	{
		return BloodGr;
	}
	public String getProgramme()
	{
		return Programme;
	}
	public String getGender()
	{
		return gender;
	}
	public String getPass()
	{
		return password;
	}
}
