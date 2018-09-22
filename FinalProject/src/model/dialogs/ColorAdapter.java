package model.dialogs;

import model.ShapeColor;
import java.awt.Color;
import java.util.EnumMap;

public final class ColorAdapter {

    private static final EnumMap<ShapeColor,Color> colorMapping = new EnumMap<>(ShapeColor.class);

    static {


        colorMapping.put(ShapeColor.BLACK,Color.BLACK);
        colorMapping.put(ShapeColor.BLUE,Color.BLUE);
        colorMapping.put(ShapeColor.CYAN,Color.CYAN);
        colorMapping.put(ShapeColor.DARK_GRAY,Color.DARK_GRAY);
        colorMapping.put(ShapeColor.GRAY,Color.GRAY);
        colorMapping.put(ShapeColor.GREEN,Color.GREEN);
        colorMapping.put(ShapeColor.LIGHT_GRAY,Color.LIGHT_GRAY);
        colorMapping.put(ShapeColor.MAGENTA,Color.MAGENTA);
        colorMapping.put(ShapeColor.ORANGE,Color.ORANGE);
        colorMapping.put(ShapeColor.PINK,Color.PINK);
        colorMapping.put(ShapeColor.RED,Color.RED);
        colorMapping.put(ShapeColor.WHITE,Color.WHITE);
        colorMapping.put(ShapeColor.YELLOW,Color.YELLOW);

    }

    private ColorAdapter() { }

    public static Color getColor(ShapeColor enumColor) {


        return colorMapping.get(enumColor);


    }

}