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
			new File("iiitv/Semester/"+sem).mkdirs();
			cs=new FileWriter("iiitv/semester/"+sem+"/"+subjectCode+".csv",true);
			cs.append("ID,\n");
		}
		cs.append(rollNo+",\n");
        cs.flush();
        cs.close();
    }
    public void sortRollNo(int sem, String subjectCode)
    {
        try(FileReader f=new FileReader("iiitv/semester/"+sem+"/"+subjectCode+".csv"))
        {
            BufferedReader csv=new BufferedReader(f);
            String header = csv.readLine();
            List<String> ID= new ArrayList<String>();
            String x="";
            while((x=csv.readLine())!=null)
                ID.add(x);
            sort(ID);
            csv.close();
            FileWriter wri=new FileWriter("iiitv/semester/"+sem+"/"+subjectCode+".csv");
            wri.append(header+"\n");
            for(String i:ID)
                wri.append(i+"\n");
        }
        catch(FileNotFoundException e)
        {
        }
        catch(IOException e)
        {
        }
    }
    private void sort(List<String> ID)
    {
        for(int i=0;i<ID.size();i++)
        {
            for(int j=0;j<ID.size()-i-1;j++)
            {
                if(ID.get(j).compareTo(ID.get(j+1))>0)
                {
                    String temp=ID.get(j);
                    ID.set(j,ID.get(j+1));
                    ID.set(j+1,temp);
                }
            }
        }
    }
}
