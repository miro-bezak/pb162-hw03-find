package cz.muni.fi.pb162.find.impl.filters;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.filters.BasicFilter;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * FileContentFilter
 *
 * @author Miroslav Bezak
 */
public class FileContentFilter extends BasicFilter {

    /**
     * Regex that has to be contained somewhere in the file
     */
    private String regex;

    /**
     * @param paths list of filtered entries
     */
    public FileContentFilter(List<SearchEntry> paths) {
        super(paths);
    }

    /**
     * @param paths list of filtered entries
     * @param regex regex that has to be contained by the file's content
     */
    public FileContentFilter(List<SearchEntry> paths, String regex) {
        super(paths);
        this.regex = regex;
    }

    @Override
    public boolean filter(SearchEntry path) {
        try {
            String content = new String(Files.readAllBytes(path.getPath()));
            return content.matches(regex);
        } catch (IOException e) {
            return false;
        }
    }
}
