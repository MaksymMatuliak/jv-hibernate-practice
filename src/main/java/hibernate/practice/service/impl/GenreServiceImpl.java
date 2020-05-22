package hibernate.practice.service.impl;

import hibernate.practice.dao.GenreDao;
import hibernate.practice.lib.Inject;
import hibernate.practice.lib.Service;
import hibernate.practice.model.Genre;
import hibernate.practice.service.GenreService;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Inject
    GenreDao genreDao;

    @Override
    public Genre add(Genre genre) {
        return genreDao.add(genre);
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }
}
