package tec.bases.entity;

public class Category {

    private int catID;
    private String catDescription;


    public Category(int _ID, String _catDescrip) {
        this.catID = _ID;
        this.catDescription = _catDescrip;
    }
    
    /**
     * @return int return the catID
     */
    public int getCatID() {
        return catID;
    }

    /**
     * @param catID the catID to set
     */
    public void setCatID(int catID) {
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

}
