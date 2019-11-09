import java.util.*;
import java.io.*;

public class Semester
{
    static Scanner in = new Scanner(System.in);
    public void writeSemester(int rollNo, int sem,String subjectCode) throws IOException
	{
		FileWriter cs = null;
		try
		{
			FileReader f=new FileReader("iiitv/semester/"+sem+"/"+subjectCode+".csv");
			cs=new FileWriter("iiitv/semester/"+sem+"/"+subjectCode+".csv",true);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("XYZ");
			new File("iiitv/Semester/"+sem).mkdirs();
			cs=new FileWriter("iiitv/semester/"+sem+"/"+subjectCode+".csv",true);
			cs.append("ID,\n");
		}
		cs.append(rollNo+",\n");
        cs.flush();
        cs.close();
    }
}
