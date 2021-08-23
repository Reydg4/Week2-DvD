package App.com.rg.DAO;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;

import App.com.rg.DTO.Movie;
import App.com.rg.UI.Ui;


/**
 *
 * @author reyg
 * 
 */

// brain of the application
public class DvDDAO implements DvDDaoInterFace{
    
    private String FileName;
    private String DELIMETER = "::";
    private Ui userI = new Ui();
    
    // stores fileName to be used in entire app
    public DvDDAO(String fileName) throws Exception{
        //Scanner sc = new Scanner(new BufferedReader(new FileReader(FileName)));
        this.FileName = fileName;
       
    }
    // helper method that reads through file and returns an arrayList with all
    // the movies
    private ArrayList<Movie> readMovies() throws Exception{
        ArrayList<Movie> allMovies = new ArrayList<Movie>();
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader(FileName)));
        // loops through each line in the file
        while(sc.hasNextLine()){
            String movie = sc.nextLine();
            String [] currentMovie = movie.split(DELIMETER);
            // creats new movies using the information in each line of file
            Movie movieToAdd = new Movie(currentMovie[0],currentMovie[1],currentMovie[2],currentMovie[3],currentMovie[4],currentMovie[5]);
            allMovies.add(movieToAdd);
        }
        // returns array list
        return allMovies;
    }
    
     // helper method to get the spot at which a specific movie is located
    private int getSpot(String Title) throws Exception{
        ArrayList<Movie> allMovies = readMovies();
        int spot = 0;
        for(Movie movie: allMovies){
            if(Title.equals(movie.getTitle())){
                break;
            }
            else spot++;
        }
        return spot;
    }
    
    // adds movie to file
    @Override 
    public void AddMovie() throws Exception{
        PrintWriter pw = new PrintWriter(new FileWriter(FileName, true));
        String movie = userI.createMovie();
        pw.println(movie);
        pw.flush();
        pw.close();
    }
    
    // removes a movie from the file
    @Override
    public void RemoveMovie(String Title) throws Exception{
        // first, gets spot at which the movie is located in the file.
        int spot = getSpot(Title);
        
        // creates a temp file to copy everything too
        Scanner sc = new Scanner(new BufferedReader(new FileReader(FileName))); 
        PrintWriter pw = new PrintWriter(new FileWriter("tempFile.txt",true));
        String line;
        int currentSpot= 0;
        // loop through original file
        while(sc.hasNextLine()){
            // if movie to be removed is found, simply skip it. Dont copy it to 
            // the temp file
            if(currentSpot == spot){
                line = sc.nextLine();
            }else{
            // else copy each line to new file
                line = sc.nextLine();
                pw.println(line);
            }
            currentSpot++;
        }
        
        pw.flush();
        pw.close();
        // delete original file and rename temp file to original fileName
        File input = new File(FileName);
        File tempFile = new File("tempFile.txt");
        input.delete();
        boolean b = tempFile.renameTo(input);
        
        
    }
    
    // edits certain information on the file
    @Override
    public void EditMovie(String Title,int choice, String input) throws Exception{
        // first, get the line the movie will be on
        int spot = getSpot(Title);
        Scanner sc = new Scanner(new BufferedReader(new FileReader(FileName))); 
        PrintWriter pw = new PrintWriter(new FileWriter("tempFile.txt",true));
        String line;
        int currentSpot= 0;
        // loop through entire file and copy it to a tempFile
        while(sc.hasNextLine()){
            // if you got to the movie line that needs to be edited
            if(currentSpot == spot){
                line = sc.nextLine();
                // separate that line by the delimeter
                String [] lineSeperated = line.split("::");
                line = "";
                // loop through the original movies information and change the 
                // specific spot that needs new information. Everything else
                // is just added to the new line as normal
                for(int i = 1; i < 7; i++){
                    if(i == choice){
                        line = line + input;
                    }else{
                        line = line + lineSeperated[i - 1];
                    }
                    if(!(i == 6)){
                    line = line + "::";}
                }
                pw.println(line);
            // for any other line just copy it strait to the new file      
            }else{
                line = sc.nextLine();
                pw.println(line);
            }
            currentSpot++;
        }
        
        pw.flush();
        pw.close();
        // delete original file and rename the temp file to fileName
        File oldFile = new File(FileName);
        File tempFile = new File("tempFile.txt");
        oldFile.delete();
        boolean b = tempFile.renameTo(oldFile);
    }
    
    // Displays all Dvds
    @Override
    public void DisplayAllDvd() throws Exception{
        //gets an array with all movies and loops through each printing the title
        ArrayList<Movie> allMovies = readMovies();
        for(Movie movie: allMovies){
                    userI.DisplayDvD(movie);
                }
    }
    
    // Display one specific Dvd
    @Override
    public Movie DisplayOneDvd(String dvd)throws Exception{
        // gets an arraylist will all movie objects
        ArrayList<Movie> allMovies = readMovies();
        // gets the spot the movie we want is at
        int spot = getSpot(dvd);
        // loop through all the movies till we fine the movie we want and 
        // returns the movie
        for(Movie movie: allMovies){
            if(movie.getTitle().equals(dvd)){
                return movie;
            }
        }
        // null if the movie wasn't found 
        return null;
    }
    
   
}
