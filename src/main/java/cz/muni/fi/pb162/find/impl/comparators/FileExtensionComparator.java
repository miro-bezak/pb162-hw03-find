package cz.muni.fi.pb162.find.impl.comparators;

import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.tools.FileTools;

/**
 * FileExtensionComparator
 *
 * @author Miroslav Bezak
 */
public class FileExtensionComparator implements BasicComparator {
    private BasicComparator nextComparator;

    /**
     * @param nextComparator comparator to use when entries are equal
     */
    public FileExtensionComparator(BasicComparator nextComparator) {
        this.nextComparator = nextComparator;
    }

    @Override
    public BasicComparator getNextComparator() {
        return nextComparator;
    }

    @Override
    public int compare(SearchEntry searchEntry, SearchEntry t1) {
        String ext1 = FileTools.fileExtension(searchEntry.getPath());
        String ext2 = FileTools.fileExtension(t1.getPath());

        ext1 = ext1 == null ? "" : ext1;
        ext2 = ext2 == null ? "" : ext2;

        int result = ext1.compareTo(ext2);
        if (result == 0) {
            return getNextComparator().compare(searchEntry, t1);
        }
        return result;
    }
}
