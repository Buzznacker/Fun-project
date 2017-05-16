package re.badwa.funproject.ui;

import re.badwa.funproject.Main;
import re.badwa.funproject.adapter.impl.KeyAdapter;
import re.badwa.funproject.location.Location;
import re.badwa.funproject.shape.Shape;
import re.badwa.funproject.shape.shapes.impl.BasicCircle;
import re.badwa.funproject.shape.shapes.impl.BasicRectangle;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class FunPanel extends JPanel {

    private final Main main;
    private final Set<Shape> currentShapes = new HashSet<>();

    public FunPanel(Main main, KeyAdapter keyAdapter) {
        this.main = main;
        currentShapes.add(new BasicCircle(new Location(200, 400), 50));
        currentShapes.add(new BasicRectangle(new Location(100, 200), 20, 30));
        addKeyListener(keyAdapter);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentShapes.forEach(shape ->  {
            shape.draw(g);
            if(shape.contains(main.getDot()))
                main.getDot().setInsideShape(shape);
        });
        main.getDot().draw(g);
        drawScoreboard(g);
        main.getDot().setInsideShape(null);
    }

    private void drawScoreboard(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(Main.WINDOW_WIDTH - 130, 0, Main.WINDOW_WIDTH - 100, Main.WINDOW_HEIGHT);
        String insideOffset = (main.getDot().getInsideShape() != null ? "inside(" + main.getDot().getInsideShape().getId() + ")" : "outside");
        g.setColor(Color.ORANGE);
        g.drawString("Dot Status: " + insideOffset, Main.WINDOW_WIDTH - 125, 20);
    }
}
