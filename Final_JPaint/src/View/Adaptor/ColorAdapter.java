package View.Adaptor;

import View.Enum.ShapeColor;

import java.awt.*;
import java.io.Serializable;

public class ColorAdapter implements Serializable {
    ShapeColor shapeColor;
    Color color;

    public ColorAdapter(ShapeColor shapeColor) {
        this.shapeColor = shapeColor;

    }

    public Color getColor(ShapeColor shapeColor) {
        switch (shapeColor) {
            case BLUE:
                color = Color.blue;
                break;
            case BLACK:
                color = Color.black;
                break;
            case CYAN:
                color = Color.CYAN;
                break;
            case DARK_GRAY:
                color = Color.DARK_GRAY;
                break;
            case GRAY:
                color = Color.GRAY;
                break;
            case GREEN:
                color = Color.GREEN;
                break;
            case LIGHT_GRAY:
                color = Color.LIGHT_GRAY;
                break;
            case MAGENTA:
                color = Color.MAGENTA;
                break;
            case ORANGE:
                color = Color.ORANGE;
                break;
            case RED:
                color = Color.RED;
                break;
            case PINK:
                color = Color.PINK;
                break;
            case WHITE:
                color = Color.WHITE;
                break;
            case YELLOW:
                color = Color.YELLOW;
                break;
        }
        return color;
    }
}