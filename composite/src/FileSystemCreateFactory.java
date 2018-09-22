public class FileSystemCreateFactory {

    public static IFileSystem createFileSystem() {
        IFileSystem root = new Folder("Root", "it's a root");

        IFileSystem Folder1 = new Folder("Folder", "It's folder 1");

        root.add(Folder1);

        IFileSystem File1 = new File("File1","it's File1", 50);

        root.add(File1);


        return root;
    }
}
