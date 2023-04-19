package controller;
import java.awt.event.*;
import javax.swing.*;


/**
 * Write a description of class ControllerAttributes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ControllerAttributes implements ActionListener, ItemListener { 
    private view.Plane plane;
    private view.OptionsAttributes opsAttrib;
    private JCheckBox fill;
    private JComboBox escalar;
    public ControllerAttributes (view.Plane plane, view.OptionsAttributes ops) {
        this.plane = plane;
        opsAttrib = ops;
        fill = ops.getFillCheck();
        escalar = ops.getEscala();
        
        escalar.addActionListener(this);
        fill.addItemListener(this);
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
}
