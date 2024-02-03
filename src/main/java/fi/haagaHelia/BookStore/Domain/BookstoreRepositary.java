package fi.haagaHelia.BookStore.Domain;

import org.springframework.data.repository.CrudRepository;

public interface BookstoreRepositary extends CrudRepository<Book,Long> {

    
} 