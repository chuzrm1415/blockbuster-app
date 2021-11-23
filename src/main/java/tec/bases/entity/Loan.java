package tec.bases.entity;

import java.util.Date;

public class Loan {

    private int loanID;
    private int filmID;
    private int clientID;
    private Date loanDate;
    private Date loanDevolutionDate;
    private boolean state;

    public Loan(int _ID, int _filmID, int _clientID, Date _loanDate, Date _devolDate, boolean _state) {
        this.loanID = _ID;
        this.filmID = _filmID;
        this.clientID = _clientID;
        this.loanDate = _loanDate;
        this.loanDevolutionDate = _devolDate;
        this.state = _state;
    }

    /**
     * @return int return the loanID
     */
    public int getLoanID() {
        return loanID;
    }

    /**
     * @param loanID the loanID to set
     */
    public void setLoanID(int loanID) {
        this.loanID = loanID;
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
     * @return int return the clientID
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * @param clientID the clientID to set
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * @return Date return the loanDate
     */
    public Date getLoanDate() {
        return loanDate;
    }

    /**
     * @param loanDate the loanDate to set
     */
    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    /**
     * @return Date return the loanDevolutionDate
     */
    public Date getLoanDevolutionDate() {
        return loanDevolutionDate;
    }

    /**
     * @param loanDevolutionDate the loanDevolutionDate to set
     */
    public void setLoanDevolutionDate(Date loanDevolutionDate) {
        this.loanDevolutionDate = loanDevolutionDate;
    }

    /**
     * @return boolean return the state
     */
    public boolean isState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(boolean state) {
        this.state = state;
    }

}
