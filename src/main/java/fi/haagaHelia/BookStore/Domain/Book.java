package fi.haagaHelia.BookStore.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String title ;
    private String author ;
    private int years ;
    private int price ;
    private int isbn ;

    public String getTitle() {
        return this.title ;
    }
    public String getAuthor() {
        return this.author ;
    }
    public int getPrice(){
        return this.price ;
    }
    public int getIsbn() {
        return this.isbn ;
    }
    public int getYears(){
        return this.years ;
    }
    public void setAuthor(String author){
        this.author = author ;
    }
    public void setTitle(String title){
        this.title = title ;
    }
    public void setISBN(int isbn){
        this.isbn = isbn ;
    }
    public void setPrice(int price){
        this.price = price ;
    }
    public void setYear(int year){
        this.year = year ;
    }
  
	
	@Override
	public String toString() {
		return "Message [msg=" + "]";
	}
}
