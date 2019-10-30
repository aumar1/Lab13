package edu.cscc;

//Adil Umar, 10/29/19, Generate report based on file

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Census Class
 */
public class Census {

    /**
     * Read file and populate array of Surname objects
     * @param fname File containing list of surnames + other census data
     * @return list of names
     */
    public static Surname[] loadCensusData(String fname) {
        int line = 0; // Keep track of lines of file we've read
        Surname[] namelist = new Surname[100];

        //read file and populate array of Surname objects
        String name;
        int rank;
        int count;
        double proportion;

        try {
        File file = new File (fname);
        Scanner input = new Scanner (file);
            input.nextLine(); //Reads first line to skip over it
            while (input.hasNext() && line < 100) {
                String str = input.nextLine();
                String[] part = str.split(","); //Splits each line into an array
                //Puts each item in array into variable
                name = part[0];
                rank = Integer.parseInt(part[1]);
                count = Integer.parseInt(part[2]);
                proportion = Double.parseDouble(part[3]);
                namelist[line] = new Surname(name, rank, count, proportion); //dumps each item into appropriate place in namelist, which is used in main
                line++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + fname);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return namelist;
    }
}