package fi.haagaHelia.BookStore.Domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Book {
    
	
    @Size(min=5, max=30)
    private String title ;

    @Size(min=5, max=30)
    private String author ;
    private int year ;
    private int price ;

    @NotNull
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
    public int getYear(){
        return this.year ;
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
