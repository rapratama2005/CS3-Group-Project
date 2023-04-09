import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GPanel extends JPanel{
    GPanel(int width, int height, int rows, int cols, Color color){
        setVisible(true);
        GridLayout jLay = new GridLayout(rows, cols);
        setPreferredSize(new Dimension (width,height));
        setBackground(color);
        setLayout(jLay);
    }
}