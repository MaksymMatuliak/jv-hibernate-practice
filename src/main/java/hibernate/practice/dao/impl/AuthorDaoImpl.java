package hibernate.practice.dao.impl;

import hibernate.practice.dao.AuthorDao;
import hibernate.practice.exceptions.DataProcessingException;
import hibernate.practice.lib.Dao;
import hibernate.practice.model.Author;
import hibernate.practice.model.Genre;
import hibernate.practice.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author add(Author author) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long authorId = (Long) session.save(author);
            transaction.commit();
            author.setAuthorId(authorId);
            return author;
        } catch (Exception e) {
            throw new DataProcessingException("Can't add author to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Author> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Author> criteriaQuery =
                    session.getCriteriaBuilder().createQuery(Author.class);
            criteriaQuery.from(Author.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get authors", e);
        }
    }
}
