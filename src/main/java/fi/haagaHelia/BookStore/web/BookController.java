package fi.haagaHelia.BookStore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fi.haagaHelia.BookStore.Domain.Book;
import fi.haagaHelia.BookStore.Domain.BookstoreRepositary;






@Controller
public class BookController {

    @Autowired
    private BookstoreRepositary respositary ;

    @GetMapping("/index")
    public String AddingBooks(Model model) {
        model.addAttribute("books", new Book()) ;
        return "BookForm" ;
    }    
    
    @GetMapping("/booklist")
    public String getBooklist(Model model){
        model.addAttribute("booklist", respositary.findAll());
        return "Booklist" ;
    }
}
