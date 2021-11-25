package tec.bases.entity;

import java.sql.Date;

public class Film {

    private Long filmID;
    private String filmTittle;
    private Date filmReleaseDate;
    private Long filmCategory;


    public Film(Long _ID, String _tittle, Date _date, Long _category) {
        this.filmID = _ID;
        this.filmTittle = _tittle;
        this.filmReleaseDate = _date;
        this.filmCategory = _category;
    }

    public Film(String _tittle, Date _date, Long _category) {
        this.filmID = Long.valueOf(0);
        this.filmTittle = _tittle;
        this.filmReleaseDate = _date;
        this.filmCategory = _category;
    }


    /**
     * @return Long return the filmID
     */
    public Long getFilmID() {
        return filmID;
    }

    /**
     * @param filmID the filmID to set
     */
    public void setFilmID(Long filmID) {
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
     * @return Long return the filmCategory
     */
    public Long getFilmCategory() {
        return filmCategory;
    }

    /**
     * @param filmCategory the filmCategory to set
     */
    public void setFilmCategory(Long filmCategory) {
        this.filmCategory = filmCategory;
    }

    @Override
    public String toString() {
        return "   " +
            this.filmID + '\'' + "         " +
            this.filmTittle + "          " +
            this.filmReleaseDate + "           " +
            this.filmCategory + "      " +
            ' ';
    }

}
