package LumaStudiosViewer;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publications implements IVisualizable {
    private int id;
    private String isbn;
    private boolean readed;
    private int timeReaded;


    public Book(String title, Date edititionDate, String editorial, String authors) {
        super(title, edititionDate, editorial);
        // TODO Auto-generated constructor stub
    }


    public int getId() {
        return id;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String isReaded() {
        String leido = "";
        if(readed == true) {
            leido = "Sí";
        }else {
            leido = "No";
        }

        return leido;
    }


    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public boolean getIsReaded() {
        return readed;
    }


    public int getTimeReaded() {
        return timeReaded;
    }


    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String detailBook = "\n :: BOOK ::" +
                "\n Title: " + getTitle() +
                "\n Editorial: " + getEditorial() +
                "\n Edition Date: " + getEdititionDate() +
                "\n Authors: " + getAuthors();

        return  detailBook;
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
            setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
        }else {
            setTimeReaded(0);
        }
    }


    public static ArrayList<Book> makeBookList() {
        ArrayList<Book> books = new ArrayList();

        //for (int i = 1; i <= 5; i++) {
            books.add(new Book("Los Dias del Venado " , new Date(), "Epulibre " , "Liliana Bodoc"));
            books.add(new Book("Los Dias De Las Sombras " , new Date(), "editorial " , "Liliana Bodoc"));
            books.add(new Book("Los Dias Del Fuego" , new Date(), "editorial " , "Liliana Bodoc"));
            books.add(new Book("Harry Potter" , new Date(), "editorial " , "J.K Rowling"));
            books.add(new Book("El Alquimista " , new Date(), "editorial " , "Paulo Coelho"));

        //}

        return books;
    }

}
