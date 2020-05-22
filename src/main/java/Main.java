import hibernate.practice.lib.Injector;
import hibernate.practice.model.Author;
import hibernate.practice.model.Book;
import hibernate.practice.model.Genre;
import hibernate.practice.service.AuthorService;
import hibernate.practice.service.BookService;
import hibernate.practice.service.GenreService;

public class Main {
    private static Injector injector = Injector.getInstance("hibernate.practice");

    public static void main(String[] args) {
        Author author = new Author();
        author.setName("Maks");
        author.setAge(19);
        AuthorService authorService = (AuthorService) injector.getInstance(AuthorService.class);
        authorService.add(author);

        Author author2 = new Author();
        author2.setName("Ivan");
        author2.setAge(54);
        authorService.add(author2);

        Genre genre = new Genre();
        genre.setGenre("Fantasy");
        GenreService genreService = (GenreService) injector.getInstance(GenreService.class);
        genreService.add(genre);

        Genre genre2 = new Genre();
        genre2.setGenre("Science");
        genreService.add(genre2);

        Book book = new Book();
        book.setTitle("Dragons");
        book.setDescription("It's about dragons");
        book.setAuthor(author);
        book.setGenre(genre);
        BookService bookService = (BookService) injector.getInstance(BookService.class);
        bookService.add(book);

        Book book2 = new Book();
        book2.setTitle("Sci");
        book2.setDescription("It's about physic");
        book2.setAuthor(author2);
        book2.setGenre(genre2);
        bookService.add(book2);

        Book book3 = new Book();
        book3.setTitle("Somethin");
        book3.setDescription("It's about something");
        book3.setAuthor(author);
        book3.setGenre(genre2);
        bookService.add(book3);

        bookService.getAll().stream().forEach(System.out::println);
    }
}
