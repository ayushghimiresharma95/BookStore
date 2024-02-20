package fi.haagaHelia.BookStore.Domain;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BookstoreRepositary extends CrudRepository<Book,Long> {

    List<Book> findByAuthor(String author) ;
   
} 