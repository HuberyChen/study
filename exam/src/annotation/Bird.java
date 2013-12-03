package annotation;

import annotation.Desc.Color;

@Desc(c = Color.White)
abstract class Bird {
    public abstract Color getColor();
}