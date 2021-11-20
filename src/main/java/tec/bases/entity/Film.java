package tec.bases.entity;

import java.sql.Date;

public class Film {

    private int filmID;
    private String filmTittle;
    private Date filmReleaseDate;
    private int filmCategory;


    public Film(int _ID, String _tittle, Date _date, int _category) {
        this.filmID = _ID;
        this.filmTittle = _tittle;
        this.filmReleaseDate = _date;
        this.filmCategory = _category;
    }
    
    /**
     * @return int return the filmID
     */
    public int getFilmID() {
        return filmID;
    }

    /**
     * @param filmID the filmID to set
     */
    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    /**
     * @return String return the filmTittle
     */
    public String getFilmTittle() {
        return filmTittle;
    }

    /**
     * @param filmTittle the filmTittle to set
     */
    public void setFilmTittle(String filmTittle) {
        this.filmTittle = filmTittle;
    }

    /**
     * @return Date return the filmReleaseDate
     */
    public Date getFilmReleaseDate() {
        return filmReleaseDate;
    }

    /**
     * @param filmReleaseDate the filmReleaseDate to set
     */
    public void setFilmReleaseDate(Date filmReleaseDate) {
        this.filmReleaseDate = filmReleaseDate;
    }

    /**
     * @return int return the filmCategory
     */
    public int getFilmCategory() {
        return filmCategory;
    }

    /**
     * @param filmCategory the filmCategory to set
     */
    public void setFilmCategory(int filmCategory) {
        this.filmCategory = filmCategory;
    }

}
