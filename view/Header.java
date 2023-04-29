package view;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Write a description of class Header here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Header extends JPanel{
    private Title title;
    private OptionsAlgorithm oA;
    private JPanel containerO;
    private JComboBox shapes;
    
    private ShowShape showShape;
    
    public Header (String textTitle,model.Shape shape) {
        setLayout(new GridLayout(2, 1));
        setBackground(Color.WHITE);
        containerO = new JPanel(new GridLayout(1, 2));
        containerO.setBackground(Color.WHITE);
        
        shapes = new JComboBox();
        
        showShape = new ShowShape();
        //revisar
        String[] s = {"Line", "Circle", "Square", "Triangle"};
        
        oA = new OptionsAlgorithm(s, optionsNameAlgorithms(shape.getAlgorithms()));        
        containerO.add(oA);
        containerO.add(showShape);
        containerO.add(shapes);
        
        title = new Title(textTitle);
        
        add(title);
        add(containerO);
        
        setPreferredSize(new Dimension(0, 66));
    }
    
    public String[] optionsNameAlgorithms (ArrayList<? extends model.algorithms.Algorithm> list) {
        String[] o = new String[list.size()];
        for (int i=0; i < list.size(); i++) {
            String n = list.get(i).getTitle();
            o[i] = n;
        }
        return o;
    }
    
    public OptionsAlgorithm getOpAlgorithm () {
        return oA;
    }
    
    public void setTitleAlgorithm (String text) {
        title.setTitle(text);
    } 
    
    public JComboBox getShapes () {
        return shapes;
    }
    
    public ShowShape getShowShape () {
        return showShape;
    }
}
