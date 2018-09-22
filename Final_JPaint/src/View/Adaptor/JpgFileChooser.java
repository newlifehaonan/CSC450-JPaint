package View.Adaptor;

import Utility.Utils;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class JpgFileChooser extends FileFilter {

    public boolean accept(File pathname) {

        if (pathname.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(pathname);

        if (extension != null) {

            if(extension.equals(Utils.jpg)) {
                return true;
            }
        }

        else {
            return false;
        }

        return false;
    }


    public String getDescription() {
        return "JPG file *.jpg";
    }
}
