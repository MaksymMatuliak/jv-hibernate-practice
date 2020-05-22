package hibernate.practice.service;

import hibernate.practice.model.Genre;
import java.util.List;

public interface GenreService {
    Genre add(Genre genre);

    List<Genre> getAll();
}
