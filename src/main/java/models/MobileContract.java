package models;

import java.time.LocalDate;
/**
 * Class describing a mobile contract
 * Class extends the Contract with the count minutes, count sms and count gb traffic fields
 * @see Contract
 * @autor Anna Ushakova
 */
public class MobileContract extends Contract {
    /**
     * Count of minutes in the contract
     */
    private  int countMinutes;
    /**
     * Count of sms in the contract
     */
    private  int countSms;



    /**
     * Count of gb traffic in the contract
     */
    private  int countGbTraffic;
    /**
     * Constructor - creating new mobile contract.
     * @param id of the contract
     * @param start of the contract
     * @param end of the contract
     * @param number of the contract
     * @param owner of the contract
     * @param countMinutes of the contract
     * @param countSms of the contract
     * @param countGbTraffic of the contract
     */
    public MobileContract(int id, LocalDate start, LocalDate end, int number, Person owner, int countMinutes, int countSms, int countGbTraffic) {
        super(id, start, end, number, owner);
        this.countMinutes = countMinutes;
        this.countSms = countSms;
        this.countGbTraffic = countGbTraffic;
    }
    public int getCountMinutes() {
        return countMinutes;
    }

    public void setCountMinutes(int countMinutes) {
        this.countMinutes = countMinutes;
    }

    public int getCountSms() {
        return countSms;
    }

    public void setCountSms(int countSms) {
        this.countSms = countSms;
    }

    public int getCountGbTraffic() {
        return countGbTraffic;
    }

    public void setCountGbTraffic(int countGbTraffic) {
        this.countGbTraffic = countGbTraffic;
    }

}
