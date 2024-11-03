package task04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Storage {

    public static List<Book> getCountBooksFromStorage(int count){
        List<Book> books = getAllBooksFromStorage();
        int fromIndex = new Random().nextInt(books.size() - count);
        return books.subList(fromIndex, fromIndex + count);
    }

    public static List<Book> getAllBooksFromStorage(){
        List<Book> books = new ArrayList<>();
        // Добавляем 50 книг (сгенерированно по шаблону ЖПТ)
        books.add(new Book("1984", "George Orwell", 1949));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        books.add(new Book("Moby Dick", "Herman Melville", 1851));
        books.add(new Book("War and Peace", "Leo Tolstoy", 1869));
        books.add(new Book("Pride and Prejudice", "Jane Austen", 1813));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        books.add(new Book("Fahrenheit 451", "Ray Bradbury", 1953));
        books.add(new Book("Brave New World", "Aldous Huxley", 1932));
        books.add(new Book("The Picture of Dorian Gray", "Oscar Wilde", 1890));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866));
        books.add(new Book("The Brothers Karamazov", "Fyodor Dostoevsky", 1880));
        books.add(new Book("The Grapes of Wrath", "John Steinbeck", 1939));
        books.add(new Book("The Old Man and the Sea", "Ernest Hemingway", 1952));
        books.add(new Book("The Road", "Cormac McCarthy", 2006));
        books.add(new Book("The Alchemist", "Paulo Coelho", 1988));
        books.add(new Book("The Kite Runner", "Khaled Hosseini", 2003));
        books.add(new Book("The Book Thief", "Markus Zusak", 2005));
        books.add(new Book("The Fault in Our Stars", "John Green", 2012));
        books.add(new Book("Life of Pi", "Yann Martel", 2001));
        books.add(new Book("The Da Vinci Code", "Dan Brown", 2003));
        books.add(new Book("The Hunger Games", "Suzanne Collins", 2008));
        books.add(new Book("The Chronicles of Narnia", "C.S. Lewis", 1950));
        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997));
        books.add(new Book("The Little Prince", "Antoine de Saint-Exup?ry", 1943));
        books.add(new Book("The Secret Garden", "Frances Hodgson Burnett", 1911));
        books.add(new Book("Anne of Green Gables", "L.M. Montgomery", 1908));
        books.add(new Book("Wuthering Heights", "Emily Bront?", 1847));
        books.add(new Book("Jane Eyre", "Charlotte Bront?", 1847));
        books.add(new Book("The Bell Jar", "Sylvia Plath", 1963));
        books.add(new Book("The Handmaid's Tale", "Margaret Atwood", 1985));
        books.add(new Book("The Color Purple", "Alice Walker", 1982));
        books.add(new Book("The Road Less Traveled", "M. Scott Peck", 1978));
        books.add(new Book("The Art of War", "Sun Tzu", -500));
        books.add(new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 2011));
        books.add(new Book("Educated", "Tara Westover", 2018));
        books.add(new Book("Becoming", "Michelle Obama", 2018));
        books.add(new Book("Where the Crawdads Sing", "Delia Owens", 2018));
        books.add(new Book("The Silent Patient", "Alex Michaelides", 2019));
        books.add(new Book("The Vanishing Half", "Brit Bennett", 2020));
        books.add(new Book("Circe", "Madeline Miller", 2018));
        books.add(new Book("The Midnight Library", "Matt Haig", 2020));
        books.add(new Book("Daisy Jones & The Six", "Taylor Jenkins Reid", 2019));
        books.add(new Book("The Seven Husbands of Evelyn Hugo", "Taylor Jenkins Reid", 2017));
        books.add(new Book("The Invisible Man", "H.G. Wells", 1897));
        books.add(new Book("The Time Machine", "H.G. Wells", 1895));
        books.add(new Book("The War of the Worlds", "H.G. Wells", 1898));
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979));
        books.add(new Book("The Martian", "Andy Weir", 2011));
        books.add(new Book("Ready Player One", "Ernest Cline", 2011));
        books.add(new Book("The Night Circus", "Erin Morgenstern", 2011));
        books.add(new Book("Station Eleven", "Emily St. John Mandel", 2014));
        books.add(new Book("The Goldfinch", "Donna Tartt", 2013));
        books.add(new Book("A Gentleman in Moscow", "Amor Towles", 2016));
        books.add(new Book("The Overstory", "Richard Powers", 2018));
        books.add(new Book("Normal People", "Sally Rooney", 2018));
        books.add(new Book("Anxious People", "Fredrik Backman", 2020));
        books.add(new Book("The Guest List", "Lucy Foley", 2020));
        books.add(new Book("The Chain", "Adrian McKinty", 2019));
        books.add(new Book("The Woman in the Window", "A.J. Finn", 2018));
        books.add(new Book("Big Little Lies", "Liane Moriarty", 2014));
        books.add(new Book("The Girl on the Train", "Paula Hawkins", 2015));
        books.add(new Book("Gone Girl", "Gillian Flynn", 2012));
        books.add(new Book("The Couple Next Door", "Shari Lapena", 2016));
        books.add(new Book("The Wife Between Us", "Greer Hendricks & Sarah Pekkanen", 2018));
        books.add(new Book("The Last Thing He Told Me", "Laura Dave", 2021));
        books.add(new Book("Malibu Rising", "Taylor Jenkins Reid", 2021));
        books.add(new Book("The Paper Palace", "Miranda Cowley Heller", 2021));
        books.add(new Book("The Song of Achilles", "Madeline Miller", 2011));
        return books;
    }
}
