package hibernate.practice.service.impl;

import hibernate.practice.dao.BookDao;
import hibernate.practice.lib.Inject;
import hibernate.practice.lib.Service;
import hibernate.practice.model.Author;
import hibernate.practice.model.Book;
import hibernate.practice.model.Genre;
import hibernate.practice.service.BookService;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Inject
    BookDao bookDao;

    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return bookDao.getBookByTitle(title);
    }

    @Override
    public List<Book> getListOfBooksByAuthor(Author author) {
        return bookDao.getListOfBooksByAuthor(author);
    }

    @Override
    public List<Book> getAllBooksByGenre(Genre genre) {
        return bookDao.getAllBooksByGenre(genre);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
