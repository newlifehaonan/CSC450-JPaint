
import java.util.ArrayList;

public class Folder implements IFileSystem {

    String name;
    String description;
    int size = 0;
    ArrayList<IFileSystem> fileSystems = new ArrayList<>();

    public Folder(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;

    }

    @Override
    public String getDescription() {

        return description;
    }

    @Override
    public int getSize() {
        calculateTotal();
        return size;
    }

    public void calculateTotal() {

        for(IFileSystem fileSystem: fileSystems) {
            size += fileSystem.getSize();
        }

    }


    public void add(IFileSystem fileSystem) {
        fileSystems.add(fileSystem);
    }

    public void remove(IFileSystem fileSystem) {
        fileSystems.remove(fileSystem);
    }

}
