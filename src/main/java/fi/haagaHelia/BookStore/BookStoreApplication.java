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
	public CommandLineRunner demo(BookstoreRepositary repositary) {
		return (args) -> {
			Book b1 = new Book("the perk of being a wallpaper", "stephen chbosky", 1999, 23, 7223);
		Book b2 = new Book("harry potter", "jk rowling", 1997, 23, 7224);
		Book b3 = new Book("War and peace", "leo tolstoy", 1868, 34, 7225);
		repositary.save(b1) ;
		repositary.save(b2) ;
		repositary.save(b3) ;
		};
	}

}
