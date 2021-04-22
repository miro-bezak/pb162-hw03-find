package cz.muni.fi.pb162.find.impl;

import cz.muni.fi.pb162.find.ApplicationOptions;
import cz.muni.fi.pb162.find.filesystem.DirEntry;
import cz.muni.fi.pb162.find.filesystem.FSWalkResult;
import cz.muni.fi.pb162.find.filesystem.FileEntry;
import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.tools.FileTools;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the file system walk functionality
 *
 * @author Miroslav Bezak
 */
public class FSWalkResultImpl extends FSWalkResult {

    /**
     * List of all yet visited directories
     */
    private List<SearchEntry> directories = new ArrayList<>();

    /**
     * List of all yet visited files
     */
    private List<SearchEntry> files = new ArrayList<>();

    /**
     * Constructor for class FSWalkResult
     *
     * @param options application options
     */
    public FSWalkResultImpl(ApplicationOptions options) {
        super(options);
    }

    @Override
    public List<SearchEntry> getDirectories() {
        return new LinkedList<>(directories);
        // could not return an unmodifiable list here, because of usage in Application,
        // so at least return a new list to keep encapsulation
    }

    @Override
    public List<SearchEntry> getFiles() {
        return new LinkedList<>(files);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
        FileEntry fileEntry = new FileEntry(file);
        fileEntry.setSize(FileTools.dirSize(file));
        files.add(fileEntry);

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        DirEntry dirEntry = new DirEntry(dir);
        dirEntry.setSize(FileTools.dirSize(dir));
        directories.add(dirEntry);

        return FileVisitResult.CONTINUE;
    }
}
