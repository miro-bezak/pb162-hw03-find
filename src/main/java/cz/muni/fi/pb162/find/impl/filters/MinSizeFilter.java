package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;

/**
 * MinSizeFilter
 *
 * @author Miroslav Bezak
 */
public class MinSizeFilter extends BasicFilter {

    private long minSize;

    /**
     * @param paths list of filtered entries
     */
    public MinSizeFilter(List<SearchEntry> paths) {
        super(paths);
    }

    /**
     * @param paths list of filtered entries
     * @param minSize minimum size allowed for files
     */
    public MinSizeFilter(List<SearchEntry> paths, long minSize) {
        super(paths);
        this.minSize = minSize;
    }

    @Override
    public boolean filter(SearchEntry path) {
        return path.getSize() >= minSize;
    }
}
