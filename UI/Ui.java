package App.com.rg.UI;

/**
 *
 * @author reyg
 */
import App.com.rg.DTO.Movie;
import java.util.Scanner;

//Ui Package for all printing to console

public class Ui implements UiInterFace{
    
    final private static Scanner sc = new Scanner(System.in);
    
    @Override
    // display the main menu
    public int Menu(){
        int option = 0;
        boolean num = false;
        // makes sure input is a number between 0 and 7 or else keep asking
        // for a number
        while(!num){
            try{
                System.out.println("======Menu======");
                System.out.println("1) Add a DvD");     
                System.out.println("2) Remove a DvD"); 
                System.out.println("3) Edit a DvD info");   
                System.out.println("4) List all DvDs");   
                System.out.println("5) Show a particular DvD/By Title");    
                System.out.println("6) Exit DvD Program");  
                System.out.println("================");
               
                option = Integer.parseInt(sc.nextLine());
                if(option > 0 && option < 7){
                    num = true;
                }
            }catch(Exception e){
                continue;
            }
        }  
        return option;
    }
    
    @Override
    // Display a movie/dvd information
    public void DisplayDvD(Movie movie){
        System.out.println("===" + movie.getTitle() + "===");
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Release Date: " + movie.getReleaseDate());
        System.out.println("MPAA Rating:" + movie.getMPAArating());
        System.out.println("Director's Name:" + movie.getDirectorName());
        System.out.println("Studio: " + movie.getStudio());
        System.out.println("User Rating/Notes:" + movie.getNote());
        System.out.println("====================");
     
    }
    
    @Override
    //creates a string with all the information to be stored into the file
    public String createMovie(){
        String DELIMETER = "::";
        System.out.println("Please enter Title: ");
        String Title = sc.nextLine();
        System.out.println("Please enter Release date: ");
        String RD = sc.nextLine();
        System.out.println("Please eenter MPAA rating: ");
        String Rating = sc.nextLine();
        System.out.println("Please enter Directors Name: ");
        String Name = sc.nextLine();
        System.out.println("Please enter Studio: ");
        String Studio = sc.nextLine();
        System.out.println("Any notes? (N/A if not): ");
        String Notes = sc.nextLine();
        return (Title + DELIMETER + RD + DELIMETER + Rating + DELIMETER + 
                Name + DELIMETER + Studio + DELIMETER + Notes);
   }
    
    @Override
    // Figures out what movie/dvd to delete
    public String MovieToDelete(){
        System.out.println("What movie will you delete? ");
        return sc.nextLine();
    }
    
    @Override
    // Figures out what movie/dvd to edit
    public String MovieToEdit(){
        System.out.println("What movie will you edit? ");
        return sc.nextLine();
    }
    
    @Override
    // Ask user what he wants to edit in the movie, makes sure its an int from
    // 0 - 7
    public int WhatToEdit(){
        int option = 0;
        boolean num = false;
        while(!num){
            try{
                System.out.println("======WhatToEdit======");
                System.out.println("1) TItle");     
                System.out.println("2) Release date");  
                System.out.println("3) MPAA ratting");   
                System.out.println("4) Directors Name");
                System.out.println("5) Studio");
                System.out.println("6) Notes ");
                System.out.println("================");
               
                option = Integer.parseInt(sc.nextLine());
                if(option > 0 && option < 7){
                    num = true;
                }
            }catch(Exception e){
                continue;
            }
        }  
        return option; 
    }
    
    @Override
    // Figures out what the selected information in the prev method needs 
    // to be changed to
    public String ChangeInfoTo(){
        System.out.println("What do you want the new information to be?: ");
        return sc.nextLine();
    }
    
    @Override
    // Figures out what movie the user would like to look at
    public String MovieToDisplay(){
        System.out.println("What Dvd would you like to see: ");
        return sc.nextLine();
    }
    
    @Override
    // Error message to throw up
    public void Error(){
        System.out.println("There was an error!");
    }
    
    @Override
    // Ending message
    public void Exit(){
        System.out.println("==============");
        System.out.println("Hope you found your movie! Come again!");
        System.out.println("==============");
    }
}
