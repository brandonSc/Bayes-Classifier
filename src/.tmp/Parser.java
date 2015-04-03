import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Parser
{
    public static void main ( String args[] ) { 

        try {
            String fileName = "./input.txt";
            Path path = Paths.get(fileName);

            Scanner scanner = new Scanner(path);
            scanner.useDelimiter(System.getProperty("line.separator"));

            Writer writer = new FileWriter("output.txt");


            while(scanner.hasNext()){

                String line = scanner.next();

                char[] c = line.toCharArray();
                ArrayList<Character> chars = new ArrayList<Character>();
                for ( int i=0; i<c.length; i++ ) 
                    chars.add(c[i]);

                for ( int  i=0; i<chars.size(); i++ ) { 
                    if ( chars.get(i).equals(' ')
                      || chars.get(i).equals('\t')
                      && !chars.get(i-1).equals(' ') 
                      && !chars.get(i-1).equals(',') ) {  
                        chars.add(i, ',');
                    }
                }


                c = new char[chars.size()];
                for ( int i=0; i<chars.size(); i++ )
                    c[i] = (char)chars.get(i);

                writer.write("Array("+new String(c)+"),\n");

            }
            scanner.close();
            writer.close();
        } catch ( Exception e ) { 
            e.printStackTrace();
        }
    }
}
