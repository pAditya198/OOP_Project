import java.util.*;
import java.io.*;

public class MarksWriter {
    static Scanner in = new Scanner(System.in);

    public void writeMarks(int sem, String subjectCode) {
        try {
            Process PR = Runtime.getRuntime().exec("attrib " + "iiitv\\Semester\\" + sem + "\\" + subjectCode + "Marks.csv" + " -R");
            PR.waitFor();
            String s = "cmd /c start /wait excel iiitv\\Semester\\" + sem + "\\" + subjectCode + "Marks.csv";
            Process p = Runtime.getRuntime().exec(s);
            p.waitFor();
            System.out.println("Making read only");
            PR = Runtime.getRuntime()
                    .exec("attrib " + "iiitv\\Semester\\" + sem + "\\" + subjectCode + "Marks.csv" + " +R");
            PR.waitFor();
        } catch (IOException e) {
        } catch (InterruptedException e) {
        }

    }

    public void openMarks(int sem, String subjectCode) {
        try {
            String s = "cmd /c start /wait excel /r iiitv\\Semester\\" + sem + "\\" + subjectCode + "Marks.csv";
            System.out.println(s);
            Process p = Runtime.getRuntime().exec(s);
            p.waitFor();
        } catch (IOException e) {
        } catch (InterruptedException e) {
        }
    }
}
