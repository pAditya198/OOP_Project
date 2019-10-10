import java.util.*;
import java.io.*;
public class Admin
{
	static Scanner in=new Scanner(System.in);
	private void writeNoOfStudents(int number,int batch)throws IOException
	{
		new File("iiitv\\student").mkdir();
		new File("iiitv\\student\\"+batch).mkdir();
		int newno = number+readNoOfStudents(batch);
		FileOutputStream fout = new FileOutputStream("iiitv\\student\\"+batch+"\\Number.iiitv");
		DataOutputStream d=new DataOutputStream(fout);
		d.writeInt(newno);
		d.close();
		fout.close();
	}
	private int readNoOfStudents(int batch)throws IOException,FileNotFoundException
	{
		try
		{
			FileInputStream fin=new FileInputStream("iiitv\\student\\"+batch+"\\Number.iiitv");
			DataInputStream r=new DataInputStream(fin);
			int number=r.readInt();
			r.close();
			fin.close();
			return number;
		}
		catch(FileNotFoundException E)
		{
			return 0;
		}
		catch(EOFException E)
		{
			return 0;
		}
	}
	private void tempWriteStudent(Student obj,int index)throws IOException
	{
		new File("iiitv\\student").mkdir();
		new File("iiitv\\student\\"+obj.getBatch()).mkdir();
		new File("iiitv\\student\\"+obj.getBatch()+"\\"+index).mkdir();
		FileOutputStream fout = new FileOutputStream("iiitv\\student\\"+obj.getBatch()+"\\"+index+"\\details.iiitv");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(obj);
	}
	private Student tempReadStudent(int batch,int index)throws IOException,FileNotFoundException,ClassNotFoundException
	{
		FileInputStream fin = new FileInputStream("iiitv\\student\\"+"\\"+batch+"\\"+index+"\\details.iiitv");
		ObjectInputStream ois = new ObjectInputStream(fin);
		Student obj=(Student)ois.readObject();
		return obj;
	}
	void assignRollNo(int batch)throws IOException,FileNotFoundException,ClassNotFoundException
	{
		int number=readNoOfStudents(batch);
		System.out.println("Error");
		Student students[]=new Student[number];
		for(int i=0;i<number;i++)
		{
			students[i]=tempReadStudent(batch,i);
			students[i].readDetails(i);
			System.out.println("Error\n\n");
		}
		
		for(int i=0;i<number;i++)
		{
			for(int j=0;j<number-i-1;j++)
			{
				if(students[j].getName().compareTo(students[j+1].getName())>0)
				{
					Student t=students[j];
					students[j]=students[j+1];
					students[j+1]=t;
				}
			}
		}
		writeRoll(students);
	}
	private void writeRoll(Student students[])throws IOException
	{
		int i=1;
		for(Student t:students)
		{
			t.writeRollNo(t.getBatch()*100000+i+51000);
			t.writeDetails();
			i++;
		}
	}
	void displayStudents(int batch)throws IOException,ClassNotFoundException,FileNotFoundException
	{
		int number=readNoOfStudents(batch);
		Student t=new Student(batch);
		for(int i=0;i<number;i++)
			t.readDetails(i);
		//t.readDetails(batch*100000+i+51001);
	}
	private Student addStudent(int batch)
	{
		Student obj=new Student(batch);
		obj.addDetails();
		return obj;
	}
	int addStudents()throws IOException
	{
		System.out.print("Enter number of students: ");
		int number=in.nextInt();
		System.out.print("Enter batch of students: ");
		int batch=in.nextInt();
		int previous=readNoOfStudents(batch);
		Student students[]=new Student[number];
		for(int i=0;i<number;i++)
		{
			students[i]=addStudent(batch);
			tempWriteStudent(students[i],i+previous);
		}
		writeNoOfStudents(number,batch);
		return batch;
	}
}