/* 
 * Author: Mauricio Lopez Alvarez                                           **
 * Date written: February 7, 2024                                           **
 * Purpose:... Create a program that is able to read in a list of values,   **
 * ............sort that list, then output the result into a separate file. **
 */
package cop2805;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class IOAssignment 
{
    public static void main(String[] args) 
    {
        // Variables and Paths
        Path path1 = Paths.get("../IOAssignment/data.txt");
        Path path2 = Paths.get("data-sorted.txt");
        List<Double> data = new ArrayList<>();
        
        // Read and Output file content
        data = readFile(path1.toString());
        
        // Sorting List
        Collections.sort(data);
        
        // Write sorted data in data-sorted.txt file
        writeFile(data, path2.toString());
    } // end main
    
    public static List<Double> readFile(String file)
    {
        // Variables and Paths
        List<Double> data = new ArrayList<>();
        Path path = Paths.get(file);
        
        try
        {
            // Opens file if found
            BufferedReader br = Files.newBufferedReader(path,Charset.defaultCharset());
            String line = br.readLine();
            
            while(line != null)
            {
                //Output file content
                System.out.println(line);
                data.add(Double.parseDouble(line));
                line = br.readLine();
            } // end while
            
            // Close stream
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("Error: File not found!");
        }
        
        return data;
    } // end readFile method
    
    public static void writeFile(List<Double> data, String file)
    {
        // Paths
        Path newFile = Paths.get(file);
        
        // Creates the path2 file 
        try(BufferedWriter bf = Files.newBufferedWriter
            (newFile, StandardOpenOption.CREATE);
                PrintWriter pw = new PrintWriter(new BufferedWriter(bf)))
        {
            // Writing to the new file
            pw.write("Sorted List:\n");
            for(Double x: data)
            {
                // Write each element in the file
                pw.write(x + "\n");
            } // end for
            
            // Close stream
            pw.close();
        }
        catch(IOException e)
        {
            System.out.println("Error!");
        }
    } // end writeFile method
} // end IOAssignment class