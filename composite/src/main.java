public class main {

    public static void main(String[] args) {

        IFileSystem root = new Folder("Root", "it's a root");

        IFileSystem Folder1 = new Folder("Folder", "It's folder 1");

        root.add(Folder1);

        IFileSystem File1 = new File("File1","it's File1", 50);

        root.add(File1);
    }
}
