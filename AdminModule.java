import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;
public class AdminModule
{
	static Scanner in=new Scanner(System.in);
	public void deleteFolder(String path)
	{
		File index=new File(path);
		String[]entries = index.list();
		for(String s: entries)
		{
			System.out.println(s);
    		File currentFile = new File(index.getPath(),s);
    		currentFile.delete();
		}
		index.delete();
	}
	public void writeNoOfStudents(int number,int batch)
	{
		try {
			new File("iiitv\\student\\"+batch).mkdirs();
			int newno = number+readNoOfStudents(batch);
			FileOutputStream fout = new FileOutputStream("iiitv\\student\\"+batch+"\\Number.iiitv");
			DataOutputStream d=new DataOutputStream(fout);
			d.writeInt(newno);
			d.close();
			fout.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	public int readNoOfStudents(int batch)
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
		catch(FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
			return 0;
		}
		catch(IOException e)
		{
			System.out.println("IOException");
			return 0;
		}
	}
	public void tempWriteStudent(Student obj,int index)
	{
		try
		{
			new File("iiitv\\student").mkdir();
			new File("iiitv\\student\\"+obj.getBatch()).mkdir();
			new File("iiitv\\student\\"+obj.getBatch()+"\\"+index).mkdir();
			FileOutputStream fout = new FileOutputStream("iiitv\\student\\"+obj.getBatch()+"\\"+index+"\\details.iiitv");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(obj);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public Student tempReadStudent(int batch,int index)
	{
		try
		{
			FileInputStream fin = new FileInputStream("iiitv\\student\\"+batch+"\\"+index+"\\details.iiitv");
			ObjectInputStream ois = new ObjectInputStream(fin);
			Student obj=(Student)ois.readObject();
			deleteFolder("iiitv\\student\\"+batch+"\\"+index);
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
	void assignRollNo(int batch)
	{
		try {
			if(!checkStatus1(batch))
			{
				JOptionPane.showMessageDialog(null,"Batch not found");
				return;
			}
			else if(!checkStatus(batch)){
				JOptionPane.showMessageDialog(null,"Roll number already assigned");
				return;
			}
			else
			{

			}
			FileOutputStream fout=new FileOutputStream("iiitv\\student\\"+batch+"\\Status.iiitv");
			DataOutputStream w=new DataOutputStream(fout);
			w.writeInt(0);
			int number=readNoOfStudents(batch);
			Student students[]=new Student[number];
			for(int i=0;i<number;i++)
			{
				students[i]=tempReadStudent(batch,i);
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
			JOptionPane.showMessageDialog(null,"Roll Number has been assigned");
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	private void writeRoll(Student students[])
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
		{
			System.out.println();
			t.readDetails(batch*100000+i+51001);
			System.out.println();
		}
	}
	boolean checkStatus1(int batch)throws IOException
	{
		System.out.println(true);
		try
		{
			FileInputStream fin=new FileInputStream("iiitv\\student\\"+batch+"\\Status.iiitv");
			DataInputStream r=new DataInputStream(fin);
		}
		catch(FileNotFoundException E)
		{
			return false;
		}
		return true;
	}
	boolean checkStatus(int batch)throws IOException
	{
		try
		{
			FileInputStream fin=new FileInputStream("iiitv\\student\\"+batch+"\\Status.iiitv");
			DataInputStream r=new DataInputStream(fin);
			int status=r.readInt();
			return (status==1)?true:false;
		}
		catch(FileNotFoundException E)
		{
			new File("iiitv\\student\\"+batch).mkdirs();
			FileOutputStream fout=new FileOutputStream("iiitv\\student\\"+batch+"\\Status.iiitv");
			DataOutputStream w=new DataOutputStream(fout);
			w.writeInt(1);
			return true;
		}
	}
	void addStudents(int number,int batch)
	{
		try {
			if(!checkStatus(batch))
			{
				int previous=readNoOfStudents(batch);
				for(int i=number;i>0;i--)
				{
					new File("iiitv\\student\\"+batch+"\\"+(batch*100000+i+51000+previous)).mkdir();
					StudentRegistration ob=new StudentRegistration(new Student(batch),batch*100000+i+51000+previous,true);
					ob.setVisible(true);

				}
				writeNoOfStudents(number,batch);
			}
			else
			{
				int previous=readNoOfStudents(batch);
				for(int i=number-1;i>=0;i--)
				{
					StudentRegistration ob=new StudentRegistration(new Student(batch),i+previous,false);
					ob.setVisible(true);
					//tempWriteStudent(students[i],i+previous);
				}
				writeNoOfStudents(number,batch);
				System.out.println(readNoOfStudents(batch));
			}
		}
	 	catch(IOException e) {
			e.printStackTrace();
		}
	}
	void addProfessor()
	{
		try
		{
			ProfessorRegistration ob=new ProfessorRegistration(new Professor());
			ob.setVisible(true);
		}
		catch(RuntimeException e)
		{}
	}
}
