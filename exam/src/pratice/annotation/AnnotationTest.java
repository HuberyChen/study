package pratice.annotation;

import pratice.annotation.Desc.Color;

import org.junit.Test;

public class AnnotationTest {

    @Test
    public void annotationTest() {
        Bird bird = BirdNest.Sparrow.reproduce();
        Color color = bird.getColor();
        System.out.println("Bird`s color is: " + color);
    }

}
