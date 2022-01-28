package models;

import java.time.LocalDate;
/**
 * Abstract class for describing the main properties of contracts
 * @autor Anna Ushakova
 */
public abstract class Contract {
    /**
     * ID of the contract
     */
    private int id;
    /**
     * Start date of the contract
     */
    private LocalDate start;
    /**
     * Сontract expiration date
     */
    private LocalDate end;
    /**
     * Number of the contract
     */
    private int number;
    /**
     * The owner of the contract
     */
    private Person owner;
    /**
     * Constructor - creating new contract.
     * @param id of the contract
     * @param start of the contract
     * @param end of the contract
     * @param number of the contract
     * @param owner of the contract
     */
    public Contract(int id, LocalDate start, LocalDate end, int number, Person owner) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.number = number;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public int getNumber() {
        return number;
    }

    public Person getOwner() {
        return owner;
    }
}
