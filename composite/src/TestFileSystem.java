import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestFileSystem {

    @Test
    public void Test1() {

        //arrange

        IFileSystem root = FileSystemCreateFactory.createFileSystem();
        //act

        String rootname = root.getName();
        //assert

        assertEquals("Root", rootname);
    }

    @Test
    public void Test2() {

        Folder root = new Folder("1","1");

        String name = "root";
        String description = "I am root";

        Folder another = new Folder(name,description);

        assertEquals(name, another.name);
    }

    @Test
    public void Test3() {
        IFileSystem root = FileSystemCreateFactory.createFileSystem();

        int size = root.getSize();

        assertNotEquals(50, size);

    }
}
