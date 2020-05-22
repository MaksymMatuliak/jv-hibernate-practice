package hibernate.practice.dao.impl;

import hibernate.practice.dao.GenreDao;
import hibernate.practice.exceptions.DataProcessingException;
import hibernate.practice.lib.Dao;
import hibernate.practice.model.Genre;
import hibernate.practice.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class GenreDaoImpl implements GenreDao {
    @Override
    public Genre add(Genre genre) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long authorId = (Long) session.save(genre);
            transaction.commit();
            genre.setGenreId(authorId);
            return genre;
        } catch (Exception e) {
            throw new DataProcessingException("Can't add author to DB", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Genre> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Genre> criteriaQuery =
                    session.getCriteriaBuilder().createQuery(Genre.class);
            criteriaQuery.from(Genre.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get genres", e);
        }
    }
}
