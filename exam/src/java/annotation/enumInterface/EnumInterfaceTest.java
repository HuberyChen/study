package java.annotation.enumInterface;

import org.junit.Test;

public class EnumInterfaceTest {

    @Access(level = CommonIndentifier.Author)
    class Book {
        public void name() {
            System.out.println("book");
        }
    }

    @Test
    public void enumInterfaceTest() {
        Book book = new Book();
        Access access = book.getClass().getAnnotation(Access.class);
        if (null == access || !access.level().indentify()) {
            System.out.println(access.level().REFUCE_WORD);
        }
    }

}
