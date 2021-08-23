package App.com.rg.Controller;
import App.com.rg.DAO.DvDDAO;
import App.com.rg.UI.Ui;
import App.com.rg.DTO.Movie;
import java.util.ArrayList;
/**
 *
 * @author reyg
 */

// controller class 
public class DvDController {
    
    public boolean userOption(int option) throws Exception{
        DvDDAO DAO = new DvDDAO("Movies.txt");
        Ui ui = new Ui();
        // option seven is for exiting main app
        boolean optionSeven = false;
        // a switch case for each option given to user
        switch (option){
            case 1:
                DAO.AddMovie();
                break;
            case 2: 
                String movieToDelete = ui.MovieToDelete();
                DAO.RemoveMovie(movieToDelete);
                break;
            case 3:
                String movieToEdit = ui.MovieToEdit();
                int whatToEdit = ui.WhatToEdit();
                String changeInfoTo = ui.ChangeInfoTo();
                DAO.EditMovie(movieToEdit, whatToEdit,changeInfoTo);
                break;
            case 4:
                DAO.DisplayAllDvd();
                break;
            case 5:
                String movieToDisplay = ui.MovieToDisplay();
                Movie movie = DAO.DisplayOneDvd(movieToDisplay);
                if(movie == null){ ui.Error();}
                else{
                    ui.DisplayDvD(movie);
                }
                break;
            case 6:
                optionSeven = true;
                break;
        }
        
        return optionSeven;
    }
}
