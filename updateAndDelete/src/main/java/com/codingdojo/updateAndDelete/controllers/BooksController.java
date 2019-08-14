package com.codingdojo.updateAndDelete.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.updateAndDelete.models.Book;
import com.codingdojo.updateAndDelete.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService;
	
	public BooksController(BookService bookService) {
		this.bookService = bookService;
		
	}
	////////////// Home Page /////////////////////////
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> book = bookService.allBooks();
		model.addAttribute("books", book);
		return "/books/index.jsp";
	}
	///////////// New Book Route///////////////////////
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
///////////// New Book Function///////////////////////
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
///////////// Show Book Route///////////////////////
    @RequestMapping("/books/{book_id}/show")
    public String show(@ModelAttribute("book_id") Long id, Model model) {
    	Book book = bookService.findBook(id);
    	model.addAttribute("book", book);
    	return "books/show.jsp";
    }
/////////////// Update Book Route///////////////////////
    @RequestMapping("/books/{book_id}/update")
    public String update(@PathVariable("book_id") Long id, Model model) {
    	Book book = bookService.findBook(id);
    	model.addAttribute("update_book", book);
    	return "/books/update.jsp";
    }
    
////////////// Update Book Function////////////////////
@RequestMapping(value="/books/{book_id}", method=RequestMethod.POST)
public String update(@Valid @ModelAttribute("update_book") Book book, BindingResult result) {
    if (result.hasErrors()) {
        return "/books/update.jsp";
    } else {
        bookService.updateBook(book);
        return "redirect:/books";
    }
}
@RequestMapping("/books/{book_id}/delete")
public String deleteBook(@PathVariable("book_id") Long id) {
	bookService.deleteBook(id);
	return "redirect:/books";
}
}
