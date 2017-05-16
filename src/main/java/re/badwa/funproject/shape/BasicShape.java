package re.badwa.funproject.shape;

import lombok.Getter;
import lombok.Setter;
import re.badwa.funproject.dot.Dot;
import re.badwa.funproject.location.Location;
import re.badwa.funproject.shape.shapes.Rectangle;

import java.awt.*;

@Getter
@Setter
public class BasicShape implements Shape {

    private static int SHAPE_COUNT = 0;

    @Getter
    protected Location location;
    @Getter
    protected final int width;
    @Getter
    protected final int height;
    @Getter
    protected final int id;

    public BasicShape(Location location, int width, int height) {
        this.location = location;
        this.width = width;
        this.height = height;
        this.id = SHAPE_COUNT++;
    }

    @Override
    public void draw(Graphics g) {
        String idString = "" + this.id;
        int centerX = this.location.getX();
        int centerY = this.location.getY();
        if(this instanceof Rectangle) {
            centerX = this.location.getX() + (this.width / 2);
            centerY = this.location.getY() + (this.height / 2);
        }
        g.drawString(idString, (centerX - 2) - idString.length(), centerY + 4);
    }

    @Override
    public boolean contains(Dot dot) {
        int w = this.width;
        int h = this.height;
        if ((w | h) < 0) {
            return false;
        }
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        if (dot.getLocation().getX() < x || dot.getLocation().getY() < y) {
            return false;
        }
        w += x;
        h += y;
        return ((w < x || w > dot.getLocation().getX()) &&
                (h < y || h > dot.getLocation().getY()));
    }
}
