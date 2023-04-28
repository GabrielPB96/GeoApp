package controller;
import java.util.ArrayList;
import javax.swing.JTextField;


public class Controller {
    private view.App app;
    private view.Header header;
    private view.Plane plane;
    
    private InputListener inputL;
    private OptionShape optionShapeL;
    private OptionAlgorithm optionAlgorithmL;
    private ButtonListener buttonsL;
    private PlaneListener planeL;
    
    private ControllerAttributes ctrAttributes;
    private ShapeCurrentListener shapeCurrentL;
    public Controller (view.App app) {
        this.app = app;
        
        header = this.app.getHeader();
        plane = this.app.getPlane();
        ctrAttributes = new ControllerAttributes(plane, this.app.getOpsAttributes());
        shapeCurrentL = new ShapeCurrentListener(plane,header.getShapes(), this.app.getOpsAttributes(), header.getShowShape());
        buttonsL = new ButtonListener(this.app);
        planeL = new PlaneListener(this.app, plane);
        optionShapeL = new OptionShape(header.getOpAlgorithm().getOptionsShape(), new model.ShapeMap()){
            @Override
            public void action (model.Shape shape) {
                updateShape(shape);
                updateAlgorithm(app.getModelShape().getAlgorithms().get(0));
            }
        };
        
        optionAlgorithmL = new OptionAlgorithm(header.getOpAlgorithm().getOptionsAlgorithm(), new model.AlgorithmMap(app.getModelShape())){
            @Override
            public void action (model.algorithms.Algorithm alg) {
                updateAlgorithm(alg);
            }
        };
    }
    
    public void updateShape (model.Shape shape) {
        app.setShape(shape);
        header.getOpAlgorithm().setOptionsAlgorithms(header.optionsNameAlgorithms(app.getModelShape().getAlgorithms()));
        optionAlgorithmL.setAlgorithmMap(new model.AlgorithmMap(app.getModelShape()));
        plane.setGraphic(null);
        plane.clearPoints();
    }
    
    public void updateAlgorithm (model.algorithms.Algorithm alg) {
        app.setAlgorithm(alg);
        plane.clearPoints();
        app.runAlgorithm();
    }
}
