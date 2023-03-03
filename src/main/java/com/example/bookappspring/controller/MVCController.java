package com.example.bookappspring.controller;

import com.example.bookappspring.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("com")
public class MVCController {

    private final BookService bookService;

    public MVCController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/web")
    public String showBooks(Model model){
        model.addAttribute("books", bookService.getBook());
        return "bookapp";
    }
}
