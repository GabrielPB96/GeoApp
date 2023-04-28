package controller;
import java.awt.event.*;
import javax.swing.*;


/**
 * Write a description of class ShapeCurrentListener here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShapeCurrentListener implements ActionListener {
    private view.Plane plane;
    private JComboBox shapes;
    private view.OptionsAttributes opsAttrib;
    private view.ShowShape showShape;
    
    public ShapeCurrentListener (view.Plane plane, JComboBox shapes,  view.OptionsAttributes opsAttrib, view.ShowShape showShape) {
        this.plane = plane;
        this.shapes = shapes;
        this.opsAttrib = opsAttrib;
        this.showShape = showShape;
        shapes.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(shapes)) {
            int index = shapes.getSelectedIndex();
            view.shapes.ShapeView sc = plane.getShape(index);
            showShape.setShape(sc.getShape());
            showShape.updateShape();
            plane.setCurrentShape(sc);
            updateAttributes(sc.getShape());
        }
    }
    
    private void updateAttributes (model.shapes.Shape s) {
        opsAttrib.getFillCheck().setSelected(s.getFill());
        opsAttrib.getColorChooser().setColor(s.getColor());
        opsAttrib.getColorButton().setBackground(s.getColor());
    }
}
