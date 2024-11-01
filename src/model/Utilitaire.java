package model;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Utilitaire {
    /**
     * @param component
     * Cette fonction configure le look and feel de l'application.
     */
    public static void setLookAndFeel (Component component) {
        try {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           SwingUtilities.updateComponentTreeUI(component);
        } catch (InstantiationException |
                ClassNotFoundException |
                UnsupportedLookAndFeelException |
                IllegalAccessException e) {}
    }
   
    /**
     * @param component
     * @param dimension
     * Cette fonction positionne le composant au centre de l'écran.
     */
    public static void center (Component component, Dimension dimension) {
        component.setSize(dimension);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = component.getSize();

        if (frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;

        if (frameSize.width > screenSize.width)
            frameSize.width = screenSize.width;

        component.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }
}
