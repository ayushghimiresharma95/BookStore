package fi.haagaHelia.BookStore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagaHelia.BookStore.Domain.Book;






@Controller
public class BookController {

    List<Book> books = new ArrayList<Book>() ;

    @GetMapping("/index")
    public String AddingBooks(Model model) {
        model.addAttribute("books", new Book()) ;
        return "BookForm" ;
    }    
    @PostMapping("/index")
    public String postBooks( @ModelAttribute Book book, Model model){
        
        this.books.add(book) ;
        model.addAttribute("books", this.books) ;
        return "BookTable" ;
    }
}
