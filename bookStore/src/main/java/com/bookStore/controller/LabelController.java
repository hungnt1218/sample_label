package com.bookStore.controller;

import com.bookStore.entity.Label;
import com.bookStore.entity.Sample;
import com.bookStore.request.SearchLabelRequest;
import com.bookStore.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class LabelController {


    @Autowired
    private LabelService service;



//    @GetMapping("/book_register")
//    public String bookRegister() {
//        return "bookRegister";
//    }

    @GetMapping("/getAllLabel")
    public ModelAndView getAllLabel(SearchLabelRequest request) {
        List<Label> list=service.getAllLabel(request);
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
        return new ModelAndView("LabelList","label",list);
    }

    @PostMapping("/saveLabel")
    public String addBook(@ModelAttribute Label b) {
        b.setCreateAt(b.getCreateAt());
        b.setCreateBy(b.getCreateBy());
        b.setUpdateAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        b.setUpdateBy("Phạm Trần Đức");
        service.save(b);
        return "redirect:/getAllLabel";
    }
    @GetMapping("/createNewLabel")
    public String createNewLabel() {
        return "CreateLabel";
    }
//    @GetMapping("/my_books")
//    public String getMyBooks(Model model)
//    {
//        List<MyBookList>list=myBookService.getAllMyBooks();
//        model.addAttribute("book",list);
//        return "myBooks";
//    }
//    @RequestMapping("/mylist/{id}")
//    public String getMyList(@PathVariable("id") int id) {
//        Book b=service.getBookById(id);
//        MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
//        myBookService.saveMyBooks(mb);
//        return "redirect:/my_books";
//    }
//
    @RequestMapping("/editLabel/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        Label b=service.getLabelById(id);
        model.addAttribute("label",b);
        return "LabelEdit";
    }

    @RequestMapping("/deleteLabel/{id}")
    public String deleteBook(@PathVariable("id")Long id) {
        service.deleteById(id);
        return "redirect:/getAllLabel";
    }


}
