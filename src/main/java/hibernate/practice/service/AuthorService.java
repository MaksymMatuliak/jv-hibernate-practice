package hibernate.practice.service;

import hibernate.practice.model.Author;
import java.util.List;

public interface AuthorService {
    Author add(Author author);

    List<Author> getAll();
}
