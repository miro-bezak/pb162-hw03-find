package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * FileSizeComparator
 * @author Miroslav Bezak
 */
public class FileSizeComparator implements BasicComparator {
    private BasicComparator nextComparator;

    /**
     * @param nextComparator comparator to use when entries are equal
     */
    public FileSizeComparator(BasicComparator nextComparator) {
        this.nextComparator = nextComparator;
    }

    @Override
    public BasicComparator getNextComparator() {
        return nextComparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {
        int result = Math.toIntExact(searchEntry.getSize() - t1.getSize());
        if (result == 0){
            return getNextComparator().compare(searchEntry, t1);
        }
        return result;
    }
}
