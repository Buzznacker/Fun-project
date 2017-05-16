package re.badwa.funproject.dot;

import re.badwa.funproject.location.Location;
import re.badwa.funproject.shape.Shape;

import java.awt.*;

public interface Dot {

    Location getLocation();

    Shape getInsideShape();

    void setInsideShape(Shape shape);

    void setLocation(Location location);

    void draw(Graphics g);

}
