/*


This pattern is used to get a way to access the elements of a collection object in sequential manner
        without any need to know its underlying representation.

*/
package com.rakib.java_design_pattern.c_behavioral.iterator_design_pattern;


enum ThemColor {
    RED, BLUE, GREEN, ORANGE, BLACK, WHITE;

    static Iterator<ThemColor> getIterator() {
        return new ThemeColorIterator();
    }

    static class ThemeColorIterator implements Iterator<ThemColor> {
        private int position;

        @Override
        public boolean hasNext() {
            return position < ThemColor.values().length;
        }

        @Override
        public ThemColor next() {
            return ThemColor.values()[position++];
        }
    }
}

interface Iterator<T> {
    boolean hasNext();

    T next();
}


public class IteratorDesignPattern {
    public static void main(String[] args) {
        Iterator<ThemColor> iterator = ThemColor.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
