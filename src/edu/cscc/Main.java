package edu.cscc;

//Adil Umar, 10/29/19, Generate report based on file

/**
 * Main Class
 * @author Adil Umar
 * @version 1.0
 */
public class Main {

    private final static String CENSUSDATAFNAME = "Surnames_2010Census.csv";

    /**
     * Application entry point
     * @param args array of command-line arguments for application
     */
    public static void main(String[] args) {

        Surname[] namelist = Census.loadCensusData(CENSUSDATAFNAME);

        if (namelist != null) {
            System.out.println("Rank\tName");
            for (Surname name : namelist) {
                System.out.println(name.getRank() + "\t\t" + name.getName());
            }
        }
    }
}