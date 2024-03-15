package fi.haagaHelia.BookStore;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.isNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import fi.haagaHelia.BookStore.Domain.Book;
import fi.haagaHelia.BookStore.Domain.BookstoreRepositary;
import fi.haagaHelia.BookStore.Domain.Category;
import fi.haagaHelia.BookStore.Domain.CategoryRepositary;

@SpringBootTest(classes = BookStoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE )
public class BookStoreTest {
    @Autowired
	private BookstoreRepositary BRepositary ;

	@Autowired
	private CategoryRepositary cRepositary ;



	@Test
	public void findByAuthorShouldReturnBook() throws Exception {
		List<Book> books = BRepositary.findByAuthor("jk rowling") ;
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("harry potter") ;
		
	}
	@Test
	public void createNewBook(){
		Category category = new Category("fiction") ;
		cRepositary.save(category);
		Book book = new Book("the perk of being a wallpaper", "stephen chbosky", "1997", "23", "223", category);
		BRepositary.save(book);
		assertThat(book.getId()).isNotNull() ;

	}
	@Test
	public void deleteNewBook(){
		List<Book> bookList = BRepositary.findByAuthor("jk rowling");
		Book book = bookList.get(0) ;
		BRepositary.delete(book);
		List<Book> newBookList = BRepositary.findByAuthor("jk rowling");
		assertThat(newBookList).hasSize(0);
	}
	
	

}