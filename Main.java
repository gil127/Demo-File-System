package com.company;

public class Main {

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.createDemoTree();
        fileSystem.showFileSystem();

        fileSystem.delete("dev");
        fileSystem.showFileSystem();

        Lottery lottery = new Lottery();
        lottery.initLottery();
        lottery.run();
    }
}
