package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    static String COMMANDOPTIONS = "add, remove, edit, find, exit";

    public static void run(ArrayList<Dvd> library) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ented the command you want to use: " + COMMANDOPTIONS);
        String command = scanner.nextLine();
        while(!command.equals("exit")){
            UserInterface.processCommand(command, scanner, library);
            System.out.println("Ented the command you want to use: " + COMMANDOPTIONS);
            command = scanner.nextLine();
        }
        scanner.close();
    }

    public static ArrayList<Dvd> processCommand(String command, Scanner scanner, ArrayList<Dvd> library){
        switch(command){
            case "add":{
                System.out.println("Enter the data of the dvd in the following patter: 'title,date,rating,directorName,note'");
                String dvdData = scanner.nextLine();
                if(dvdData != "cancel"){
                    String[] data = dvdData.split(",",5);
                    LibraryController.add(data[0], data[1], data[2], data[3], data[4], library);
                }
                break;
            }
            case "remove":{
                System.out.println("Enter the title of the dvd you want to remove.");
                String dvdTitle = scanner.nextLine();
                Dvd dvd = LibraryController.find(dvdTitle, library);
                library.remove(dvd);
                break;
            }
            case "edit":{
                System.out.println("Enter the title of the dvd you want to edit.");
                String dvdTitle = scanner.nextLine();
                Dvd dvd = LibraryController.find(dvdTitle, library);
                System.out.println(dvd.getData());
                System.out.println("Enter the edited data, must fill every field in the following pattern: 'title,date,rating,directorName,note' or write cancel.");
                String editedDvd = scanner.nextLine();
                if(editedDvd != "cancel"){
                    String[] data = editedDvd.split(",",5);
                    dvd.setData(data[0], data[1], data[2], data[3], data[4]);
                }
                break;
            }
            case "find":{
                System.out.println("Enter the title of the dvd you want to find, or list all of them with the 'all' command.");
                String dvdTitle = scanner.nextLine();
                if(dvdTitle.equals("all")){
                    for(Dvd dvd : library){
                        System.out.println(dvd.getData());
                    }
                    break;
                }
                Dvd dvd = LibraryController.find(dvdTitle, library);
                System.out.println("Enter the information of the dvd you want to see.(title,date,rating,directorname,note,all): ");
                String info = scanner.nextLine();
                if(dvd != null){
                    switch(info){
                        case "title":{
                            System.out.println("Title: " + dvd.getTitle());
                            break;
                        }
                        case "date":{
                            System.out.println("Date: " + dvd.getDate());
                            break;
                        }
                        case "rating":{
                            System.out.println("Title: " + dvd.getRating());
                            break;
                        }
                        case "directorname":{
                            System.out.println("Title: " + dvd.getDirector());
                            break;
                        }
                        case "note":{
                            System.out.println("Title: " + dvd.getUserNote());
                            break;
                        }
                        case "all":{
                            System.out.println(dvd.getData());
                            break;
                        }
                    }
                }
            }
        }
        return library;
    }
}
