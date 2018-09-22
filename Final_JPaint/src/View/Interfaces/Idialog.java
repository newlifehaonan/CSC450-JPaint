package View.Interfaces;

public interface Idialog<T> {

    String getDialogTitle();

    String getDialogText();

    T[] getDialogOptions();

    T getCurrentSelection();
}
