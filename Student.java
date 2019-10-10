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
	private String contactNo;
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
	}
	public void addDetails()
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Name: ");
		Name=in.nextLine();
		System.out.print("Enter Address: ");
		Addr=in.nextLine();
		System.out.print("Enter Contact Number: ");
		contactNo=in.nextLine();
	}
	/*void writeDetails(String name)
	{
		new File("iiitv\\student").mkdir();
		new File("iiitv\\student\\"+batch).mkdir();
		new File("iiitv\\student\\"+batch+"\\"+rollNo).mkdir();
	}*/
	public void writeDetails()throws IOException
	{
		new File("iiitv\\student").mkdir();
		new File("iiitv\\student\\"+batch).mkdir();
		new File("iiitv\\student\\"+batch+"\\"+rollNo).mkdir();
		FileOutputStream fout = new FileOutputStream("iiitv\\student\\"+batch+"\\"+rollNo+"\\details.iiitv");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
	}
	public Student getStudent(int rollNo)throws IOException,ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream("iiitv\\student\\"+batch+"\\"+rollNo+"\\details.iiitv");
		ObjectInputStream ois = new ObjectInputStream(fin);
		Student obj=(Student)ois.readObject();
		return obj;
	}
	public void readDetails(int roll)throws IOException,ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream("iiitv\\student\\"+batch+"\\"+roll+"\\details.iiitv");
		ObjectInputStream ois = new ObjectInputStream(fin);
		Student obj=(Student)ois.readObject();
		display(obj);
	}
	private void display(Student obj)
	{
		System.out.println("Name : "+obj.Name);
		System.out.println("Address : "+obj.Addr);
		System.out.println("Contact Number : "+obj.contactNo);
		System.out.println("Roll Number : "+obj.rollNo);
		System.out.println("CPI : "+obj.CPI);
	}
	public int getBatch()
	{
		return batch;
	}
	public boolean getStatus()
	{
		return status;
	}
	public boolean changeStatus()
	{
		if(status)
			status=!status;
		return status;
	}
	public void writeRollNo(int rollNo)
	{
		this.rollNo=rollNo;
	}
	public String getName()
	{
		return Name;
	}
}	