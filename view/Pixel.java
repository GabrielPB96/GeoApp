package view;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Cursor;

public class Pixel extends JComponent implements MouseListener{
    private final int width;
    private final int x;
    private final int y;
    private Color color;
    private boolean isSelected;
    private view.shapes.ShapeView parentShape;
    public Pixel(int x, int y, int width, Color color){
        this.width = width;
        this.x = x;
        this.y = y;
        this.color = color;
        isSelected = false;
        parentShape = null;
        setBounds(x*width, y*width, width, width);
        addMouseListener(this);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public Pixel(int x, int y, int width){
        this(x, y, width, Color.BLACK);
    }
    
    public void setParentShape (view.shapes.ShapeView pS) {
        parentShape = pS;
    }
    
    public view.shapes.ShapeView getParentShape () {
        return parentShape;
    }
    
    public int getXPlane () {
        return x;
    }
    
    public int getYPlane () {
        return y;
    }
    
    public void setColor (Color color) {
        this.color = color;
    }
    
    public void paintFill(Graphics g) {
        g.setColor(color);
        g.fillRect(x*width, y*width, width, width);
    }
    
    public void select () {
        isSelected = true;
        repaint();
    }
    
    public void unselect () {
        isSelected = false;
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(isSelected) g.setColor(new Color(42, 42, 42));
        else g.setColor(color);
        g.fillRect(0, 0, width, width);
    }
    
    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(parentShape != null) {
            parentShape.select();
            Plane p = (Plane)getParent();
            p.setCurrentShape(parentShape);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
