public interface IFileSystem {

    String getName();

    String getDescription();

    int getSize();

    void add(IFileSystem fileSystem);
}
