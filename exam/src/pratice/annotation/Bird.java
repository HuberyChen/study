package pratice.annotation;

import pratice.annotation.Desc.Color;

@Desc(c = Color.White)
abstract class Bird {
    public abstract Color getColor();
}