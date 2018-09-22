public class File implements IFileSystem {

    String name;
    String description;
    int size;

    public File(String name, String description, int size) {
        this.name = name;
        this.description = description;
        this.size = size;
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
        return size;
    }

    @Override
    public void add(IFileSystem fileSystem) {
        throw new UnsupportedOperationException();
    }
}
