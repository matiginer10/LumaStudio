package LumaStudiosViewer;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable {

    private int id;
    private int timeViewed;


    public Movie(String title, String genre, String creator, int duration, short year) {
        super(title, genre, creator, duration);
        setYear(year);
    }


    public int getId() {
        return id;
    }


    public int getTimeViewed() {
        return timeViewed;
    }
    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "\n :: MOVIE ::" +
                "\n Title: " + getTitle() +
                "\n Genero: " + getGenre() +
                "\n Year: " + getYear() +
                "\n Creator: " + getCreator() +
                "\n Duration: " + getDuration();
    }

    @Override
    public Date startToSee(Date dateI) {
        // TODO Auto-generated method stub
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        // TODO Auto-generated method stub

        if (dateF.getTime() > dateI.getTime()) {
            setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
        }else {
            setTimeViewed(0);
        }


    }

    public static ArrayList<Movie> makeMoviesList() {
        ArrayList<Movie> movies = new ArrayList();

        //for (int i = 0; i <= 10; i++) {
            movies.add(new Movie("The Notebook ", "Romantic " , "Nick Cassavetes" , 120, (short)(2004)));
            movies.add(new Movie("Inception" , "Science fiction" , " Christopher Nolan " , 129, (short)(2010)));
            movies.add(new Movie("Interestelar ", "Adventure ", "Christopher Nolan  ", 169, (short)(2014)));
            movies.add(new Movie("The Lord of the Rings", "Science fiction ", "Peter Jackson ", 201 , (short)(2004)));
            movies.add(new Movie("Pulp Fiction", "Black Comedy ",  "Quentin Tarantino ", 154, (short)(1994)));
            movies.add(new Movie("Jurassic Park ", "Adventure", "Steven Spielberg ", 127, (short)(1993)));
            movies.add(new Movie("Avengers: Endgame ", "Action ", "Marvel Studios  ", 181, (short)(2019)));
            movies.add(new Movie("Gladiator", "Action ", "Ridley Scott ", 155, (short)(2000)));
            movies.add(new Movie("Back to the Future", "Science fiction, Adventure, Comedy ", " Robert Zemeckis —Bob Gale  ", 117, (short)(1985)));
            movies.add(new Movie("The Shining", "psychological terro ", "Stanley Kubrick ", 114, (short)(1980)));
        //}

        return movies;
    }


    @Override
    public void view() {
        // TODO Auto-generated method stub
    }

}