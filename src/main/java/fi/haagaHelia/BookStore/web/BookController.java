package fi.haagaHelia.BookStore.web;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagaHelia.BookStore.Domain.Book;
import fi.haagaHelia.BookStore.Domain.BookstoreRepositary;
import fi.haagaHelia.BookStore.Domain.CategoryRepositary;


@Controller
public class BookController {

    @Autowired
    private BookstoreRepositary repositary;
    @Autowired
    private CategoryRepositary cRepositary;

    @GetMapping("/index")
    public String AddingBooks(Model model) {
        model.addAttribute("books", new Book());
        return "BookForm";
    }

    @GetMapping("/booklist")
    public String getBooklist(Model model) {
        model.addAttribute("booklist", repositary.findAll());
        return "booklist";
    }
    @GetMapping("/book")
    public @ResponseBody List<Book> getBooks(){
        return (List<Book>) repositary.findAll() ;
    }
    @GetMapping("/BookId/{id}")
    public @ResponseBody  Optional<Book> getBooksByID(@PathVariable("id") Long studentId){
        return repositary.findById(studentId);
    }


    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repositary.deleteById(bookId);
        return "redirect:../booklist";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categorys",cRepositary.findAll());
        return "addBook";
    }

    @PostMapping("/save")
    public String savebook(Book book) {
        System.out.println(book.getId());
        repositary.save(book);
        return "redirect:booklist";
    }
    
    

    @GetMapping("/edit/{id}")
    public String getBookById(@PathVariable("id") Long bookId, Model model) {
        Book book = repositary.findById(bookId).orElse(null);
        
        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("categorys",cRepositary.findAll() );
            
            return "editBook";
        } else {
            return "redirect:/booklist";
        }
    }
}
