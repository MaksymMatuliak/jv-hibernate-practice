package hibernate.practice.service.impl;

import hibernate.practice.dao.AuthorDao;
import hibernate.practice.lib.Inject;
import hibernate.practice.lib.Service;
import hibernate.practice.model.Author;
import hibernate.practice.service.AuthorService;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Inject
    AuthorDao authorDao;

    @Override
    public Author add(Author author) {
        return authorDao.add(author);
    }

    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }
}
