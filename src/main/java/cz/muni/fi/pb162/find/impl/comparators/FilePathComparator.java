package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;

/**
 * FilePathComparator
 *
 * @author Miroslav Bezak
 */
public class FilePathComparator implements BasicComparator {
    @Override
    public BasicComparator getNextComparator() {
        return null;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {
        String path1 = searchEntry.getPath().toFile().getAbsolutePath();
        String path2 = t1.getPath().toFile().getAbsolutePath();

        return path1.compareTo(path2);
    }
}
