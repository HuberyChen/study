package java.annotation.enumInterface;

enum CommonIndentifier implements Indentifier {
    Reader, Author, Admin;

    @Override
    public boolean indentify() {
        return false;
    }

}
