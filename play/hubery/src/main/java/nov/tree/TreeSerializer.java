package main.java.nov.tree;

import java.io.File;

/**
 * @author chi
 */
public interface TreeSerializer<T> {
    File serialize(Tree<T> tree);

    Tree<T> deserialize(File file);
}
