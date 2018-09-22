package gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class HtmlFileChooser extends FileFilter {


    public boolean accept(File pathname) {

        if (pathname.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(pathname);

        if (extension != null) {

            if(extension.equals(Utils.html)) {
                return true;
            }
        }

        else {
            return false;
        }

        return false;
    }


    public String getDescription() {
        return "HTML file *.html";
    }
}
