package LumaStudiosViewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Util.LumaStudioUtil;
/**import com.anncode.amazonviewer.model.Book;
import com.anncode.amazonviewer.model.Chapter;
import com.anncode.amazonviewer.model.Magazine;
import com.anncode.amazonviewer.model.Movie;
import com.anncode.amazonviewer.model.Serie;
import com.anncode.makereport.Report;
import com.anncode.util.AmazonUtil;
*/
import java.util.Iterator;

public class Main {
    static ArrayList<Movie> movies = Movie.makeMoviesList();
    static ArrayList<Series> series = Series.makeSeriesList();
    static ArrayList<Book> books = Book.makeBookList();

    public Main() {
    }

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        boolean exit = false;

        do {
            System.out.println("BIENVENIDOS Luma Studios VIEWER");
            System.out.println("");
            System.out.println("Selecciona el número de la opción deseada");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report Today");
            System.out.println("0. Exit");
            int response = LumaStudioUtil.validateUserResponseMenu(0, 6);
            switch (response) {
                case 0:
                    exit = false;
                    break;
                case 1:
                    showMovies();
                    break;
                case 2:
                    showSeries();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    showMagazines();
                    break;
                case 5:
                    makeReport();
                    exit = true;
                    break;
                case 6:
                    makeReport(new Date());
                    exit = true;
                    break;
                default:
                    System.out.println();
                    System.out.println("....¡¡Selecciona una opción!!....");
                    System.out.println();
                    exit = true;
            }
        } while(exit);

    }

    public static void showMovies() {
        boolean exit = true;

        do {
            System.out.println();
            System.out.println(":: MOVIES ::");
            System.out.println();

            int response;
            for(response = 0; response < movies.size(); ++response) {
                System.out.println(response + 1 + ". " + ((Movie)movies.get(response)).getTitle() + " Visto: " + ((Movie)movies.get(response)).isViewed());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();
            response = LumaStudioUtil.validateUserResponseMenu(0, movies.size());
            if (response == 0) {
                exit = false;
                showMenu();
                break;
            }

            if (response > 0) {
                Movie movieSelected = (Movie)movies.get(response - 1);
                movieSelected.setViewed(true);
                Date dateI = movieSelected.startToSee(new Date());

                for(int i = 0; i < 100000; ++i) {
                    System.out.println("..........");
                }

                movieSelected.stopToSee(dateI, new Date());
                System.out.println();
                System.out.println("Viste: " + movieSelected);
                System.out.println("Por: " + movieSelected.getDuration() + " minutos");
            }
        } while(exit);

    }

    public static void showSeries() {
        boolean exit = true;

        do {
            System.out.println();
            System.out.println(":: SERIES ::");
            System.out.println();

            int response;
            for(response = 0; response < series.size(); ++response) {
                System.out.println(response + 1 + ". " + ((Series)series.get(response)).getTitle() + " Visto: " + ((Series)series.get(response)).isViewed());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();
            response = LumaStudioUtil.validateUserResponseMenu(0, series.size());
            if (response == 0) {
                exit = false;
                showMenu();
            }

            if (response > 0) {
                showChapters(((Series)series.get(response - 1)).getChapters());
            }
        } while(exit);

    }

    public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
        boolean exit = true;

        do {
            System.out.println();
            System.out.println(":: CHAPTERS ::");
            System.out.println();

            int response;
            for(response = 0; response < chaptersOfSerieSelected.size(); ++response) {
                System.out.println(response + 1 + ". " + ((Chapter)chaptersOfSerieSelected.get(response)).getTitle() + " Visto: " + ((Chapter)chaptersOfSerieSelected.get(response)).isViewed());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();
            response = LumaStudioUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());
            if (response == 0) {
                exit = false;
            }

            if (response > 0) {
                Chapter chapterSelected = (Chapter)chaptersOfSerieSelected.get(response - 1);
                chapterSelected.setViewed(true);
                Date dateI = chapterSelected.startToSee(new Date());

                for(int i = 0; i < 100000; ++i) {
                    System.out.println("..........");
                }

                chapterSelected.stopToSee(dateI, new Date());
                System.out.println();
                System.out.println("Viste: " + chapterSelected);
                System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
            }
        } while(exit);

    }

    public static void showBooks() {
        boolean exit = true;

        do {
            System.out.println();
            System.out.println(":: BOOKS ::");
            System.out.println();

            int response;
            for(response = 0; response < books.size(); ++response) {
                System.out.println(response + 1 + ". " + ((Book)books.get(response)).getTitle() + " Leído: " + ((Book)books.get(response)).isReaded());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();
            response = LumaStudioUtil.validateUserResponseMenu(0, books.size());
            if (response == 0) {
                exit = false;
                showMenu();
            }

            if (response > 0) {
                Book bookSelected = (Book)books.get(response - 1);
                bookSelected.setReaded(true);
                Date dateI = bookSelected.startToSee(new Date());

                for(int i = 0; i < 100000; ++i) {
                    System.out.println("..........");
                }

                bookSelected.stopToSee(dateI, new Date());
                System.out.println();
                System.out.println("Leíste: " + bookSelected);
                System.out.println("Por: " + bookSelected.getTimeReaded() + " milisegundos");
            }
        } while(exit);

    }

    public static void showMagazines() {
        ArrayList<Magazin> magazines = Magazin.makeMagazineList();
        boolean exit = false;

        do {
            System.out.println();
            System.out.println(":: MAGAZINES ::");
            System.out.println();

            int response;
            for(response = 0; response < magazines.size(); ++response) {
                System.out.println(response + 1 + ". " + ((Magazin)magazines.get(response)).getTitle());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();
            response = LumaStudioUtil.validateUserResponseMenu(0, 0);
            if (response == 0) {
                exit = false;
                showMenu();
            }
        } while(exit);

    }

    public static void makeReport() {
        Report report = new Report();
        report.setNameFile("reporte");
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");
        String contentReport = "";
        Iterator var3 = movies.iterator();

        while(var3.hasNext()) {
            Movie movie = (Movie)var3.next();
            if (movie.getIsViewed()) {
                contentReport = contentReport + movie.toString() + "\n";
            }
        }

        var3 = series.iterator();

        while(var3.hasNext()) {
            Series serie = (Series)var3.next();
            ArrayList<Chapter> chapters = serie.getChapters();
            Iterator var6 = chapters.iterator();

            while(var6.hasNext()) {
                Chapter chapter = (Chapter)var6.next();
                if (chapter.getIsViewed()) {
                    contentReport = contentReport + chapter.toString() + "\n";
                }
            }
        }

        var3 = books.iterator();

        while(var3.hasNext()) {
            Book book = (Book)var3.next();
            if (book.getIsReaded()) {
                contentReport = contentReport + book.toString() + "\n";
            }
        }

        report.setContent(contentReport);
        report.makeReport();
        System.out.println("Reporte Generado");
        System.out.println();
    }

    public static void makeReport(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-h-m-s-S");
        String dateString = df.format(date);
        Report report = new Report();
        report.setNameFile("reporte" + dateString);
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");
        SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM Y");
        dateString = dfNameDays.format(date);
        String contentReport = "Date: " + dateString + "\n\n\n";
        Iterator var7 = movies.iterator();

        while(var7.hasNext()) {
            Movie movie = (Movie)var7.next();
            if (movie.getIsViewed()) {
                contentReport = contentReport + movie.toString() + "\n";
            }
        }

        var7 = series.iterator();

        while(var7.hasNext()) {
            Series serie = (Series)var7.next();
            ArrayList<Chapter> chapters = serie.getChapters();
            Iterator var10 = chapters.iterator();

            while(var10.hasNext()) {
                Chapter chapter = (Chapter)var10.next();
                if (chapter.getIsViewed()) {
                    contentReport = contentReport + chapter.toString() + "\n";
                }
            }
        }

        var7 = books.iterator();

        while(var7.hasNext()) {
            Book book = (Book)var7.next();
            if (book.getIsReaded()) {
                contentReport = contentReport + book.toString() + "\n";
            }
        }

        report.setContent(contentReport);
        report.makeReport();
        System.out.println("Reporte Generado");
        System.out.println();
    }
}