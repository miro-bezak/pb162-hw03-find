package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;

/**
 * MaxSizeFilter
 * @author Miroslav Bezak
 */
public class MaxSizeFilter extends BasicFilter {

    /**
     * Maximum allowed file size
     */
    private long maxSize;

    /**
     * @param paths list of filtered entries
     */
    public MaxSizeFilter(List<SearchEntry> paths) {
        super(paths);
    }

    /**
     * @param paths list of filtered entries
     * @param maxSize maximum allowed size for file
     */
    public MaxSizeFilter(List<SearchEntry> paths, long maxSize) {
        super(paths);
        this.maxSize = maxSize;
    }

    @Override
    public boolean filter(SearchEntry path) {
        return path.getSize() <= maxSize;
    }
}
