/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.com.rg.DAO;

import App.com.rg.DTO.Movie;
import java.util.ArrayList;

/**
 *
 * @author reyg
 */
public interface DvDDaoInterFace {
    // adds movie to file
    public void AddMovie() throws Exception;
    
    // removes a movie from the file
    public void RemoveMovie(String Title) throws Exception;
    
    // edits certain information on the file
    public void EditMovie(String Title,int choice, String input) throws Exception;
    
    // Displays all Dvds
    public void DisplayAllDvd() throws Exception;
    
    // Display one specific Dvd
    public Movie DisplayOneDvd(String dvd) throws Exception;
}
