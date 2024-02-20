package fi.haagaHelia.BookStore.Domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepositary extends CrudRepository<Category,Long> {
    List<Category> findByCategoryid(long categoryid);
}