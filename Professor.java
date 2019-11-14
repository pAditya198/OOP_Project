import java.io.*;
import java.util.*;
public class Professor implements Serializable
{
	private String name;
	private int UID;
	private String address;
	private String qualification;
	private String areaofInterest;
	private String gender;
	private String dob;
	private List<String> courses;
	private int courseNo;
	private String contactNo;
	private String password;
	Professor()
	{
		name="";
		UID=0;
		details="";
	}
	public void addDetails(String nm,String add, String quali,String aoi, String gen,String dob, List<String> cour, String contact, String pass)
	{
		name=nm;
		areaofInterest = aoi;
		gender = gen;
		qualification = quali;
		address = add;
		contactNo=contact;
		thsi.dob = dob;
		password=pass;
		UID=createUID(name);
		courses = cour;
		courseNo=course.size();
	}
	public void assignCourses(List<String> course)
	{
		courseNo=course.size();
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
	public void writeDetails()
	{
		try
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
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public Professor getProfessor(int UIDi)
	{
		try
		{
			FileInputStream fin = new FileInputStream("iiitv\\professor\\"+UIDi+"\\details.iiitv");
			ObjectInputStream ois = new ObjectInputStream(fin);
			Professor obj=(Professor)ois.readObject();
			ois.close();
			fin.close();
			return obj;
		}
		catch(FileNotFoundException e)
		{}
		catch(IOException e)
		{}
		catch(ClassNotFoundException e)
		{}
		return null;
	}
	/*public void readDetails(int UIDi)throws IOException,ClassNotFoundException
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
	}*/
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
	List<String> getCourses()
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
