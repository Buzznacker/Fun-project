package re.badwa.funproject.shape.shapes.impl;

import re.badwa.funproject.location.Location;
import re.badwa.funproject.shape.BasicShape;
import re.badwa.funproject.shape.shapes.Rectangle;

import java.awt.*;

public class BasicRectangle extends BasicShape implements Rectangle {

    public BasicRectangle(Location location, int width, int height) {
        super(location, width, height);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawRect(location.getX(), location.getY(), width, height);
    }
}
