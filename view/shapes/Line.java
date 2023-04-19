package view.shapes;

import model.Punto;
import java.util.ArrayList;

import model.algorithms.LineAlgorithm;
import model.algorithms.LineBresenham;

public class LineView extends ShapeView {
  public Line(Punto start, Punto end, LineAlgorithm algorithm) {
    this.algorithm = algorithm;
    pointsBorder = algorithm.generatePoints((int) start.getX(), (int) start.getY(), (int) end.getX(),
        (int) end.getY());
    generatePixels();
  }

  public Line(Punto start, Punto end) {  
    this(start, end, new LineBresenham());
  }
  
  public void fill () {}
}
