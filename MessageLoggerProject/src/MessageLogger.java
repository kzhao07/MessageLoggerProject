import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MessageLogger {
    private static MessageLogger single_instance = null;

    private File f;

    private MessageLogger()
    {
        f = new File("msgs.txt");
    }

    public static MessageLogger getInstance(){
        if (single_instance == null){
            single_instance = new MessageLogger();
        }
        return single_instance;
    }

    public void logMessage(String s){
        try{
            FileWriter fw = new FileWriter("msgs.txt", true);
            fw.write(s + "\n");
            fw.close();
        } catch (IOException e){
            System.out.println("Unknown error encountered");
            System.exit(1);
        }
    }

    public void printAll(){
        try {
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
        } catch (Exception e){
            System.out.println("Unknown Error Encountered");
            System.exit(1);
        }

    }

}
