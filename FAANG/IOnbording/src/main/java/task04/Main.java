//2024.11.03
//HashMap: Библиотека Вестероса
package task04;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String splitter = "-------------------------------";
        List<Book> books = Storage.getCountBooksFromStorage(10);

        Library myLibrary = new Library(books);
        System.out.println(myLibrary);


        System.out.println(splitter);
        System.out.println("Rearrange the books on the shelves");
        System.out.println(splitter);

        int sizeOfBooksList = books.size();
        final int MAX_COUNT_OF_SHELVES = sizeOfBooksList / 2;
        for (int i = 0; i < sizeOfBooksList; i++){
            myLibrary.changeShelf(books.get(i), i % MAX_COUNT_OF_SHELVES);
        }
        System.out.println(myLibrary);


        System.out.println(splitter);
        System.out.println("Remove a half books");
        System.out.println(splitter);

        for (int i = 1; i < sizeOfBooksList; i += 2){
            myLibrary.deleteBook(books.get(i));
        }
        System.out.println(myLibrary);



    }
}
