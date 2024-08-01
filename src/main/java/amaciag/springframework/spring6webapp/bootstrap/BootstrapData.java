package amaciag.springframework.spring6webapp.bootstrap;

import amaciag.springframework.spring6webapp.domain.Author;
import amaciag.springframework.spring6webapp.domain.Book;
import amaciag.springframework.spring6webapp.domain.Publisher;
import amaciag.springframework.spring6webapp.repositories.AuthorRepository;
import amaciag.springframework.spring6webapp.repositories.BookRepository;
import amaciag.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Smith");

        Book book = new Book();
        book.setTitle("The Book");
        book.setIsbn("4321");

        Author johnSaved = authorRepository.save(author);
        Book theBookSaved = bookRepository.save(book);

        Author daniel  = new Author();
        daniel.setFirstName("Daniel");
        daniel.setLastName("Smith");

        Book lotr = new Book();
        lotr.setTitle("Lotr");
        lotr.setIsbn("1234");

        Author danieSaved = authorRepository.save(daniel);
        Book lotrSaved = bookRepository.save(lotr);


        johnSaved.getBooks().add(theBookSaved);
        daniel.getBooks().add(lotrSaved);

        Publisher danielPublisher = new Publisher();
        danielPublisher.setPublisherName("Daniel Publisher");
        danielPublisher.setCity("Wroclaw");
        danielPublisher.setAddress("John Street 42");
        danielPublisher.setZipCode("11-111");
        danielPublisher.setState("LUB");

        Publisher savedpublisher = publisherRepository.save(danielPublisher);
        lotrSaved.setPublisher(savedpublisher);
        theBookSaved.setPublisher(savedpublisher);


        authorRepository.save(johnSaved);
        authorRepository.save(daniel);
        bookRepository.save(lotrSaved);
        bookRepository.save(theBookSaved);





        System.out.println("Bootstrap init");
        System.out.println("Author Count " + authorRepository.count());
        System.out.println("Book Count " + bookRepository.count());
        System.out.println("Publisher Count " + publisherRepository.count());


    }
}
