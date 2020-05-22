package hibernate.practice.dao;

import hibernate.practice.model.Genre;
import java.util.List;

public interface GenreDao {
    Genre add(Genre genre);

    List<Genre> getAll();
}
