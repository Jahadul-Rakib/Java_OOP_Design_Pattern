/*Composite Pattern allows you to compose objects into tree structures to represent part-whole hierarchies.
  If a node is a single person, like Mom , then it's a leaf node . Thanks to the tree structure, Contacts can be
  arbitrarily complex.*/

package com.rakib.java_design_pattern.b_structural.composit_design_pattern;

public class CompositDesignPattern {

    public static void main(String[] args) {

        System.out.println(createTreeOne().getFileName());
        System.out.println(createTreeTwo().getFileName());

    }
    //Client builds tree using leaf and composites
	private static File createTreeOne() {
		FileDirectory dir1 = new FileDirectory("dir1");
        File file1 = new FileBinary("File1", 1000);
		dir1.addFile(file1);


        FileDirectory dir2 = new FileDirectory("dir2");
        File file2 = new FileBinary("file2", 2000);
        dir2.addFile(file2);
        File file3 = new FileBinary("file3", 150);
		dir2.addFile(file3);

		dir2.addFile(dir1);
		return dir2;
	}

	private static File createTreeTwo() {
		return new FileBinary("Another file", 200);
	}
}
