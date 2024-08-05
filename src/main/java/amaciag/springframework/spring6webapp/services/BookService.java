package amaciag.springframework.spring6webapp.services;

import amaciag.springframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();


}
