package hibernate.practice.dao.impl;

import hibernate.practice.dao.BookDao;
import hibernate.practice.exceptions.DataProcessingException;
import hibernate.practice.lib.Dao;
import hibernate.practice.model.Author;
import hibernate.practice.model.Book;
import hibernate.practice.model.Genre;
import hibernate.practice.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class BookDaoImpl implements BookDao {
    @Override
    public Book add(Book book) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long authorId = (Long) session.save(book);
            transaction.commit();
            book.setBookId(authorId);
            return book;
        } catch (Exception e) {
            throw new DataProcessingException("Can't add book to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
            Query query = sesion.createQuery("FROM Book WHERE title = :titleOfBook");
            query.setParameter("titleOfBook", title);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get book by title", e);
        }
    }

    @Override
    public List<Book> getListOfBooksByAuthor(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Book WHERE book.author = :author");
            query.setParameter("author", author);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get list of books by author", e);
        }
    }

    @Override
    public List<Book> getAllBooksByGenre(Genre genre) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Book WHERE genre = :genre");
            query.setParameter("genre", genre);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get list of books by genre", e);
        }
    }

    @Override
    public List<Book> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Book> criteriaQuery =
                    session.getCriteriaBuilder().createQuery(Book.class);
            criteriaQuery.from(Book.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get books", e);
        }
    }
}
