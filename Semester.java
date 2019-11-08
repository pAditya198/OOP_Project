import java.util.*;
import java.io.*;

public class Semester {
    static Scanner in = new Scanner(System.in);

    public void writeSem1(String rollno) throws IOException {
        String header = "";
        FileReader csvr = null;
        BufferedReader csv = null;
        try {
            new File("iiitv/Semester/Sem1").mkdirs();
            csvr = new FileReader("iiitv/Semester/Sem1/SC101.csv");
            csv = new BufferedReader(csvr);
            header = csv.readLine();
        } catch (FileNotFoundException e) {
            header = "ID";
        }
        header += "\n";
        String x;
        List<String> atte = new ArrayList<String>();
        while ((x = csv.readLine()) != null) {
            x += "\n" + rollno;
            atte.add(x);
        }
        csv.close();
        csvr.close();
        FileWriter cs = new FileWriter("iiitv/Semester/Sem1/SC101.csv");
        cs.append(header);
        for (String i : atte) {
            System.out.println(i);
            cs.append(i);
        }
        cs.flush();
        cs.close();
    }

    public static void main(String args[]) throws IOException {
        Semester ob = new Semester();
        ob.writeSem1("201851008");
    }
}