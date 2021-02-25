import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;
import java.awt.*;

public class Phone extends JFrame {


    int TILE_SIZE = 40;
    int coordinate = 12;
    int borders = 2;
    int countBoxes = 64;

    public Phone() {
        this.setSize(800, 1500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        Board board = new Board();
        this.setContentPane(board);
    }

    public class Board extends JPanel {
        public void paint(Graphics g) {
            g.fillRect(0, 0, 800, 800);
            g.setColor(Color.BLUE);

            for (int i = 0; i < countBoxes; i++) {
                for (int j = 0; j < countBoxes; j++) {


                    if (i % 2 == 0 && j % 2 == 0) {
                        g.setColor(Color.red);

                    } else {
                        g.setColor(Color.blue);
                    }

                    g.fillRect(i * coordinate, j * coordinate, coordinate - borders, coordinate - borders);

                }
            }
        }
    }

    private class Tile extends StackPane {
        private int x, y;
        private boolean hasBrokenPixel;
        private boolean isOpen = false;

        private javafx.scene.shape.Rectangle border = new Rectangle(TILE_SIZE - 2, TILE_SIZE - 2);
        private Text text = new Text();

        public Tile(int x, int y) {
            this.x = x;
            this.y = y;
            this.hasBrokenPixel = hasBrokenPixel;

            border.setStroke(javafx.scene.paint.Color.LIGHTGRAY);

            text.setFont(Font.font(18));
            text.setText(hasBrokenPixel ? "X" : "");
            text.setVisible(false);

            getChildren().addAll(border, text);

            setTranslateX(x * TILE_SIZE);
            setTranslateY(y * TILE_SIZE);

            setOnMouseClicked(e -> open());
        }

        public void open() {
            if (isOpen)
                return;

            if (hasBrokenPixel) {
                System.out.println("Game Over");
                //scene.setRoot(createContent());
                return;
            }

            isOpen = true;
            text.setVisible(true);
            border.setFill(null);

            if (text.getText().isEmpty()) {
               
            }
        }


    }
}