package controller;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;


/**
 * Write a description of class ControllerAttributes here.
 * @author (your name)
 * @version (a version number or a date)
 */
public class ControllerAttributes extends KeyAdapter implements ActionListener, ItemListener, ChangeListener { 
    private JButton up, down, left, right;
    private view.Plane plane;
    private view.OptionsAttributes opsAttrib;
    private JCheckBox fill;
    private JComboBox escalar;
    private JButton colorButton;
    private JColorChooser colorChooser;
    private JPopupMenu popupColor;
    
    private view.shapes.ShapeView viewShape;
    private model.shapes.Shape modelShape;
    
    public ControllerAttributes (view.Plane plane, view.OptionsAttributes ops) {
        this.plane = plane;
        opsAttrib = ops;
        
        fill = ops.getFillCheck();
        escalar = ops.getEscala();
        colorButton = ops.getColorButton();
        colorChooser = ops.getColorChooser();
        popupColor = ops.getPopupColor();
        
        up = ops.getUpDirecciontion();
        down = ops.getDownDirecciontion();
        left = ops.getLelftDirecciontion();
        right = ops.getRightDirecciontion();
        up.addActionListener(this);
        down.addActionListener(this);
        right.addActionListener(this);
        left.addActionListener(this);
        
        escalar.addActionListener(this);
        fill.addItemListener(this);
        colorButton.addActionListener(this);
        colorChooser.getSelectionModel().addChangeListener(this);
        
        this.plane.addKeyListener(this);
    }
    
    private void updateCurrenetShape () {
        viewShape = plane.getCurrentShape();
        modelShape = viewShape.getShape();
    }
    
    private void updateUIPlane () {
        modelShape.update();
        viewShape.update();
        plane.addShape(viewShape);
        plane.updateUI();
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        Object src = e.getSource();
        if (plane.getCurrentShape() != null) {
            updateCurrenetShape();
            plane.removeCurrentShape();
            if(src.equals(escalar)) {
                double s = (double)(escalar.getSelectedItem());
                modelShape.escalar(s);
            } else if (src.equals(colorButton)) {
                popupColor.show(colorButton, 0, colorButton.getHeight());
            }
            eventMoved(src);
            updateUIPlane();
        }
        plane.requestFocus();
    }
    
    @Override
    public void itemStateChanged (ItemEvent itemEvent) {
        Object src = itemEvent.getSource();
        if (plane.getCurrentShape() != null) {
            updateCurrenetShape();
            plane.removeCurrentShape();
            if (src.equals(fill)) {
                if(itemEvent.getStateChange() == 1) {
                    modelShape.setFill(true);
                }else {
                    modelShape.setFill(false);
                }    
            }
            updateUIPlane();
        }
        plane.requestFocus();
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        Color color = colorChooser.getColor();
        colorButton.setBackground(color);
        if(plane.getCurrentShape() != null) {
            updateCurrenetShape();
            plane.removeCurrentShape();
            modelShape.setColor(color);
            updateUIPlane();
        }
        plane.requestFocus();
    }
    
    private void eventMoved (Object src) {
        if(src.equals(up)) {
            modelShape.trasladar(0, 1);
        }else if(src.equals(down)) {
            modelShape.trasladar(0,-1);
        }else if(src.equals(left)) {
            modelShape.trasladar(-1, 0);
        }else if(src.equals(right)) {
            modelShape.trasladar(1, 0);
        }        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(plane.getCurrentShape() != null) {
            updateCurrenetShape();
            plane.removeCurrentShape();
            if(keyCode == KeyEvent.VK_UP) {
                modelShape.trasladar(0, 1);
            }else if(keyCode == KeyEvent.VK_DOWN){
                modelShape.trasladar(0,-1);
            }else if(keyCode == KeyEvent.VK_LEFT){
                modelShape.trasladar(-1, 0);
            }else if(keyCode == KeyEvent.VK_RIGHT){
                modelShape.trasladar(1, 0);
            }
            updateUIPlane();
        }
    }
}
