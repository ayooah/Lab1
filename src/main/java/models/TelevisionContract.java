package models;
import java.time.LocalDate;
import java.util.List;
/**
 * Class describing a digital television  contract
 * Class extends the Contract with the channels list field
 * @see Contract
 * @autor Anna Ushakova
 */
public class TelevisionContract extends Contract {


    /**
     * The list of channels in the contract
     */
    List<Channels> channelsList;
    /**
     * Constructor - creating new digital television contract.
     * @param id of the contract
     * @param start of the contract
     * @param end of the contract
     * @param number of the contract
     * @param owner of the contract
     * @param channelsList of the contract
     */
    public TelevisionContract(int id, LocalDate start, LocalDate end, int number, Person owner, List<Channels> channelsList) {
        super(id, start, end, number, owner);
        this.channelsList = channelsList;
    }
    public List<Channels> getChannelsList() {
        return channelsList;
    }

    public void setChannelsList(List<Channels> channelsList) {
        this.channelsList = channelsList;
    }
}
