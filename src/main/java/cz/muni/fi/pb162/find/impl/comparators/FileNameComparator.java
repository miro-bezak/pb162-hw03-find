package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * FileNameComparator
 *
 * @author Miroslav Bezak
 */
public class FileNameComparator implements BasicComparator {
    private BasicComparator nextComparator;

    /**
     * @param nextComparator comparator to use when entries are equal
     */
    public FileNameComparator(BasicComparator nextComparator) {
        this.nextComparator = nextComparator;
    }

    @Override
    public BasicComparator getNextComparator() {
        return nextComparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {
        String name1 = searchEntry.getPath().getFileName().toString();
        String name2 = t1.getPath().getFileName().toString();

        int result = name1.compareTo(name2);
        if (result == 0) {
            return getNextComparator().compare(searchEntry, t1);
        }
        return result;
    }
}
