package com.bookStore.controller;

import com.bookStore.entity.Sample;
import com.bookStore.service.SampleService;
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
public class SampleController {


    @Autowired
    private SampleService service;


//    @GetMapping("/book_register")
//    public String bookRegister() {
//        return "bookRegister";
//    }

    @GetMapping("/getAllSample")
    public ModelAndView getAllSample() {
        List<Sample> list=service.getAllSample();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
        return new ModelAndView("SampleList","sample",list);
    }

    @GetMapping("/createNewSample")
    public String bookRegister() {
        return "CreateSample";
    }
    @PostMapping("/saveNewSample")
    public String addBook(@ModelAttribute Sample b) {
        b.setCreateAt(b.getCreateAt());
        b.setCreateBy(b.getCreateBy());
        b.setUpdateAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        b.setUpdateBy("Phạm Trần Đức");
        return "redirect:/getAllSample";
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
    @RequestMapping("/editSample/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Sample b=service.getSampleById(id);
        model.addAttribute("sample",b);
        return "SampleEdit";
    }
    @RequestMapping("/deleteSample/{id}")
    public String deleteSample(@PathVariable("id")Long id) {
        service.deleteById(id);
        return "redirect:/getAllSample";
    }
}
