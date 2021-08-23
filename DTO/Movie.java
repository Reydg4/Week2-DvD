package App.com.rg.DTO;

/**
 *
 * @author reyg
 */

// Movie/Dvd class for building each one
public class Movie {
    
    private String Title;
    private String ReleaseDate;
    private String MPAArating;
    private String DirectorName;
    private String Studio;
    private String Note = " ";

    public Movie(String Title, String ReleaseDate, String MPAArating, String DirectorName, String Studio, String Note) {
        this.Title = Title;
        this.ReleaseDate = ReleaseDate;
        this.MPAArating = MPAArating;
        this.DirectorName = DirectorName;
        this.Studio = Studio;
        if(Note.equals("")){
            this.Note = "N/A";
        }else {
        this.Note = Note;
        }
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
    }

    public String getMPAArating() {
        return MPAArating;
    }

    public void setMPAArating(String MPAArating) {
        this.MPAArating = MPAArating;
    }

    public String getDirectorName() {
        return DirectorName;
    }

    public void setDirectorName(String DirectorName) {
        this.DirectorName = DirectorName;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String Studio) {
        this.Studio = Studio;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
}
