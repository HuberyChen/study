package pratice.annotation;

import pratice.annotation.Desc.Color;

class Sparrow extends Bird {
    private Color color;

    public Sparrow() {
        color = Color.Grayish;
    }

    public Sparrow(Color _color) {
        color = _color;
    }

    @Override
    public Color getColor() {
        return color;
    }
}