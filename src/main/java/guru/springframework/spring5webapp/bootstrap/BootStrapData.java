package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author tolkien = new Author("JRR", "Tolkien");
        Book lotr = new Book("Seigneur des Anneaux : la communeautée de l'Anneau", "152469");
        tolkien.getBooks().add(lotr);
        lotr.getAuthors().add(tolkien);

        authorRepository.save(tolkien);
        bookRepository.save(lotr);

        Author dick = new Author("PK", "Dick");
        Book ubik = new Book("Ubik", "152467");
        dick.getBooks().add(ubik);
        ubik.getAuthors().add(dick);

        authorRepository.save(dick);
        bookRepository.save(ubik);

        System.out.println("Number of books : " + bookRepository.count());

    }
}
