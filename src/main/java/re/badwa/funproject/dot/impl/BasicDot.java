package re.badwa.funproject.dot.impl;

import lombok.Getter;
import lombok.Setter;
import re.badwa.funproject.dot.Dot;
import re.badwa.funproject.location.Location;
import re.badwa.funproject.shape.Shape;

import java.awt.*;

@Getter
@Setter
public class BasicDot implements Dot {

    private Location location;

    private Shape insideShape;

    public BasicDot(Location location) {
        this.location = location;
    }

    @Override
    public void setInsideShape(Shape shape) {
        this.insideShape = shape;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(location.getX(), location.getY(), 10, 10);
    }
}
