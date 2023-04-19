package view.shapes;

import model.Punto;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import model.algorithms.Algorithm;
import view.Constants;
import view.Pixel;


public abstract class ShapeView extends JComponent {
    protected ArrayList<Pixel> pixels;
    protected model.shapes.Shape shape;

    public ShapeView() {
        pixels = new ArrayList<Pixel>();
    }
    
    public ArrayList<Pixel> getPixels() {
        return pixels;
    }
    
    public model.shapes.Shape getShape () {
        return shape;
    }
    
    public void update () {
        pixels.clear();
        generatePixels();
    }
    
    protected void generatePixels() {
        shape.getPoints().forEach((point)->{
            int x = (int) point.getX();
            int y = (int) point.getY();
            int mX = Constants.LX / 2;
            int mY = Constants.LY / 2;
            Pixel pixel = new Pixel(x+mX, -y+mY, Constants.GRID_SCALE, shape.getColor());
            pixel.setParentShape(ShapeView.this);
            pixels.add(pixel);
        });
    }
  
    public void select () {
        pixels.forEach((pixel)->pixel.select());    
    }
    
    public void unselect () {
        pixels.forEach((pixel)->pixel.unselect());
    }
}
