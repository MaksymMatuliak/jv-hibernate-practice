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

        Genre genre = new Genre();
        genre.setGenre("Fantasy");
        GenreService genreService = (GenreService) injector.getInstance(GenreService.class);
        genreService.add(genre);

        Book book = new Book();
        book.setTitle("Dragons");
        book.setDescription("It's about dragons");
        book.setAuthor(author);
        book.setGenre(genre);
        BookService bookService = (BookService) injector.getInstance(BookService.class);
        bookService.add(book);

        bookService.getAll().stream().forEach(System.out::println);
    }
}
