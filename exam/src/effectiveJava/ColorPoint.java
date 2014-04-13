package effectiveJava;

/**
 * @author hubery
 */
public class ColorPoint {

    private Color color;
    private Point point;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = color;
    }

    // Returns the point-view of this color point

    public Point asPoint() {
        return point;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;

        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    /**
     * // Broken - violates symmetry
     * // public class ColorPoint extends Point
     * <p/>
     * public boolean equals(Object o) {
     * //        if (!(o instanceof ColorPoint))
     * //            return false;
     * <p/>
     * if (!(o instanceof Point))
     * return false;
     * <p/>
     * if (!(o instanceof ColorPoint))
     * return o.equals(this);
     * <p/>
     * ColorPoint cp = (ColorPoint) o;
     * return super.equals(o) && cp.color == color;
     * }
     */

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(p.equals(cp));
        System.out.println(cp.equals(p));

        ColorPoint p1 = new ColorPoint(1, 2, Color.BLUE);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.RED);

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));
    }
}
