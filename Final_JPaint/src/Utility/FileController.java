package Utility;

import Model.Interfaces.IShape;
import View.Interfaces.IDrawCanvas;
import View.ShapeList;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileController {

    ShapeList shapeList;

    ArrayList<IShape> shapes;

    public FileController(ShapeList shapeList) {
        this.shapeList =shapeList;
    }

    public void saveToFile(File file) throws IOException {

        shapes = shapeList.getShapes();

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        IShape[] shapesArray = shapes.toArray(new IShape[shapes.size()]);

        oos.writeObject(shapesArray);

        oos.close();
    }

    public void importFromFile(File file) throws IOException {

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);


        try {
            shapeList.clearshapelist();
            IShape[] shapesArray = (IShape[])ois.readObject();
            shapeList.addToList(Arrays.asList(shapesArray));
        } catch (ClassNotFoundException e){
            System.err.println("File not found");
        }
    }

    public void refresh() {

    }

}
