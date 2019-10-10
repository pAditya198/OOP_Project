import java.util.*;
import java.io.*;
public class TeacherModule extends Admin
{
	static Scanner in=new Scanner(System.in);
	public void addSubject()throws IOException
	{
		System.out.print("Enter code of subject: ");
		String sub=in.nextLine();
		int number=readNoOfStudents(2018);
		
		for(int i=0;i<number;i++)
		{
			int rollNo=201851001+i;
			FileOutputStream fout = new FileOutputStream("iiitv\\student\\"+2018+"\\"+rollNo+"\\"+sub+".iiitv");
			DataOutputStream dos = new DataOutputStream(fout);
			dos.writeInt(0);
			dos.writeInt(0);
		}
	}
	public void updateAttendance(String sub)throws IOException, FileNotFoundException
	{
		int number=readNoOfStudents(2018);
		for(int i=0;i<number;i++)
		{
			int rollNo=201851001+i;
			int att[]=getAttendance(sub,rollNo);
			System.out.println("Enter 1 if "+rollNo+" has attended, otherwise 0");
			int temp=in.nextInt();
			if(temp>1)
				temp=1;
			att[0]+=temp;
			att[1]+=1;
			FileOutputStream fout = new FileOutputStream("iiitv\\student\\"+2018+"\\"+rollNo+"\\"+sub+".iiitv");
			DataOutputStream dos = new DataOutputStream(fout);
			dos.writeInt(att[0]);
			dos.writeInt(att[1]);
		}
	}
	private int[] getAttendance(String sub,int rollNo)throws IOException, FileNotFoundException
	{
		FileInputStream fin=new FileInputStream("iiitv\\student\\"+2018+"\\"+rollNo+"\\"+sub+".iiitv");
		DataInputStream din=new DataInputStream(fin);
		int a[]=new int[2];
		a[0]=din.readInt();
		a[1]=din.readInt();
		return a;
	}
	public void viewAttendance(String sub,int rollNo)throws IOException, FileNotFoundException
	{
		int att[]=getAttendance(sub,rollNo);
		System.out.println("Attendance for subject: "+sub+" Roll No: "+rollNo);
		System.out.println("Classes attended: "+att[0]);
		System.out.println("Total Classes: "+att[1]);
		System.out.println("Percentage attended: "+(float)att[0]/att[1]*100);
		System.out.println();
	}
}