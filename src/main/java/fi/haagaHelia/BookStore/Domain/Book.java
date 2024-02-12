package fi.haagaHelia.BookStore.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String author;
    private String years;
    private String price;
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
    }

    public Book(String title, String author, String years, String price, String isbn) {
        this.title = title;
        this.author = author;
        this.years = years;
        this.price = price;
        this.isbn = isbn;
    }

    public Book(String title, String author, String years, String price, String isbn, Category category) {
        this.title = title;
        this.author = author;
        this.years = years;
        this.price = price;
        this.isbn = isbn;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrice() {
        return price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        if (this.category != null) {
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", years=" + years + ", price="
                    + price
                    + ", isbn=" + isbn + ", category=" + category + "]";
        } else
            return "Book [id=" + id + ", title=" + title + ", author=" + author + ", years=" + years + ", price="
                    + price
                    + ", isbn=" + isbn + "]";
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
