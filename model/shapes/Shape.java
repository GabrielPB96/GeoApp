package model.shapes;
import model.Punto;
import java.util.ArrayList;
import java.awt.Color;
import model.algorithms.Algorithm;

public abstract class Shape {
    protected ArrayList<Punto> points;
    protected ArrayList<Punto> vertexs;
    protected int grosor;
    protected Color color;
    protected boolean rellenado;
    protected TipoTrazado tipoTrazado;
    protected double factorEscalacion;
    
    protected Algorithm algorithm;
    
    public Shape () {
        points = new ArrayList<Punto>();
        vertexs = new ArrayList<Punto>();
        grosor = 1;
        factorEscalacion = 1;
        color = new Color(100, 50, 100);
        tipoTrazado = TipoTrazado.CONTINUO;
        rellenado = false;
    }
    
    public void setFill (boolean f) {
        rellenado = f;
    }
    public void setColor (Color color) {
        this.color = color;
    }
    public void setTipoTrazado (TipoTrazado tipo) {
        tipoTrazado = tipo;
    }
    public void setGrosor (int t) {
        grosor = t;
    }
    
    public Color getColor () {
        return color;
    }
    public ArrayList<Punto> getPoints () {
        return points;
    }
    public ArrayList<Punto> getVertexs () {
        return vertexs;
    }

    public void trasladar (int dx, int dy) {}
    
    public void escalar (double s) {
        factorEscalacion = s;
    }
    
    public void rotar (double grados) {}
    
    public void calcularGrosor () {}
    
    public void calcularTipoTrazado () {}
    
    public abstract void recalcular ();
    public abstract void fill ();
    public abstract Punto calculateCenterPoint ();    
    
    public void build() {
        recalcular();
        if (rellenado && tipoTrazado == TipoTrazado.CONTINUO) {
            fill();
        }
        calcularGrosor();
        calcularTipoTrazado ();
    }
    
    public void update () {
        build();
    }
    
    protected void cuatro_vecinos(int x, int y) {
        Punto p = new Punto(x, y);
        if (!points.contains(p)) {
            points.add(p);
            cuatro_vecinos(x, y+1);
            cuatro_vecinos(x+1, y);
            cuatro_vecinos(x, y-1);
            cuatro_vecinos(x-1, y);
        }
    }
}
