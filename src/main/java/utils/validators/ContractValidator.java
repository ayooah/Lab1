package utils.validators;

import models.Contract;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ContractValidator {
    public List<String> validate(Contract contract) {
        List<String> validationResults = new ArrayList<>();
        validationResults.add(checkId(contract));
        validationResults.add(checkDate(contract));
        validationResults.add(checkSerialNumberOfPassport(contract));
        Iterator<String> iter = validationResults.iterator();

        while (iter.hasNext()) {
            String[] arr = iter.next().split(",");
            if (Objects.equals(arr[0], "ok")) {
                iter.remove();
            }

        }
        return validationResults;
    }

    private String checkId(Contract contract) {
        if (contract.getId() > 0) {
            return "ok";
        }
        return "error,id is a negative number";
    }

    private String checkDate(Contract contract) {
        if (contract.getStart().isBefore(contract.getEnd())) {
            return "ok";
        }
        return "error,the start date must be before the end date";
    }

    private String checkSerialNumberOfPassport(Contract contract) {
        String[] arr = contract.getOwner().getSerialNumberOfPassport().split(" ");
        int year = Integer.parseInt(arr[0]);
        if (year < LocalDate.now().getYear()) {
            return "ok";
        }
        return "error,incorrect passport series";
    }
}
