package Common;

import java.io.*;


/**
 * Created by scapista on 12/2/16.
 * +
 * + Priority:
 * + 1. build failing
 * + 2. function not working
 * + 3. nice to have but would optimize
 * + 4. nice to have no benefit
 * + 5. future state
 */

public class HelperMethods {
    public static String getJsonFromFile(String infilename) {
        String jsonData = "";
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(infilename));
            while ((line = br.readLine()) != null) {
                jsonData += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return jsonData;
    }//end getJsonFromFile

    public static void outputfile(String str) {
/*
            try {
                Files.write(Paths.get("/Users/scapista/tmp/sqlfile.txt"), str.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                //exception handling left as an exercise for the reader
            }
            */
        System.out.println("outputfile");

        try
        {
            String filename= "/Users/scapista/tmp/sqlfile.txt";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(str);//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }

    }
}
