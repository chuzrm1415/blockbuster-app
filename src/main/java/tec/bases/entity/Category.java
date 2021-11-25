package tec.bases.entity;

public class Category {

    private Long catID;
    private String catDescription;


    public Category(Long _ID, String _catDescrip) {
        this.catID = _ID;
        this.catDescription = _catDescrip;
    }
    
    /**
     * @return Long return the catID
     */
    public Long getCatID() {
        return catID;
    }

    /**
     * @param catID the catID to set
     */
    public void setCatID(Long catID) {
        this.catID = catID;
    }

    /**
     * @return String return the catDescription
     */
    public String getCatDescription() {
        return catDescription;
    }

    /**
     * @param catDescription the catDescription to set
     */
    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    @Override
    public String toString() {
        return "   " +
            this.catID + '\'' + "             " +
            this.catDescription + " " +
            ' ';
    }

}
