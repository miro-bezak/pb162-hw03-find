package cz.muni.fi.pb162.find.impl.actions;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.actions.FilterAction;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.impl.filters.FileContentFilter;
import cz.muni.fi.pb162.find.impl.filters.FileNameFilter;
import cz.muni.fi.pb162.find.impl.filters.MaxSizeFilter;
import cz.muni.fi.pb162.find.impl.filters.MinSizeFilter;

import java.util.List;

/**
 * FilterActionImpl
 * @author Miroslav Bezak
 */
public class FilterActionImpl implements FilterAction {
    private ApplicationOptions options;

    /**
     * @param options option object
     */
    public FilterActionImpl(ApplicationOptions options) {
        this.options = options;
    }

    @Override
    public List<SearchEntry> filter(List<SearchEntry> entries) {
        if (options.getSizeMin() != null) {
            MinSizeFilter minSizeFilter = new MinSizeFilter(entries, options.getSizeMin());
            entries = minSizeFilter.filtered();
        }
        if (options.getSizeMax() != null) {
            MaxSizeFilter maxSizeFilter = new MaxSizeFilter(entries, options.getSizeMax());
            entries = maxSizeFilter.filtered();
        }
        if (options.getNameRegex() != null) {
            FileNameFilter fileNameFilter = new FileNameFilter(entries, options.getNameRegex());
            entries = fileNameFilter.filtered();
        }
        if (options.getTextRegex() != null) {
            FileContentFilter fileContentFilter = new FileContentFilter(entries, options.getTextRegex());
            entries = fileContentFilter.filtered();
        }
        return entries;
    }
}
