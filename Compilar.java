import java.io.*;
public class Compilar {
  public static void main(String args[]) {
     try{
      String dir = "C:/Users/asus/Documents/UMSS/SEMESTRE 1-2023/Graficacion/GeoApp";
      compilarAll(new File(dir));
     }catch(Exception e){}
  }

  public static void compilarAll(File file) throws Exception{
    if(file.isDirectory()) {
      File[] archivos = file.listFiles();
      for(File f : archivos) {
        compilarAll(f);
      }
    }else {
        compilar(file);
    }
  }

  public static void compilar(File file) throws Exception{
    if(file.getName().endsWith(".java")) 
    {
      Runtime runtime = Runtime.getRuntime();
      String comando = "javac " + file.getAbsolutePath();
      Process proceso = runtime.exec(comando);
      int estado = proceso.waitFor();
      System.out.println("Compilado: "+file.getName());
    }
  }
}
