import java.util.*;
import java.io.*;
public class Admin
{
	static Scanner in=new Scanner(System.in);
	private void writeNoOfStudents(int number,int batch)throws IOException,FileNotFoundException
	{
		new File("iiitv\\student").mkdir();
		new File("iiitv\\student\\"+batch).mkdir();
		FileOutputStream fout = new FileOutputStream("iiitv\\student\\"+batch+"\\Number.iiitv");
		DataOutputStream d=new DataOutputStream(fout);
		d.writeInt(number);
		d.close();
		fout.close();
	}
	void assignRollNo(Students students[])throws IOException,FileNotFoundException,ClassNotFoundException
	{
		FileInputStream fin=new FileInputStream("iiitv\\student\\"+batch+"\\Number.iiitv");
		DataInputStream f=new DataInputStream(fin);
		int number=f.readInt();
		System.out.println(number);
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
		
		int i=1;
		for(Student t:students)
		{
			t.writeRollNo(batch*100000+i+51000);
			i++;
		}
	}
	private Student addBatch()
	{
		System.out.println();
		System.out.print("Enter batch of Student: ");
		int batch=in.nextInt();
		return new Student(batch);
	}
	void displayStudents(int batch)throws IOException,ClassNotFoundException,FileNotFoundException
	{
		FileInputStream fin=new FileInputStream("iiitv\\student\\"+batch+"Number.iiitv");
		int number=fin.read();
		Student t=new Student(batch);
		for(int i=0;i<number;i++)
			t.readDetails(batch*100000+i+51001);
	}
	private int addStudent()
	{
		Student obj=addBatch();
		obj.addDetails();
		return obj
	}
	int addStudents()throws IOException
	{
		System.out.print("Enter number of students: ");
		int number=in.nextInt();
		int batch=0;
		Students students[]=new Students[number];
		for(int i=0;i<number;i++)
			students[i]=addStudent();
		writeNoOfStudents(number,batch);
		return batch;
	}
}