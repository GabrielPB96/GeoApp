package controller;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;


/**
 * Write a description of class ControllerAttributes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ControllerAttributes implements ActionListener, ItemListener, ChangeListener { 
    private view.Plane plane;
    private view.OptionsAttributes opsAttrib;
    private JCheckBox fill;
    private JComboBox escalar;
    private JButton colorButton;
    private JColorChooser colorChooser;
    private JPopupMenu popupColor;
    
    public ControllerAttributes (view.Plane plane, view.OptionsAttributes ops) {
        this.plane = plane;
        opsAttrib = ops;
        fill = ops.getFillCheck();
        escalar = ops.getEscala();
        colorButton = ops.getColorButton();
        colorChooser = ops.getColorChooser();
        popupColor = ops.getPopupColor();
        
        escalar.addActionListener(this);
        fill.addItemListener(this);
        colorButton.addActionListener(this);
        colorChooser.getSelectionModel().addChangeListener(this);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        Object src = e.getSource();
        if (plane.getCurrentShape() != null) {
            view.shapes.ShapeView sc = plane.getCurrentShape();
            model.shapes.Shape sm = sc.getShape();
            plane.removeCurrentShape();
            if(src.equals(escalar)) {
                double s = (double)(escalar.getSelectedItem());
                sm.escalar(s);
                sm.update();
                sc.update();
            } else if (src.equals(colorButton)) {
                popupColor.show(colorButton, 0, colorButton.getHeight());
            }
            plane.add(sc);
            plane.updateUI();
        }
    }
    
    @Override
    public void itemStateChanged (ItemEvent itemEvent) {
        Object src = itemEvent.getSource();
        if (plane.getCurrentShape() != null) {
            view.shapes.ShapeView sc = plane.getCurrentShape();
            model.shapes.Shape sm = sc.getShape();
            plane.removeCurrentShape();
            if (src.equals(fill)) {
                if(itemEvent.getStateChange() == 1) {
                    sm.setFill(true);
                    sm.update();
                    sc.update();
                }else {
                    sm.setFill(false);
                    sm.update();
                    sc.update();
                }    
            }
            plane.add(sc);
            plane.updateUI();
        }
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        Color color = colorChooser.getColor();
        colorButton.setBackground(color);
        if(plane.getCurrentShape() != null) {
            view.shapes.ShapeView sc = plane.getCurrentShape();
            model.shapes.Shape sm = sc.getShape();
            plane.removeCurrentShape();
            sm.setColor(color);
            sm.update();
            sc.update();
            plane.add(sc);
            plane.updateUI();
        }
    }
}
