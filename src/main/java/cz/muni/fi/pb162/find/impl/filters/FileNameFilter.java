package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.util.List;

/**
 * FileNameFilter
 *
 * @author Miroslav Bezak
 */
public class FileNameFilter extends BasicFilter {

    /**
     * Regex by which to filter the file names
     */
    private String regex;

    /**
     * @param paths list of filtered entries
     */
    public FileNameFilter(List<SearchEntry> paths) {
        super(paths);
    }

    /**
     * @param paths list of filtered entries
     * @param regex regex to match the file's name
     */
    public FileNameFilter(List<SearchEntry> paths, String regex) {
        super(paths);
        this.regex = regex;
    }

    @Override
    public boolean filter(SearchEntry path) {
        return path.getFileName().toString().matches(regex);
    }
}
