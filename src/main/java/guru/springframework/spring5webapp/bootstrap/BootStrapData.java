package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository pubRepo) {
        this.authorRepository = authorRepo;
        this.bookRepository = bookRepo;
        this.publisherRepository = pubRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pub = new Publisher("shru", "asdf", "mdu", "tn", "123");
        publisherRepository.save(pub);


        Author eric = new Author("Eric", "Evans");
        Book b = new Book("Freakanomics", "19394", pub);
        eric.getBooks().add(b);
        b.getAuthors().add(eric);
        pub.getBooks().add(b);

        authorRepository.save(eric);
        bookRepository.save(b);

        Author rod = new Author("Rod", "Johnson");
        Book b2 = new Book("Effective Java", "1234", pub);
        rod.getBooks().add(b2);
        b2.getAuthors().add(rod);
        pub.getBooks().add(b2);
        authorRepository.save(rod);
        bookRepository.save(b2);



        System.out.println("Started in Bootstrap...");
        System.out.println("Number of books - "+ bookRepository.count());
        System.out.println("Number of publishers - "+ publisherRepository.count());
        System.out.println("Number of publishers book - "+ pub.getBooks().size());

    }
}
