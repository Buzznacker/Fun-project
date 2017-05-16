package re.badwa.funproject.shape.shapes.impl;

import re.badwa.funproject.location.Location;
import re.badwa.funproject.shape.BasicShape;
import re.badwa.funproject.shape.shapes.Triangle;

public class BasicTriangle extends BasicShape implements Triangle {

    public BasicTriangle(Location location, int width, int height) {
        super(location, width, height);
    }

    // TODO: Override contains && draw method for triangle.
}
