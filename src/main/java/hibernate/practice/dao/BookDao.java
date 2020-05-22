package hibernate.practice.dao;

import hibernate.practice.model.Author;
import hibernate.practice.model.Book;
import hibernate.practice.model.Genre;
import java.util.List;

public interface BookDao {
    Book add(Book book);

    List<Book> getBookByTitle (String title);

    List<Book> getListOfBooksByAuthor (Author author);

    List<Book> getAllBooksByGenre (Genre genre);

    List<Book> getAll();
}
