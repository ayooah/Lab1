package utils;

import models.Contract;
import utils.Sorter;

import java.util.Comparator;

public class SelectionSorter implements Sorter {
    /**
     * @param rep - source repository for sorting
     * @param comparator - sorting options
     * @return sorted repository
     */
    @Override
    public void sort(Repository rep, Comparator comparator) {
        Contract bufm;
        Contract bufc;
        for (int left = 0; left < rep.getSize(); left++) {
            int minInd = left;
            for (int i = left; i < rep.getSize(); i++) {
                if (comparator.compare(rep.getbyIndex(i).get(), rep.getbyIndex(minInd).get())<0) {
                    minInd = i;
                }
            }
            bufm= (Contract) rep.getbyIndex(minInd).get();
            bufc= (Contract) rep.getbyIndex(left).get();
            rep.removeByIndex(minInd);
            rep.addByIndex(bufc,minInd);
            rep.removeByIndex(left);
            rep.addByIndex(bufm,left);

        }

    }
}
