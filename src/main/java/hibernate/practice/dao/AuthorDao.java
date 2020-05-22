package hibernate.practice.dao;

import hibernate.practice.model.Author;
import java.util.List;

public interface AuthorDao {
    Author add(Author author);

    List<Author> getAll();
}
