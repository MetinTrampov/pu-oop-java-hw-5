import javax.swing.*;
import java.awt.*;

public class Phone extends JFrame {
    int coordinate = 12;
    int borders =  2 ;
    public Phone() {
        this.setSize(800, 1500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Board board = new Board();
        this.setContentPane(board);
    }

    public class Board extends JPanel {
        public void paint(Graphics g) {
            g.fillRect(0,0,800,800);
            g.setColor(Color.BLUE);

            for (int i=0; i< 64; i++) {
                for (int j=0; j< 64; j++){

                    
                    g.fillRect(i*coordinate,j*coordinate,coordinate-borders,coordinate-borders);

                }
            }
        }
    }
}
