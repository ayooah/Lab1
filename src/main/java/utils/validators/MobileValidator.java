package utils.validators;

import models.Contract;
import models.MobileContract;
import utils.validators.ContractValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MobileValidator extends ContractValidator {

    public List<String> validate(MobileContract contract) {
        List<String> res = new ArrayList<>();
        res.add(checkMinutes(contract));
        res.add(checkSms(contract));
        Iterator<String> iter = res.iterator();

        while (iter.hasNext()) {
            String[] arr = iter.next().split(",");
            if (Objects.equals(arr[0], "ok")) {
                iter.remove();
            }

        }
        res.addAll(super.validate(contract));
        return res;

    }

    private String checkMinutes(MobileContract contract) {
        if (contract.getCountMinutes() > 0) {
            return "ok";
        }
        return "error,count of minutes is a negative number";
    }

    private String checkSms(MobileContract contract) {
        if (contract.getCountSms() > 0) {
            return "ok";
        }
        return "error,count of sms is a negative number";
    }
}
