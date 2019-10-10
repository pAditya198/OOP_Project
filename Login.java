import java.io.*;
import java.util.*;
public class Login
{
	static Scanner in=new Scanner(System.in);
	public void addUser()throws IOException, FileNotFoundException
	{
		System.out.println("Enter 1 for Admin, Enter 2 for Teacher, Enter 3 for Student");
		System.out.print("Enter User Type: ");
		int type=in.nextInt();
		addUserType(type);
	}
	private void addUserType(int type)throws IOException, FileNotFoundException
	{
		switch(type)
		{
			case 1:
				System.out.println("Enter username: ");
	}
}	
	
	