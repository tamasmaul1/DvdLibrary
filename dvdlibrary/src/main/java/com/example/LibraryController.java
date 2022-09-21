package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryController {
    public static Dvd add(String title, String date, String rating, String directorName, String note, ArrayList<Dvd> library){
        Dvd tmp = new Dvd();
        tmp.setData(title, date, rating, directorName, note);
        library.add(tmp);
        return tmp;
    }
    public static Dvd find(String title, ArrayList<Dvd> library){
        for(Dvd dvd : library){
            if(dvd.getTitle().equals(title)){
                return dvd;
            }
        }
        return null;
    }
    public static ArrayList<Dvd> OpenLibrary(){
        try{
            File file = new File("Library.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                Scanner scanner = new Scanner(fr);
                ArrayList<Dvd> library = new ArrayList<Dvd>();
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    String[] data = line.split(",",5);
                    Dvd dvd = new Dvd();
                    dvd.setData(data[0], data[1], data[2], data[3], data[4]);
                    library.add(dvd);
                }
                scanner.close();
                
                return library;
            }
            else{
                file.createNewFile();
                System.out.println("File created");
            }
        }
        catch(IOException e){
            System.out.println("IOException Occured");
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public static void CloseLibrary(ArrayList<Dvd> library){
        try{
            File file = new File("Library.txt");
            if (file.exists()) {
                FileWriter fw = new FileWriter(file);
                for(Dvd dvd : library){
                    System.out.println(dvd.getData());
                    fw.write(dvd.getTitle() + "," + dvd.getDate() + "," + dvd.getRating() + "," + dvd.getDirector() + "," + dvd.getUserNote());
                    fw.write(System.getProperty( "line.separator" ));
                }
                fw.close();
            }
        }
        catch(IOException e){
            System.out.println("IOException Occured");
                e.printStackTrace();
        }
    }
}
