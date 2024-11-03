package task04;

import java.util.*;

public class Library {
    private Map<Book, Integer> library = new HashMap<>();

    public Library(){}
    public Library(Collection<Book> books){
        this(books, 0);
    }
    public Library(Collection<Book> books, int shelf){
        addAllBooksOnShelf(books, shelf);
    }

    public void changeShelf(Book book, int shelf){
        addBookOnShelf(book, shelf);
    }

    public void addBookOnShelf(Book book, int shelf){
        library.put(book, shelf);
    }
    public void addAllBooksOnShelf(Collection<Book> books, int shelf) {
        for (Book book : books){
            addBookOnShelf(book, shelf);
        }
    }

    public int getShelfByBook(Book book){
        return library.get(book);
    }

    public List<Book> getBooksByShelf(int onShelf){
        List<Book> resultList = new ArrayList<>();
        library.forEach((book, shelf) -> {
            if(shelf == onShelf) resultList.add(book);
        });
        return resultList;
    }

    public Set<Book> getAllBooks(){
        return library.keySet();
    }

    public Set<Integer> getAllShelves(){
        return new HashSet<Integer>(library.values());
    }

    public Map<Book, Integer> getAllLibrary(){
        return new HashMap<>(library);
    }

    public int deleteBook(Book book){
        return library.remove(book);
    }

    @Override
    public String toString() {
        String splitter = "=======================================\n";
        String splitterFromNewString = "\n" + splitter;
        StringBuilder resultStr = new StringBuilder(splitter);

        Set<Integer> shelves = getAllShelves();
        resultStr.append(String.format("Library has %d shelves: \n", shelves.size()));
        resultStr.append(shelves);
        resultStr.append(splitterFromNewString);

        Set<Book> allBooks = getAllBooks();
        resultStr.append(String.format("Library has %d books: \n", allBooks.size()));
        resultStr.append(allBooks);
        resultStr.append(splitterFromNewString);

        resultStr.append("Books on Shelves:");
        for (Integer shelf : shelves){
            List<Book> books = getBooksByShelf(shelf);
            resultStr.append(String.format("\nShelf [%d] has %d books: ", shelf, books.size()));
            resultStr.append(books);
        }
        resultStr.append(splitterFromNewString);
        return resultStr.toString();
    }
}
