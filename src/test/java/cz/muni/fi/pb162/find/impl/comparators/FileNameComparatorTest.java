package cz.muni.fi.pb162.find.comparators;

import cz.muni.fi.pb162.find.filesystem.SearchEntry;
import cz.muni.fi.pb162.find.tools.SortFactory;
import org.junit.Test;

import java.util.Comparator;

import static cz.muni.fi.pb162.find.TestUtils.createDir;
import static cz.muni.fi.pb162.find.TestUtils.createFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author pstanko
 */
public class FileNameComparatorTest {
    private static Comparator<SearchEntry> se = SortFactory.create("n");

    private static void testEquals(String path){
        assertEquals( "Files with same names are not equal." ,0, se.compare(createFile(path), createFile(path)));
    }

    private static void testEqualDirs(String path){
        assertEquals( "Dirs with same names are not equal." ,0, se.compare(createDir(path), createDir(path)));
    }

    private static void testTrue(String p1, String p2) {
        SearchEntry first = createFile(p1);
        SearchEntry second = createFile(p2);
        String message = "File \"" + first + "\" should be greater than \"" + second + "\".";
        assertTrue(message,se.compare(first, second) > 0);
    }

    private static void testDirTrue(String p1, String p2) {
        SearchEntry first = createDir(p1);
        SearchEntry second = createDir(p2);
        String message = "Dir \"" + first + "\" should be greater than \"" + second + "\".";
        assertTrue(message,se.compare(first, second) > 0);
    }

    @Test
    public void shouldCompareSimpleFileNames() throws Exception {
        testTrue("ahoj.svet", "ahoj.jpg");
        testTrue("ahoj2.jpg", "ahoj1.jpg");
        testEquals("ahoj.jpg");
    }

    @Test
    public void shouldCompareSimpleDirs() throws Exception {
        String first = ("ahoj");
        String second = ("ahoj2");
        testDirTrue( second, first);
        testEqualDirs(first);
    }

    @Test
    public void shouldCompareLongPath() throws Exception {
        String first = ("ahoj/ahoj/ahoj.jpg");
        String second = ("ahoj/ahoj/ahoj.png");
        testTrue(second, first);
        testEquals(second);
    }

    @Test
    public void shouldCompareHiddenFiles() throws Exception {
        String first = ("ahoj/ahoj/.ahoj.jpg");
        String second = ("ahoj/ahoj/.ahoj.png");
        testTrue(second, first);
        testEquals(first);

    }

}
