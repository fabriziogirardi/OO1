package ar.edu.unlp.info.oo1.ejercicio1;

import javax.swing.SwingUtilities;

import ar.edu.unlp.info.oo1.ejercicio1.ui.WallPostUI;

public class Ejercicio1Application {

  public static void main(String[] args) {

    // https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/package-summary.html
    SwingUtilities.invokeLater(WallPostUI::new);
  }

}
