package fi.haagaHelia.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagaHelia.BookStore.Domain.Book;
import fi.haagaHelia.BookStore.Domain.BookstoreRepositary;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

    @Bean
    CommandLineRunner demo(BookstoreRepositary repositary) {
		return (args) -> {
			Book b1 = new Book("the perk of being a wallpaper", "stephen chbosky", "1997", "23", "223");
		Book b2 = new Book("harry potter", "jk rowling", "1997", "34", "334");
		Book b3 = new Book("War and peace", "leo tolstoy", "1997", "223","345");
		repositary.save(b1) ;
		repositary.save(b2) ;
		repositary.save(b3) ;
		};
	}

}
