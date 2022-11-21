package LumaStudiosViewer;

import java.util.ArrayList;
import java.util.Date;

public class Magazin extends Publications {

    private int id;

    public Magazin(String title, Date edititionDate, String editorial) {
        super(title, edititionDate, editorial);
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String detailMagazine = "\n :: MAGAZINE ::" +
                "\n Title: " + getTitle() +
                "\n Editorial: " + getEditorial() +
                "\n Edition Date: " + getEdititionDate() +
                "\n Authors: ";
        for (int i = 0; i < getAuthors().length; i++) {
            detailMagazine += "\t" + getAuthors()[i] + " ";
        }
        return  detailMagazine;
    }

    public static ArrayList<Magazin> makeMagazineList() {
        ArrayList<Magazin> magazines = new ArrayList();
        String[] authors = new String[3];
        for (int i = 0; i < 3; i++) {
            authors[i] = "author "+i;
        }
        for (int i = 1; i <= 5; i++) {
            magazines.add(new Magazin("LumaStudiosViewer.Magazine " + i, new Date(), "Editorial " + i));
        }

        return magazines;
    }

}

