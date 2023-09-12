package CollectionFramework.IteratorAndListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class CustomList<T> implements Iterable<T> {

    private List<T> internalList = new ArrayList<>();

    public void add(T item) {
        internalList.add(item);
    }

    public int size() {
        return internalList.size();
    }

    public T get(int index) {
        return internalList.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    public ListIterator<T> listIterator() {
        return new CustomListIterator();
    }

    private class CustomIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return get(currentIndex++);
        }
    }

    private class CustomListIterator implements ListIterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return get(currentIndex++);
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            return get(--currentIndex);
        }

        @Override
        public int nextIndex() {
            return currentIndex;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported");
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException("set() is not supported");
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException("add() is not supported");
        }

    }

}

class Example {

    public static void main(String[] args) {

        CustomList<String> customList = new CustomList<>();
        customList.add("Item 1");
        customList.add("Item 2");
        customList.add("Item 3");
        customList.add("Item 4");
        customList.add("Item 5");

        Iterator<String> iterator = customList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        ListIterator<String> listIterator = customList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
