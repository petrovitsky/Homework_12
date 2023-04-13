package com.goit.todolist.note;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;


    @GetMapping("/list")
    public ModelAndView getNotesList() {
        final ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public ModelAndView getEditById(@RequestParam(name = "id", required = true) Long id) {
        final ModelAndView modelAndView = new ModelAndView("edit-note");
        modelAndView.addObject("note", noteService.getById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String postEditById(@RequestParam(name = "id") Long id, @RequestParam(name = "title") String title,
                               @RequestParam(name = "content") String content) {
        noteService.update(new Note(id, title, content));
        return "redirect:/note/list";
    }
}
