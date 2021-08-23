/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.com.rg.UI;

import App.com.rg.DTO.Movie;

/**
 *
 * @author reyg
 */
public interface UiInterFace {
    
    // display the main menu
    public int Menu();
    
    // Display a movie/dvd information
    public void DisplayDvD(Movie movie);
    
    //creates a string with all the information to be stored into the file
    public String createMovie();
    
    // Figures out what movie/dvd to delete
    public String MovieToDelete();
    
    // Figures out what movie/dvd to edit
    public String MovieToEdit();
    
    // Ask user what he wants to edit in the movie, makes sure its an int from
    // 0 - 7
    public int WhatToEdit();
    
    // Figures out what the selected information in the prev method needs 
    // to be changed to
    public String ChangeInfoTo();
    
    // Figures out what movie the user would like to look at
    public String MovieToDisplay();
    // Error message to throw up
    public void Error();
    
    // Ending message
    public void Exit();
}
