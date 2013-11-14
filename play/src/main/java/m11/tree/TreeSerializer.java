package m11.tree;

import java.io.File;

/**
 * @author chi
 */
public interface TreeSerializer<T> {
    File serializer(Tree<T> tree);

    Tree<T> deserializer(File file);
}
