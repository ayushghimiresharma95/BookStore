package fi.haagaHelia.BookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagaHelia.BookStore.Domain.Book;
import fi.haagaHelia.BookStore.Domain.Category;
import fi.haagaHelia.BookStore.Domain.CategoryRepositary;
import fi.haagaHelia.BookStore.Domain.BookstoreRepositary;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(BookstoreRepositary repositary,CategoryRepositary cRepositary ){
		return (args) -> {
			Category category1 = new Category("Action") ;
			Category category2 = new Category("Romance") ;
			Category category3 = new Category("thriller") ;

			cRepositary.save(category1);
			cRepositary.save(category2) ;
			cRepositary.save(category3) ;
			 
			Book b1 = new Book("the perk of being a wallpaper", "stephen chbosky", "1997", "23", "223", category1);
			Book b2 = new Book("harry potter", "jk rowling", "1997", "34", "334",category2);
			Book b3 = new Book("War and peace", "leo tolstoy", "1997", "223", "345",category3);
			repositary.save(b1);
			repositary.save(b2);
			repositary.save(b3);


		};
	}

}
