package cz.muni.fi.pb162.find.impl.actions;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.actions.SortAction;
import cz.muni.fi.pb162.find.comparators.BasicComparator;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.tools.SortFactory;

import java.util.List;

/**
 * SortActionImpl
 *
 * @author Miroslav Bezak
 */
public class SortActionImpl implements SortAction {
    private ApplicationOptions options;

    /**
     * @param options options object
     */
    public SortActionImpl(ApplicationOptions options) {
        this.options = options;
    }

    @Override
    public List<SearchEntry> sorted(List<SearchEntry> entries) {
        String sorts = options.getSort();
        BasicComparator cmp = SortFactory.create(sorts);
        entries.sort(cmp);
        return entries;
    }
}
