package com.company;

/**
 * Created by gild on 5/27/18.
 */
public class FileSystem {

    private Node<IFile> root;

    public FileSystem() {
        root = new Node<>(new Directory("root"));
    }

    /**
     * Adds new File under the Directory branch
     *
     * @param parentDirName - parent directory name
     * @param fileName      - new file name
     * @param fileSize      - new file size
     */
    public void addFile(String parentDirName, String fileName, Integer fileSize) {
        Node<IFile> parentDirectory = findNode(root, parentDirName);
        if (!isFileNameUnique(fileName)) {
            System.out.println("[ERROR]: File name is not unique, continue to next file");
            return;
        }
        fileName = StringUtils.limit(fileName);
        Node<IFile> fileNode = new Node<>(new File(fileName, fileSize));
        parentDirectory.addChild(fileNode);
    }

    private boolean isFileNameUnique(String fileName) {
        return findNode(root, fileName) == null;
    }

    /**
     * Adds new Directory under the parent Directory
     *
     * @param parentDirName - parent directory name
     * @param dirName       - new directory name
     */
    public void addDir(String parentDirName, String dirName) {
        Node<IFile> parentDirectory = findNode(root, parentDirName);
        parentDirectory.addChild(new Node<>(new Directory(dirName)));
    }

    /**
     * Deletes the Directory or the File with this name
     *
     * @param name - file/directory to delete
     */
    public void delete(String name) {
        Node<IFile> node = findNode(root, name);
        int indexToRemove = 0;
        for (Node<IFile> curr : node.getParent().getChildren()) {
            if (name.equals(curr.getData().getName()))
                break;

            indexToRemove++;
        }

        node.getParent().getChildren().remove(indexToRemove);
    }

    /**
     * Displays all files & directories with their hierarchical structure (for file display all file properties and for Directory all its properties)
     */
    public void showFileSystem() {
        printTree(root, " ");
    }

    private void printTree(Node<IFile> node, String appender) {
        System.out.println(appender + node.getData().getName());
        node.getChildren().forEach(item -> printTree(item, appender + appender));
    }

    /**
     * search by node name
     *
     * @param n
     * @param keyToSearchBy
     * @return
     */
    public Node<IFile> findNode(Node<IFile> n, String key) {
        Node<IFile> current = null;

        if (key.equals(n.getData().getName())) {
            return n;
        } else {

            if (n.getData() instanceof File) {
                return null; // no more children in this path
            }

            if (n.getData() instanceof Directory) {
                for (Node<IFile> node : n.getChildren()) {
                    current = findNode(node, key);
                    if (current != null) {
                        return current;
                    }
                }
            }
        }

        return null;
    }

    public void createDemoTree() {
        addDir("root", "dev");
        addDir("root", "document");
        addDir("root", "desktop");

        addFile("dev", "java", 100);
        addFile("dev", "web", 150);
        addFile("dev", "web", 150);

        addFile("document", "personal", 200);

        addFile("desktop", "desktopFirstFile", 250);
        addDir("desktop", "desktopFirstDirectory");
        addFile("desktopFirstDirectory", "desktopNestedFile", 300);
    }
}
