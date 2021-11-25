package tec.bases.entity;

import java.util.Date;

public class Loan {

    private long loanID;
    private long filmID;
    private long clientID;
    private Date loanDate;
    private Date loanDevolutionDate;
    private boolean state;

    public Loan(long _ID, long _filmID, long _clientID, Date _loanDate, Date _devolDate, boolean _state) {
        this.loanID = _ID;
        this.filmID = _filmID;
        this.clientID = _clientID;
        this.loanDate = _loanDate;
        this.loanDevolutionDate = _devolDate;
        this.state = _state;
    }

    public Loan(long _filmID, long _clientID, Date _loanDate) {
        this.loanID = 0;
        this.filmID = _filmID;
        this.clientID = _clientID;
        this.loanDate = _loanDate;
        this.loanDevolutionDate = null;
        this.state = false;
    }

    

   

    /**
     * @return long return the loanID
     */
    public long getLoanID() {
        return loanID;
    }

    /**
     * @param loanID the loanID to set
     */
    public void setLoanID(long loanID) {
        this.loanID = loanID;
    }

    /**
     * @return long return the filmID
     */
    public long getFilmID() {
        return filmID;
    }

    /**
     * @param filmID the filmID to set
     */
    public void setFilmID(long filmID) {
        this.filmID = filmID;
    }

    /**
     * @return long return the clientID
     */
    public long getClientID() {
        return clientID;
    }

    /**
     * @param clientID the clientID to set
     */
    public void setClientID(long clientID) {
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


    @Override
    public String toString() {
        return "   " +
            this.loanID + '\'' + "         " +
            this.filmID + "          " +
            this.clientID + "           " +
            this.loanDate + "      " +
            this.loanDevolutionDate + "        " +
            this.state +
            ' ';
    }
}
