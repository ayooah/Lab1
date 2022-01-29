package utils.sorters;

import models.Contract;
import utils.Repository;

import java.util.Comparator;

public class BubbleSorter implements Sorter {
    /**
     * @param rep - source repository for sorting
     * @param comparator - sorting options
     * @return sorted repository
     */
    @Override
    public void sort(Repository rep, Comparator comparator) {
        boolean isSorted = false;
        Contract buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < rep.getSize()-1; i++) {
                if(comparator.compare(rep.getbyIndex(i).get(),rep.getbyIndex(i+1).get())>0){
                    isSorted = false;

                    buf = (Contract) rep.getbyIndex(i).get();
                    rep.removeByIndex(i);
                    rep.addByIndex(buf,i+1);
                }
            }
        }
    }
}
