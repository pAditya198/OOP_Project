import java.io.*;
import java.util.*;
public class Professor implements Serializable
{
	private String name;
	private int UID;
	private String details;
	private String courses[];
	private int courseNo;
	private String contactNo;
	private String password;
	Professor()
	{
		name="";
		UID=0;
		details="";
	}
	public void addDetails()
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Name: ");
		name=in.nextLine();
		System.out.print("Enter details: ");
		details=in.nextLine();
		System.out.print("Enter Contact Number: ");
		contactNo=in.nextLine();
		System.out.println("Enter password");
		password=in.nextLine();
		UID=createUID(name);
	}
	public void assignCourses(String course[])throws IOException
	{
		courseNo=course.length;
		courses=course;
		writeDetails();
	}
	int createUID(String nm)
	{
		byte a[]=nm.getBytes();
		int x=0;
		for(byte b:a)
			x+=b;
		return x;
	}
	public void writeDetails()throws IOException
	{
		new File("iiitv\\professor\\"+UID).mkdirs();
		FileOutputStream fout = new FileOutputStream("iiitv\\professor\\"+UID+"\\details.iiitv");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
		oos.close();
		fout.close();
		fout=new FileOutputStream("iiitv\\professor\\"+UID+"\\courseNo.iiitv");
		oos = new ObjectOutputStream(fout);
		oos.writeObject(courseNo);
		oos.close();
		fout.close();
		fout=new FileOutputStream("iiitv\\professor\\"+UID+"\\course.iiitv");
		oos = new ObjectOutputStream(fout);
		oos.writeObject(courses);
		oos.close();
		fout.close();
	}
	public Professor getProfessor(int UIDi)throws IOException,ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream("iiitv\\professor\\"+UIDi+"\\details.iiitv");
		ObjectInputStream ois = new ObjectInputStream(fin);
		Professor obj=(Professor)ois.readObject();
		ois.close();
		fin.close();
		return obj;
	}
	public void readDetails(int UIDi)throws IOException,ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream("iiitv\\professor\\"+UIDi+"\\details.iiitv");
		ObjectInputStream ois = new ObjectInputStream(fin);
		Professor obj=(Professor)ois.readObject();
		display(obj,UIDi);
		ois.close();
		fin.close();
	}
	private void display(Professor obj,int UIDi)
	{
		System.out.println("Name : "+obj.getName());
		System.out.println("Details : "+obj.getDetails());
		System.out.println("Contact Number : "+obj.getContactNo());
		System.out.println("Unique ID : "+UIDi);
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
	String getName()
	{
		return name;
	}
	String getDetails()
	{
		return details;
	}
	String getContactNo()
	{
		return contactNo;
	}
	int getCourseNo()
	{
		return courseNo;
	}
	String[] getCourses()
	{
		return courses;
	}
	String getPass()
	{
		return password;
	}
	void getUID()
	{
		System.out.println(UID);
	}
}
	