package models;

import java.time.LocalDate;
/**
 * Class describing wired internet contract
 * Class extends the Contract with the connection speed field
 * @see Contract
 * @autor Anna Ushakova
 */
public class InternetContract extends Contract {


    /**
     * Internet connection speed in the contract
     */
    private int connectionSpeed;
    /**
     * Constructor - creating new wired internet contract.
     * @param id of the contract
     * @param start of the contract
     * @param end of the contract
     * @param number of the contract
     * @param owner of the contract
     * @param connectionSpeed of the contract
     */
    public InternetContract(int id, LocalDate start, LocalDate end, int number, Person owner, int connectionSpeed) {
        super(id, start, end, number, owner);
        this.connectionSpeed = connectionSpeed;
    }
    public int getConnectionSpeed() {
        return connectionSpeed;
    }

    public void setConnectionSpeed(int connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }
}
