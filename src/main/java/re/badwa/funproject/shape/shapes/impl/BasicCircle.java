package re.badwa.funproject.shape.shapes.impl;

import lombok.Getter;
import re.badwa.funproject.dot.Dot;
import re.badwa.funproject.location.Location;
import re.badwa.funproject.shape.BasicShape;
import re.badwa.funproject.shape.shapes.Circle;

import java.awt.*;

public class BasicCircle extends BasicShape implements Circle {

    @Getter
    private final int radius;

    public BasicCircle(Location location, int radius) {
        super(location, 0, 0);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(location.getX() - radius, location.getY() - radius, radius * 2, radius * 2);
    }

    @Override
    public boolean contains(Dot dot) {
        int yValue = dot.getLocation().getY() - this.getLocation().getY();
        int xValue = dot.getLocation().getX() - this.getLocation().getX();
        yValue = (int) Math.pow(yValue, 2);
        xValue = (int) Math.pow(xValue, 2);
        int distance = (int) Math.sqrt(xValue + yValue);
        return distance <= this.radius;
    }
}
