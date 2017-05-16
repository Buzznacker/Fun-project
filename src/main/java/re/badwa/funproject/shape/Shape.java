package re.badwa.funproject.shape;

import re.badwa.funproject.dot.Dot;
import re.badwa.funproject.location.Location;

import java.awt.*;

public interface Shape {

    Location getLocation();

    int getWidth();

    int getHeight();

    int getId();

    boolean contains(Dot dot);

    void draw(Graphics g);
}
