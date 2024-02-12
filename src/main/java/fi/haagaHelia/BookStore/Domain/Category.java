package fi.haagaHelia.BookStore.Domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;


@Entity
public class Category {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private long id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category") 
    private List<Book> books ;

    
    
    public Category() {
    }
    public Category(String name) {
        super() ;
        this.name = name;
    }
    public List<Book> getBook() {
        return books;
    }

    public void setBook(List<Book> book) {
        this.books = book;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 
    @Override
    public String toString() {
        return "Category [id=" + id + ", books=" + books + ", name=" + name + "]";
    }

}
